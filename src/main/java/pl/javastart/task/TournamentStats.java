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

        switch (Integer.parseInt(inputInt + "" + inputSort)) {
            case 11 -> Collections.sort(players, Player.compareByPersonName);
            case 12 -> Collections.sort(players, Player.compareByPersonName.reversed());
            case 21 -> Collections.sort(players, Player.compareByPersonLastName);
            case 22 -> Collections.sort(players, Player.compareByPersonLastName.reversed());
            case 31 -> Collections.sort(players, Player.compareByResult);
            case 32 -> Collections.sort(players, Player.compareByResult.reversed());
            default -> System.out.println("Zły wybór parametru");
        }

        Files.writeFile(players);
    }
}


