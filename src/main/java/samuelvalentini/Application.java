package samuelvalentini;

import samuelvalentini.collection.Collezione;
import samuelvalentini.collection.boardgame.GiocoDaTavolo;
import samuelvalentini.collection.videogame.Videogioco;
import samuelvalentini.collection.videogame.enumeration.Genere;
import samuelvalentini.collection.videogame.enumeration.Piattaforma;

import java.util.List;
import java.util.Scanner;

import static samuelvalentini.collection.Collezione.*;

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

                case 2: {
                    int ch;
                    while (true) {
                        System.out.println("premi 1 per inserire un videogioco o 2 per inserire un gioco da tavolo");
                        try {
                            ch = Integer.parseInt(scanner.nextLine());
                            if (ch != 1 && ch != 2) {
                                throw new NumberFormatException();
                            } else {
                                break;
                            }

                        } catch (NumberFormatException e) {
                            System.out.println("Scelta errata");
                        }
                    }

                    switch (ch) {
                        case 1: {
                            System.out.println("Inserisci il titolo");
                            String titolo = scanner.nextLine();
                            System.out.println("Inserisci l'anno");
                            int anno = Integer.parseInt(scanner.nextLine());
                            System.out.println("Inserisci il prezzo in numeri decimali es. 5.99");
                            double prezzo = Double.parseDouble(scanner.nextLine());
                            int piattaforma;
                            Piattaforma piattaformaScelta;

                            while (true) {
                                System.out.println("Scegli la piattaforma fra: 1. Gameboy, 2.Xbox, 3.Playstation, 4.PC ");

                                try {
                                    piattaforma = Integer.parseInt(scanner.nextLine());
                                    if (piattaforma < 1 || piattaforma > 4) {
                                        throw new NumberFormatException();
                                    } else {
                                        break;
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("scelta errata");
                                }
                            }

                            switch (piattaforma) {
                                case 1: {
                                    piattaformaScelta = Piattaforma.GAME_BOY;
                                    break;
                                }
                                case 2: {
                                    piattaformaScelta = Piattaforma.XBOX;
                                    break;
                                }
                                case 3: {
                                    piattaformaScelta = Piattaforma.PLAYSTATION;
                                    break;
                                }
                                case 4: {
                                    piattaformaScelta = Piattaforma.PC;
                                    break;
                                }
                                default: {
                                    piattaformaScelta = Piattaforma.PC;
                                }

                            }

                            System.out.println("Inserisci la durata del gioco in ore, si accettano numeri decimali");
                            double durata = Double.parseDouble(scanner.nextLine());

                            int genere;
                            Genere genereScelto;

                            while (true) {
                                System.out.println("Inserisci il genere del gioco: 1. ACTION, 2.ADVENTURE, 3.SHOOTER, 4.ROLE PLAYING");

                                try {
                                    genere = Integer.parseInt(scanner.nextLine());
                                    if (genere < 1 || genere > 4) {
                                        throw new NumberFormatException();
                                    } else {
                                        break;
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("scelta errata");
                                }
                            }

                            switch (genere) {
                                case 1: {
                                    genereScelto = Genere.ACTION;
                                    break;
                                }
                                case 2: {
                                    genereScelto = Genere.ADVENTURE;
                                    break;
                                }
                                case 3: {
                                    genereScelto = Genere.SHOOTER;
                                    break;
                                }
                                case 4: {
                                    genereScelto = Genere.ROLE_PLAYING;
                                    break;
                                }
                                default: {
                                    genereScelto = Genere.MISC;
                                }

                            }

                            System.out.println("Se hai inserito tutto correttamente il gioco viene creato...");
                            new Videogioco(titolo, anno, prezzo, piattaformaScelta, durata, genereScelto);

                        }


                        case 2: {
                            System.out.println("Inserisci il titolo");
                            String titolo = scanner.nextLine();
                            System.out.println("Inserisci l'anno");
                            int anno = Integer.parseInt(scanner.nextLine());
                            System.out.println("Inserisci il prezzo in numeri decimali es. 5.99");
                            double prezzo = Double.parseDouble(scanner.nextLine());
                            System.out.println("Inserisci il numero minimo di giocatori");
                            int numeroMinimo = Integer.parseInt(scanner.nextLine());
                            System.out.println("Inserisci il numero massimo di giocatori");
                            int numeroMassimo = Integer.parseInt(scanner.nextLine());
                            System.out.println("Inserisci la durata media della partita in minuti con un numero intero");
                            int durata = Integer.parseInt(scanner.nextLine());


                            System.out.println("Se hai inserito tutto correttamente il  gioco da tavolo viene creato...");
                            new GiocoDaTavolo(titolo, anno, prezzo, numeroMinimo, numeroMassimo, durata);


                        }
                    }

                }

                case 3: {
                    long id;
                    while (true) {
                        try {
                            System.out.println("Inserisci l'id numerico per trovare il gioco");
                            id = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Inserimento errato riprova");
                        }
                    }
                    Collezione title = ricercaPerId(id);
                    if (title == null) {
                        System.out.println("id non trovato");
                    } else {
                        System.out.println(title);
                    }

                }

                case 4: {
                    double targetPrice;
                    while (true) {
                        try {
                            System.out.println("Inserisci il prezzo di ricerca come numero decimale");
                            targetPrice = Double.parseDouble(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Inserimento errato riprova");
                        }
                    }
                    List<Collezione> target = ricercaPerPrezzoInferiore(targetPrice);
                    if (target.isEmpty()) {
                        System.out.println("nessun elemento corrisponde alla ricerca");
                    } else {
                        System.out.println(target);
                    }

                }

                case 5: {

                    int targetNumber;
                    while (true) {
                        try {
                            System.out.println("Inserisci il numero di giocatori (numero intero)");
                            targetNumber = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Inserimento errato riprova");
                        }
                    }
                    List<GiocoDaTavolo> targetN = ricercaPerNumeroDiGiocatori(targetNumber);
                    if (targetN.isEmpty()) {
                        System.out.println("nessun elemento corrisponde alla ricerca");
                    } else {
                        System.out.println(targetN);
                    }

                }

                case 6: {
                }

                case 7: {
                }

                case 8: {
                }

            }
        }


    }
}
