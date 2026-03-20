package samuelvalentini.collection.videogame;

import samuelvalentini.collection.Collezione;
import samuelvalentini.collection.videogame.enumeration.Genere;
import samuelvalentini.collection.videogame.enumeration.Piattaforma;
import samuelvalentini.collection.videogame.enumeration.Tipo;

public class Videogioco extends Collezione {
    private final Piattaforma piattaforma;
    private double durataDiGioco;
    private Genere genere;


    public Videogioco(String titolo, int annoPubblicazione, double prezzo, Piattaforma piattaforma, int durataDiGioco, Genere genere) {
        super(titolo, yearChecker(annoPubblicazione), prezzo, Tipo.VIDEOGAME);
        if (piattaforma == null) {
            throw new IllegalArgumentException("Devi inserire il sistema di gioco");
        } else {
            this.piattaforma = piattaforma;
        }

        if (durataDiGioco <= 0) {
            throw new IllegalArgumentException("La durata del gioco in ore non può essere nulla o negativa");
        } else {
            this.durataDiGioco = durataDiGioco;
        }

        if (genere == null) {
            throw new IllegalArgumentException("Il genere deve essere inserito");
        } else {
            this.genere = genere;
        }

        addToCollection();

    }

    private static int yearChecker(int annoPubblicazione) {
        if (annoPubblicazione < 1950) {
            throw new IllegalArgumentException("Non esistono videogiochi pubblicati prima del 1950");
        } else {
            return annoPubblicazione;
        }
    }

    @Override
    public void addToCollection() {
        getCollection().add(this);
    }

    public Piattaforma getPiattaforma() {
        return piattaforma;
    }

    public double getDurataDiGioco() {
        return durataDiGioco;
    }

    public void setDurataDiGioco(double durataDiGioco) {
        this.durataDiGioco = durataDiGioco;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }
}
