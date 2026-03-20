package samuelvalentini;

import samuelvalentini.collection.boardgame.GiocoDaTavolo;
import samuelvalentini.collection.videogame.Videogioco;
import samuelvalentini.collection.videogame.enumeration.Genere;
import samuelvalentini.collection.videogame.enumeration.Piattaforma;

import java.util.Scanner;

import static samuelvalentini.collection.Collezione.getCollection;
import static samuelvalentini.collection.Collezione.stampaStatistiche;

public class Application {

    public static void main(String[] args) {

        GiocoDaTavolo dama = new GiocoDaTavolo("Dama", -1500, 5.5, 2, 20);
        Videogioco halo = new Videogioco("Halo: Combat Evolved", 2002, 70, Piattaforma.XBOX, 12, Genere.SHOOTER);
        GiocoDaTavolo scacchi = new GiocoDaTavolo("Scacchi", 600, 15.0, 2, 60);
        GiocoDaTavolo risiko = new GiocoDaTavolo("Risiko!", 1957, 34.9, 3, 6, 150);
        Videogioco dukeNukem3D = new Videogioco("Duke Nukem 3D", 1996, 59.9, Piattaforma.PC, 18, Genere.SHOOTER);
        Videogioco dragonAgeOrigins = new Videogioco("Dragon Age: Origins", 2009, 69.9, Piattaforma.PC, 18, Genere.ROLE_PLAYING);
        // getCollection().forEach(System.out::println);


//        System.out.println("test ricerca:");
//        System.out.println(ricercaPerId(2));
//        System.out.println(ricercaPerId(452));
//
//        System.out.println("test ricerca per prezzo inferiore a 35");
//        ricercaPerPrezzoInferiore(35).forEach(System.out::println);
//        System.out.println("verifica lista originale");
//        getCollection().forEach(System.out::println);
//
//        System.out.println(ricercaPerNumeroDiGiocatori(4));
//        System.out.println(ricercaPerNumeroDiGiocatori(2));
//        System.out.println(ricercaPerNumeroDiGiocatori(7));
//
//        rimozionePerId(9);
//        rimozionePerId(3);
//
//        getCollection().forEach(System.out::println);
//
//        System.out.println(ricercaPerId(5));
//        aggiornaElementoPerId(5, Genere.ACTION);
//        System.out.println(ricercaPerId(5));
//
//        stampaStatistiche();

        System.out.println("La tua collezione");
        System.out.println();
        stampaStatistiche();

        int choice;
        Scanner scanner = new Scanner(System.in);
        first:
        while (true) {
            while (true) {
                try {
                    System.out.println("Premi: \n 1 per visualizzare gli elementi \n 2 per aggiungere un elemento \n 3 per ricercare per id \n 4 per ricercare gli elementi per prezzo massimo \n 5 per ricercare per numero di giocatori \n 6 per rimuovere un elemento dal suo id \n 7 per aggiornare un elemento dal suo id \n 8 per visualizzare le statistiche \n 0 per uscire");
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice < 0 || choice > 8) {
                        throw new NumberFormatException();
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Inserimento errato, scegli un opzione da 0 a 9");
                }
            }

            switch (choice) {
                case 0: {
                    break first;
                }
                case 1: {
                    getCollection().forEach(System.out::println);
                    System.out.println();

                }
            }
        }


    }
}
