package samuelvalentini.collection;

import samuelvalentini.collection.boardgame.GiocoDaTavolo;
import samuelvalentini.collection.enumeration.Tipo;
import samuelvalentini.collection.videogame.Videogioco;
import samuelvalentini.collection.videogame.enumeration.Genere;

import java.util.*;
import java.util.stream.Collectors;

public abstract class Collezione {

    private static final List<Collezione> collection = new ArrayList<>();
    private static long idGiocoGenerator = 0;

    private final long idGioco;
    private final Tipo tipo;
    private String titolo;
    private int annoPubblicazione;
    private double prezzo;


    public Collezione(String titolo, int annoPubblicazione, double prezzo, Tipo tipo) {

        if (collection.stream().allMatch(el -> el.getIdGioco() != getIdGiocoGenerator() + 1)) {
            this.idGioco = ++idGiocoGenerator;
        } else {
            ++idGiocoGenerator;
            throw new IllegalArgumentException("Errore nella generazione dell'id");
        }

        if (titolo == null || titolo.isBlank()) {
            throw new IllegalArgumentException("Il titolo deve contenere almeno un carattere");
        } else {
            this.titolo = titolo;
        }

        this.annoPubblicazione = annoPubblicazione;

        if (prezzo >= 0) {
            this.prezzo = prezzo;
        } else {
            throw new IllegalArgumentException("Il prezzo non può essere negativo, se è un regalo inserisci 0");
        }

        this.tipo = tipo;
    }

    public static List<Collezione> getCollection() {
        return collection;
    }

    public static long getIdGiocoGenerator() {
        return idGiocoGenerator;
    }

    // metodi richiesti

    // l'aggiunta di un elemento è gestita con il costruttore e non possono esserci
    // id duplicati in quanto l'id è basato su una variabile di classe che viene
    // incrementata, inoltre in previsione di un futuro in cui vengono importate
    // liste esterne è stato implementato un controllo ulteriore in sede di costruttore
    // per verificare l'univocità dell'id.

    // ricerca per ID

    public static Collezione ricercaPerId(long idGioco) {
        for (int i = 0; i < collection.size(); i++) {
            if (collection.get(i).idGioco == idGioco) {
                return collection.get(i);

            }
        }
        return null;
    }

    // ricerca per prezzo inferiore

    public static List<Collezione> ricercaPerPrezzoInferiore(double prezzo) {
        return collection.stream().filter(game -> game.getPrezzo() < prezzo).toList();
    }

    //ricerca per numero di giocatori

    public static List<GiocoDaTavolo> ricercaPerNumeroDiGiocatori(int numeroGiocatori) {
        return collection.stream().filter(game -> game.tipo == Tipo.BOARD_GAME).map(game -> (GiocoDaTavolo) game).filter(game -> game.getNumeroDiGiocatoriMinimo() <= numeroGiocatori && game.getNumeroDiGiocatoriMassimo() >= numeroGiocatori).toList();
    }

    //rimozione tramite id
    public static void rimozionePerId(long idGioco) {
        for (int i = 0; i < collection.size(); i++) {
            if (collection.get(i).idGioco == idGioco) {
                collection.remove(i);
                System.out.println("Elemento rimosso");
                break;
            }
        }

    }

    public static void aggiornaElementoPerId(long idGioco, String titolo, int annoPubblicazione, double prezzo) {
        Collezione item = ricercaPerId(idGioco);
        assert item != null;
        item.setTitolo(titolo);
        item.setAnnoPubblicazione(annoPubblicazione);
        item.setPrezzo(prezzo);
    }

    public static void aggiornaElementoPerId(long idGioco, String titolo, int annoPubblicazione) {
        Collezione item = ricercaPerId(idGioco);
        assert item != null;
        item.setTitolo(titolo);
        item.setAnnoPubblicazione(annoPubblicazione);

    }

    public static void aggiornaElementoPerId(long idGioco, String titolo) {
        Collezione item = ricercaPerId(idGioco);
        if (item != null) {
            item.setTitolo(titolo);
            System.out.println("Aggiornato");
        } else {
            System.out.println("Id non trovato");
        }

    }

    public static void aggiornaElementoPerId(long idGioco, String titolo, double prezzo) {
        Collezione item = ricercaPerId(idGioco);
        if (item != null) {
            item.setTitolo(titolo);
            item.setPrezzo(prezzo);
            System.out.println("Aggiornato");
        } else {
            System.out.println("Id non trovato");
        }
    }

