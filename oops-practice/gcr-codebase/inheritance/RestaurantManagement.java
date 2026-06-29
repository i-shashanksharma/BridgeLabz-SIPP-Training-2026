class Person {
    String name;
    int id;

    Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

interface Worker {
    void performDuties();
}

class Chef extends Person implements Worker {

    Chef(String name, int id) {
        super(name, id);
    }

    public void performDuties() {
        System.out.println(name + " is preparing food.");
    }
}

class Waiter extends Person implements Worker {

    Waiter(String name, int id) {
        super(name, id);
    }

    public void performDuties() {
        System.out.println(name + " is serving customers.");
    }
}

public class RestaurantManagement {
    public static void main(String[] args) {
        Chef chef = new Chef("Rahul", 101);
        Waiter waiter = new Waiter("Priya", 102);

        chef.performDuties();
        waiter.performDuties();
    }
}