package samuelvalentini.collection.boardgame;

import samuelvalentini.collection.Collezione;
import samuelvalentini.collection.enumeration.Tipo;

import java.time.LocalDate;

public class GiocoDaTavolo extends Collezione {
    private final int numeroDiGiocatori;
    private int durataMediaPartita;

    public GiocoDaTavolo(String titolo, int annoPubblicazione, double prezzo, int numeroDiGiocatori, int durataMediaPartita) {
        super(titolo, yearChecker(annoPubblicazione), prezzo, Tipo.BOARD_GAME);
        if (numeroDiGiocatori < 2 || numeroDiGiocatori > 10) {
            throw new IllegalArgumentException("Verifica il numero dei giocatori, il range permesso è da 2 a 10");
        } else {
            this.numeroDiGiocatori = numeroDiGiocatori;
        }

        if (durataMediaPartita <= 0) {
            throw new IllegalArgumentException("La durata media della partita in minuti non può essere nulla o negativa");
        } else {
            this.durataMediaPartita = durataMediaPartita;
        }
        addToCollection();
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

    public int getNumeroDiGiocatori() {
        return numeroDiGiocatori;
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
}