    public static void aggiornaElementoPerId(long idGioco, int annoPubblicazione) {
        Collezione item = ricercaPerId(idGioco);
        assert item != null;
        item.setAnnoPubblicazione(annoPubblicazione);
    }

    public static void aggiornaElementoPerId(long idGioco, double prezzo) {
        Collezione item = ricercaPerId(idGioco);
        assert item != null;
        item.setPrezzo(prezzo);
    }


    public static void aggiornaElementoPerId(long idGioco, String titolo, int annoPubblicazione, double prezzo, int durataMediaPartita) {
        Collezione item = ricercaPerId(idGioco);
        assert item != null;
        item.setTitolo(titolo);
        item.setAnnoPubblicazione(annoPubblicazione);
        item.setPrezzo(prezzo);

        if (item instanceof GiocoDaTavolo gioco) {
            gioco.setDurataMediaPartita(durataMediaPartita);
        }
    }

    public static void aggiornaElementoPerId(long idGioco, String titolo, int annoPubblicazione, double prezzo, double durataDiGioco) {
        Collezione item = ricercaPerId(idGioco);
        assert item != null;
        item.setTitolo(titolo);
        item.setAnnoPubblicazione(annoPubblicazione);
        item.setPrezzo(prezzo);

        if (item instanceof Videogioco gioco) {
            gioco.setDurataDiGioco(durataDiGioco);
        }
    }

    public static void aggiornaElementoPerId(long idGioco, String titolo, int annoPubblicazione, double prezzo, double durataDiGioco, Genere genere) {
        Collezione item = ricercaPerId(idGioco);
        assert item != null;
        item.setTitolo(titolo);
        item.setAnnoPubblicazione(annoPubblicazione);
        item.setPrezzo(prezzo);

        if (item instanceof Videogioco gioco) {
            gioco.setDurataDiGioco(durataDiGioco);
            gioco.setGenere(genere);
        }
    }

    public static void aggiornaElementoPerId(long idGioco, Genere genere) {
        Collezione item = ricercaPerId(idGioco);
        assert item != null;

        if (item instanceof Videogioco gioco) {
            gioco.setGenere(genere);
        }
    }

    public static void stampaStatistiche() {
        if (collection.isEmpty()) {
            System.out.println("La tua collezione è vuota");
        } else {
            System.out.println();
            System.out.println("|" + "-".repeat(20) + "STATISTICHE DELLA TUA COLLEZIONE" + "-".repeat(20) + "|");
            System.out.println();
            Map<Tipo, Integer> quantity = collection.stream().collect(Collectors.groupingBy(Collezione::getTipo, Collectors.summingInt(game -> 1)));
            System.out.println("Videogame: " + quantity.get(Tipo.VIDEOGAME));
            System.out.println("Giochi da tavolo: " + quantity.get(Tipo.BOARD_GAME));
            System.out.println("Valore totale della collezione: " + String.format("%.2f", collection.stream().mapToDouble(Collezione::getPrezzo).sum()) + " €");
            Collezione mostValue = collection.stream().max(Comparator.comparingDouble(Collezione::getPrezzo)).orElse(null);
            if (mostValue != null) {
                System.out.println("Il tuo pezzo di maggior valore è " + mostValue.titolo + " dal prezzo di " + String.format("%.2f", mostValue.getPrezzo()) + " €");
            }
            OptionalDouble averagePrice = collection.stream().mapToDouble(game -> game.getPrezzo()).average();
            if (averagePrice.isPresent()) {
                System.out.println("La media del valore dei tuoi pezzi è " + String.format("%.2f", averagePrice.getAsDouble()) + " €");
            }
            System.out.println();
            System.out.println("|" + "-".repeat(25) + "STATISTICHE TERMINATE" + "-".repeat(26) + "|");
            System.out.println();
        }
    }

    public abstract void addToCollection();

    public long getIdGioco() {
        return idGioco;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        if (titolo == null || titolo.isBlank()) {
            throw new IllegalArgumentException("Il titolo deve contenere almeno un carattere");
        } else {
            this.titolo = titolo;
        }

    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        if (prezzo >= 0) {
            this.prezzo = prezzo;
        } else {
            throw new IllegalArgumentException("Il prezzo non può essere negativo, se è un regalo inserisci 0");
        }
    }

    public Tipo getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "id=" + idGioco +
                ", tipo=" + tipo +
                ", annoPubblicazione=" + annoPubblicazione +
                ", prezzo=" + prezzo + " ";
    }
}
