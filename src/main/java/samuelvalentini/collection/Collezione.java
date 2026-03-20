package samuelvalentini.collection;

import samuelvalentini.collection.videogame.enumeration.Tipo;

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

    public abstract void addToCollection(Collezione daAggiungere);

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
}
