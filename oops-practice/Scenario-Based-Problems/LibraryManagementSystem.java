import java.util.*;
abstract class Book {
    int id;
    String title;
    String author;
    boolean available;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    abstract void display();
}

class PhysicalBook extends Book implements Borrowable, Reservable {
    PhysicalBook(int id, String title, String author) {
        super(id, title, author);
    }

    public void borrow() {
        if (available) {
            available = false;
            System.out.println(title + " borrowed");
        }
    }

    public void returnBook() {
        available = true;
        System.out.println(title + " returned");
    }

    public void reserve() {
        System.out.println(title + " reserved");
    }

    void display() {
        System.out.println(id + " " + title + " " + author + " Physical " + available);
    }
}

class EBook extends Book implements Borrowable {
    String format;

    EBook(int id, String title, String author, String format) {
        super(id, title, author);
        this.format = format;
    }

    public void borrow() {
        System.out.println(title + " downloaded");
    }

    public void returnBook() {
        System.out.println(title + " returned");
    }

    void display() {
        System.out.println(id + " " + title + " " + author + " EBook " + format);
    }
}

interface Borrowable {
    void borrow();
    void returnBook();
}

interface Reservable {
    void reserve();
}

class Member {
    int id;
    String name;
    ArrayList<Book> borrowedBooks = new ArrayList<>();

    Member(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void borrowBook(Book book) {
        if (book instanceof Borrowable) {
            ((Borrowable) book).borrow();
            borrowedBooks.add(book);
        }
    }

    void display() {
        System.out.println(id + " " + name);
    }
}

class PremiumMember extends Member {
    PremiumMember(int id, String name) {
        super(id, name);
    }

    void reserveBook(Book book) {
        if (book instanceof Reservable) {
            ((Reservable) book).reserve();
        }
    }
}

public class LibraryManagementSystem {
    ArrayList<Book> books = new ArrayList<>();
    HashMap<Integer, Book> bookMap = new HashMap<>();

    ArrayList<Member> members = new ArrayList<>();
    HashMap<Integer, Member> memberMap = new HashMap<>();

    void addBook(Book book) {
        books.add(book);
        bookMap.put(book.id, book);
    }

    void addMember(Member member) {
        members.add(member);
        memberMap.put(member.id, member);
    }

    void searchBook(String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                book.display();
            }
        }
    }

    void sortBooks() {
        Collections.sort(books, new Comparator<Book>() {
            public int compare(Book b1, Book b2) {
                return b1.title.compareToIgnoreCase(b2.title);
            }
        });

        for (Book book : books) {
            book.display();
        }
    }

    void filterAvailableBooks() {
        for (Book book : books) {
            if (book.available)
                book.display();
        }
    }

    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();

        Book b1 = new PhysicalBook(1, "Java Programming", "James");
        Book b2 = new PhysicalBook(2, "Data Structures", "Mark");
        Book b3 = new EBook(3, "OOP Concepts", "Robert", "PDF");

        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);

        Member m1 = new Member(101, "Alice");
        PremiumMember m2 = new PremiumMember(102, "Bob");

        library.addMember(m1);
        library.addMember(m2);

        m1.borrowBook(b1);
        m2.reserveBook(b2);

        System.out.println("Search:");
        library.searchBook("Java Programming");

        System.out.println("Sorted Books:");
        library.sortBooks();

        System.out.println("Available Books:");
        library.filterAvailableBooks();
    }
}