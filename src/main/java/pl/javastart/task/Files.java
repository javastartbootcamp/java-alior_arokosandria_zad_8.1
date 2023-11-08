package pl.javastart.task;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Files {

    public static void writeFile(List<Player> players) throws IOException {
        try (FileWriter fileWriter = new FileWriter("stats.csv")) {
            for (Player player : players) {
                fileWriter.write(player.getFirstName() + " " + player.getLastName() + ";" + player.getResult() + "\n");
            }
        }
    }
}
