interface Trackable {
    void logActivity();

    default void resetData() {
        System.out.println("Fitness data reset.");
    }
}

interface Reportable {
    void generateReport();
}

interface Notifiable {
    void sendAlert();
}

class FitnessDevice implements Trackable, Reportable, Notifiable {

    public void logActivity() {
        System.out.println("Activity Logged.");
    }

    public void generateReport() {
        System.out.println("Fitness Report Generated.");
    }

    public void sendAlert() {
        System.out.println("Water Intake Reminder Sent.");
    }

    public static void main(String[] args) {
        FitnessDevice device = new FitnessDevice();

        device.logActivity();
        device.generateReport();
        device.sendAlert();
        device.resetData();
    }
}