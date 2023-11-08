package pl.javastart.task;

import java.util.Comparator;

public class Player {
    private String firstName;
    private String lastName;
    private int result;

    public Player(String firstName, String lastName, int result) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.result = result;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    static Comparator<Player> compareByPersonName = new Comparator<Player>() {
        @Override
        public int compare(Player p1, Player p2) {
            return p1.getFirstName().compareTo(p2.getFirstName());
        }
    };

    static Comparator<Player> compareByPersonLastName = new Comparator<Player>() {
        @Override
        public int compare(Player p1, Player p2) {
            return p1.getLastName().compareTo(p2.getLastName());
        }
    };
    static Comparator<Player> compareByResult = new Comparator<Player>() {
        @Override
        public int compare(Player p1, Player p2) {
            if (p1.getResult() > p2.getResult()) {
                return 1;
            } else if (p1.getResult() < p2.getResult()) {
                return -1;
            }
            return 0;
        }
    };
}
