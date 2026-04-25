import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TelephoneBook {
    private Map<String, List<String>> directory;

    public TelephoneBook() {
        directory = new HashMap<>();
    }

    public void add(String surname, String phoneNumber) {
        directory.computeIfAbsent(surname, k -> new ArrayList<>()).add(phoneNumber);
    }

    public List<String> get(String surname) {
        return directory.getOrDefault(surname, new ArrayList<>());
    }

    public static void main(String[] args) {
        TelephoneBook td = new TelephoneBook();
        td.add("Lenin", "123456");
        td.add("Stalin", "987654");
        td.add("Khrushchev", "134679");
        td.add("Brezhnev", "976431");

        td.add("Brezhnev", "4564654");

        System.out.println("Номера телефонов для фамилии Lenin: " + td.get("Lenin"));
        System.out.println("Номера телефонов для фамилии Stalin: " + td.get("Stalin"));
        System.out.println("Номера телефонов для фамилии Khrushchev: " + td.get("Khrushchev"));
        System.out.println("Номера телефонов для фамилии Brezhnev: " + td.get("Brezhnev"));
    }
}


