interface FoodDelivery {

    void deliverFood(String customer);

    default void trackOrder() {
        System.out.println("Food Order Tracking Enabled");
    }

    static String generateDeliveryCode() {
        return "FD1001";
    }
}

interface GroceryDelivery {

    void deliverGroceries(String customer);

    default void trackOrder() {
        System.out.println("Grocery Order Tracking Enabled");
    }
}

class DeliveryExecutive implements FoodDelivery, GroceryDelivery {

    public void deliverFood(String customer) {
        System.out.println("Food Delivered to " + customer);
    }

    public void deliverGroceries(String customer) {
        System.out.println("Groceries Delivered to " + customer);
    }

    public void trackOrder() {
        FoodDelivery.super.trackOrder();
        GroceryDelivery.super.trackOrder();
    }

    public static void main(String[] args) {

        String[] customers = {"Rahul", "Priya", "Amit"};

        DeliveryExecutive d = new DeliveryExecutive();

        System.out.println("Delivery Code: " + FoodDelivery.generateDeliveryCode());

        for (String customer : customers) {
            d.trackOrder();
            d.deliverFood(customer);
            d.deliverGroceries(customer);
            System.out.println();
        }
    }
}