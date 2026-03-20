package samuelvalentini.collection;

import samuelvalentini.collection.boardgame.GiocoDaTavolo;
import samuelvalentini.collection.enumeration.Tipo;

import java.util.ArrayList;
import java.util.List;

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
                break;
            }
        }
        System.out.println("Id non trovato");

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
        ;
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
