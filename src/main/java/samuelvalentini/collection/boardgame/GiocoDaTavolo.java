package samuelvalentini.collection.boardgame;

import samuelvalentini.collection.Collezione;
import samuelvalentini.collection.enumeration.Tipo;

import java.time.LocalDate;

public class GiocoDaTavolo extends Collezione {
    private final int numeroDiGiocatoriMinimo;
    private final int numeroDiGiocatoriMassimo;
    private int durataMediaPartita;

    public GiocoDaTavolo(String titolo, int annoPubblicazione, double prezzo, int numeroDiGiocatoriMinimo, int numeroDiGiocatoriMassimo, int durataMediaPartita) {
        super(titolo, yearChecker(annoPubblicazione), prezzo, Tipo.BOARD_GAME);
        if (numeroDiGiocatoriMinimo < 2 || numeroDiGiocatoriMinimo > 10) {
            throw new IllegalArgumentException("Verifica il numero dei giocatori, il range permesso è da 2 a 10");
        } else {
            this.numeroDiGiocatoriMinimo = numeroDiGiocatoriMinimo;
        }

        if (numeroDiGiocatoriMassimo < 2 || numeroDiGiocatoriMassimo > 10 || numeroDiGiocatoriMassimo < numeroDiGiocatoriMinimo) {
            throw new IllegalArgumentException("Verifica il numero massimo dei giocatori, il range permesso è da 2 a 10, devono essere inferiori o uguali al numero di giocatori minimo");
        } else {
            this.numeroDiGiocatoriMassimo = numeroDiGiocatoriMassimo;
        }

        if (durataMediaPartita <= 0) {
            throw new IllegalArgumentException("La durata media della partita in minuti non può essere nulla o negativa");
        } else {
            this.durataMediaPartita = durataMediaPartita;
        }
        addToCollection();
    }

    public GiocoDaTavolo(String titolo, int annoPubblicazione, double prezzo, int numeroDiGiocatoriMinimo, int durataMediaPartita) {
        this(titolo, annoPubblicazione, prezzo, numeroDiGiocatoriMinimo, numeroDiGiocatoriMinimo, durataMediaPartita);
    }

    private static int yearChecker(int annoPubblicazione) {
        if (annoPubblicazione > LocalDate.now().getYear()) {
            throw new IllegalArgumentException("Non puoi possedere giochi non ancora usciti");
        } else {
            return annoPubblicazione;
        }
    }

    @Override
    public void addToCollection() {
        getCollection().add(this);

    }

    public int getNumeroDiGiocatoriMinimo() {
        return numeroDiGiocatoriMinimo;
    }

    public int getNumeroDiGiocatoriMassimo() {
        return numeroDiGiocatoriMassimo;
    }

    public int getDurataMediaPartita() {
        return durataMediaPartita;
    }

    public void setDurataMediaPartita(int durataMediaPartita) {
        if (durataMediaPartita <= 0) {
            throw new IllegalArgumentException("La durata media della partita in minuti non può essere nulla o negativa");
        } else {
            this.durataMediaPartita = durataMediaPartita;
        }
    }

    @Override
    public String toString() {
        if (numeroDiGiocatoriMinimo == numeroDiGiocatoriMassimo) {
            return this.getTitolo() + ": ( " + super.toString() +
                    "numeroDiGiocatori=" + numeroDiGiocatoriMinimo +
                    ", durataMediaPartita=" + durataMediaPartita +
                    " )";
        } else {
            return this.getTitolo() + ": ( " + super.toString() +
                    "numeroDiGiocatori=da " + numeroDiGiocatoriMinimo + " a " + numeroDiGiocatoriMassimo +
                    ", durataMediaPartita=" + durataMediaPartita +
                    " )";

        }
    }
}
