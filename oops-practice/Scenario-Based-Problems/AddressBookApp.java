import java.util.*;

class Contact implements Comparable<Contact> {
    String name;
    String phone;
    String email;

    Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public int compareTo(Contact c) {
        return this.name.compareToIgnoreCase(c.name);
    }

    public String toString() {
        return "Name: " + name + ", Phone: " + phone + ", Email: " + email;
    }
}

public class AddressBookApp {
    ArrayList<Contact> contacts = new ArrayList<>();
    HashMap<String, Contact> contactMap = new HashMap<>();
    HashSet<String> phoneSet = new HashSet<>();

    public void add(String name, String phone, String email) {
        if (phoneSet.contains(phone)) {
            System.out.println("Duplicate phone number");
            return;
        }

        Contact c = new Contact(name, phone, email);
        contacts.add(c);
        contactMap.put(name, c);
        phoneSet.add(phone);
    }

    public void search(String name) {
        Contact c = contactMap.get(name);

        if (c != null)
            System.out.println(c);
        else
            System.out.println("Contact not found");
    }

    public void delete(String name) {
        Contact c = contactMap.remove(name);

        if (c != null) {
            contacts.remove(c);
            phoneSet.remove(c.phone);
        }
    }

    public void display() {
        Collections.sort(contacts);

        for (Contact c : contacts) {
            System.out.println(c);
        }
    }

    public static void main(String[] args) {
        AddressBookApp app = new AddressBookApp();

        app.add("Alice", "9876543210", "alice@gmail.com");
        app.add("Bob", "9123456780", "bob@gmail.com");
        app.add("Charlie", "9988776655", "charlie@gmail.com");

        app.search("Bob");
        app.delete("Charlie");
        app.display();
    }
}