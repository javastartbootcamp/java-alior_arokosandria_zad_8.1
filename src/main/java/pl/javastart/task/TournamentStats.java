package pl.javastart.task;
import java.io.IOException;
import java.util.*;

public class TournamentStats {

    void run(Scanner scanner) throws IOException {
        List<Player> players = new ArrayList<>();
        String input;
        do {
            System.out.println("Podaj wynik kolejnego gracza (lub stop):");
            input = scanner.nextLine();
            if (input.equals("STOP")) {
                break;
            }
            String[] elements = input.split(" ");
            players.add(new Player(elements[0], elements[1], Integer.parseInt(elements[2])));

        } while (true);

        System.out.println("Po jakim parametrze posortować? (1 - imię, 2 - nazwisko, 3 - wynik)");
        int inputInt = scanner.nextInt();
        System.out.println("Sortować rosnąco czy malejąco? (1 - rosnąco, 2 - malejąco)");
        int inputSort = scanner.nextInt();
        if (inputSort == 1) {
            switch (inputInt) {
                case 1:
                    Collections.sort(players, Comparator.comparing(Player::getFirstName));
                    break;
                case 2:
                    Collections.sort(players, Comparator.comparing(Player::getLastName));
                    break;
                case 3:
                    Collections.sort(players, Comparator.comparingInt(Player::getResult));
                    break;
                default:
                    System.out.println("Zły wybór parametru");

            }
        } else if (inputSort == 2) {
            Collections.reverse(players);
        }else {
            System.out.println("Zły wybór sortowania");
        }
        Files.writeFile(players);
    }
}

