package samuelvalentini;

import samuelvalentini.collection.boardgame.GiocoDaTavolo;
import samuelvalentini.collection.videogame.Videogioco;
import samuelvalentini.collection.videogame.enumeration.Genere;
import samuelvalentini.collection.videogame.enumeration.Piattaforma;

import static samuelvalentini.collection.Collezione.*;

public class Application {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println(getCollection());


        GiocoDaTavolo dama = new GiocoDaTavolo("Dama", -1500, 5.5, 2, 20);
        Videogioco halo = new Videogioco("Halo: Combat Evolved", 2002, 70, Piattaforma.XBOX, 12, Genere.SHOOTER);
        GiocoDaTavolo scacchi = new GiocoDaTavolo("Scacchi", 600, 15.0, 2, 60);
        GiocoDaTavolo risiko = new GiocoDaTavolo("Risiko!", 1957, 34.9, 3, 6, 150);
        Videogioco dukeNukem3D = new Videogioco("Duke Nukem 3D", 1996, 59.9, Piattaforma.PC, 18, Genere.SHOOTER);
        Videogioco dragonAgeOrigins = new Videogioco("Dragon Age: Origins", 2009, 69.9, Piattaforma.PC, 18, Genere.ROLE_PLAYING);
        getCollection().forEach(System.out::println);


        System.out.println("test ricerca:");
        System.out.println(ricercaPerId(2));
        System.out.println(ricercaPerId(452));

        System.out.println("test ricerca per prezzo inferiore a 35");
        ricercaPerPrezzoInferiore(35).forEach(System.out::println);
        System.out.println("verifica lista originale");
        getCollection().forEach(System.out::println);

        System.out.println(ricercaPerNumeroDiGiocatori(4));
        System.out.println(ricercaPerNumeroDiGiocatori(2));
        System.out.println(ricercaPerNumeroDiGiocatori(7));

        rimozionePerId(9);
        rimozionePerId(3);

        getCollection().forEach(System.out::println);

        System.out.println(ricercaPerId(5));
        aggiornaElementoPerId(5, Genere.ACTION);
        System.out.println(ricercaPerId(5));


    }
}
