package pl.javastart.task;
import java.io.IOException;
import java.util.*;

public class TournamentStats {
    private final static int SORT_BY_FIRST_NAME = 1;
    private final static int SORT_BY_LAST_NAME = 2;
    private final static int SORT_BY_RESULT = 3;

    void run(Scanner scanner) throws IOException {
        List<Player> players = new ArrayList<>();
        String input;
        do {
            System.out.println("Podaj wynik kolejnego gracza (lub stop):");
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("STOP")) {
                break;
            }
            String[] elements = input.split(" ");
            players.add(new Player(elements[0], elements[1], Integer.parseInt(elements[2])));

        } while (true);

        System.out.printf("Po jakim parametrze posortować? (%d - imię, %d - nazwisko, %d - wynik )\n",
                SORT_BY_FIRST_NAME, SORT_BY_FIRST_NAME, SORT_BY_RESULT);
        int inputInt = scanner.nextInt();
        System.out.println("Sortować rosnąco czy malejąco? (1 - rosnąco, 2 - malejąco)");
        int inputSort = scanner.nextInt();

        Comparator<Player> comparator = switch (inputInt) {
            case SORT_BY_FIRST_NAME -> Comparator.comparing(Player::getFirstName);
            case SORT_BY_LAST_NAME -> Comparator.comparing(Player::getLastName);
            case SORT_BY_RESULT -> Comparator.comparing(Player::getResult);
            default -> Comparator.comparing(Player::getFirstName);
        };
        if (inputSort == 2) {
            comparator = comparator.reversed();
        }
        players.sort(comparator);
        Files.writeFile(players);
    }
}


