interface Trackable {
    void logActivity(String activity, int minutes);

    default void resetData() {
        System.out.println("Data reset completed.");
    }
}

interface Reportable {
    void generateReport();
}

interface Notifiable {
    void sendAlert(String message);
}

class FitnessDevice implements Trackable, Reportable, Notifiable {

    private int totalMinutes = 0;

    @Override
    public void logActivity(String activity, int minutes) {
        System.out.println("Logged: " + activity + " for " + minutes + " minutes");
        totalMinutes += minutes;
    }

    @Override
    public void generateReport() {
        System.out.println("Total workout time: " + totalMinutes + " minutes");
    }

    @Override
    public void sendAlert(String message) {
        System.out.println("ALERT: " + message);
    }
}

public class FitnessDemo {

    public static void main(String[] args) {

        FitnessDevice device = new FitnessDevice();

        device.logActivity("Running", 30);
        device.logActivity("Cycling", 45);

        device.generateReport();

        device.sendAlert("Hydration needed");

        device.resetData();

        System.out.println("\nDemonstrating multiple interface inheritance:");
        Trackable t = device;
        Reportable r = device;
        Notifiable n = device;

        t.resetData();
        r.generateReport();
        n.sendAlert("Test via interface reference");
    }
}