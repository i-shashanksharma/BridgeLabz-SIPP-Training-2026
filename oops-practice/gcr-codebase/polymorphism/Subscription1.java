class Subscription {
    String subscriberName;
    String subscriptionId;

    Subscription(String subscriberName, String subscriptionId) {
        this.subscriberName = subscriberName;
        this.subscriptionId = subscriptionId;
    }

    double calculateMonthlyCharge() {
        return 0;
    }
}

class BasicPlan extends Subscription {

    BasicPlan(String name, String id) {
        super(name, id);
    }

    double calculateMonthlyCharge() {
        return 199;
    }
}

class PremiumPlan extends Subscription {

    PremiumPlan(String name, String id) {
        super(name, id);
    }

    double calculateMonthlyCharge() {
        return 499;
    }
}

class FamilyPlan extends Subscription {

    FamilyPlan(String name, String id) {
        super(name, id);
    }

    double calculateMonthlyCharge() {
        return 799;
    }
}

public class Subscription1 {

    static void search(Subscription[] subs, String id) {
        for (Subscription s : subs)
            if (s.subscriptionId.equals(id))
                System.out.println(s.subscriberName);
    }

    static void displayByLetter(Subscription[] subs, char ch) {
        for (Subscription s : subs)
            if (s.subscriberName.charAt(0) == ch)
                System.out.println(s.subscriberName);
    }

    static double totalRevenue(Subscription[] subs) {
        double total = 0;
        for (Subscription s : subs)
            total += s.calculateMonthlyCharge();
        return total;
    }

    public static void main(String[] args) {

        Subscription[] subs = {
                new BasicPlan("Rahul", "S101"),
                new PremiumPlan("Amit", "S102"),
                new FamilyPlan("Ankit", "S103"),
                new PremiumPlan("Riya", "S104")
        };

        Subscription costly = subs[0];

        for (Subscription s : subs) {
            System.out.println(s.subscriberName + " = " + s.calculateMonthlyCharge());

            if (s.calculateMonthlyCharge() > costly.calculateMonthlyCharge())
                costly = s;
        }

        System.out.println("Total Revenue = " + totalRevenue(subs));

        System.out.println("Most Expensive = " + costly.subscriptionId);

        search(subs, "S103");

        displayByLetter(subs, 'A');
    }
}