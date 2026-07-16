import java.util.ArrayList;

class Repository<T> {

    ArrayList<T> list = new ArrayList<>();

    void add(T item) {
        list.add(item);
    }

    void display() {
        System.out.println(list);
    }
}

public class RepositoryDemo {

    public static void main(String[] args) {

        Repository<String> repo = new Repository<>();

        repo.add("Java");
        repo.add("Python");
        repo.add("C++");

        repo.display();

        Repository<Integer> repo2 = new Repository<>();

        repo2.add(10);
        repo2.add(20);
        repo2.add(30);

        repo2.display();
    }
}