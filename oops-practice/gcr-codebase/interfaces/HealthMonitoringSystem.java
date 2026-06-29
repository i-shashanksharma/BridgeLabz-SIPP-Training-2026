interface HeartRateMonitor {

    void showHeartRate();

    default void displayHealthTips() {
        System.out.println("Exercise regularly.");
    }

    static boolean isPatientIdValid(String patientId) {
        return patientId.length() == 5;
    }
}

interface TemperatureMonitor {

    void showTemperature();

    default void displayHealthTips() {
        System.out.println("Drink enough water.");
    }
}

class HealthMonitoringSystem implements HeartRateMonitor, TemperatureMonitor {

    public void showHeartRate() {
        System.out.println("Heart Rate: 75 BPM");
    }

    public void showTemperature() {
        System.out.println("Temperature: 98.6 F");
    }

    public void displayHealthTips() {
        HeartRateMonitor.super.displayHealthTips();
        TemperatureMonitor.super.displayHealthTips();
    }

    public static void main(String[] args) {

        String[] names = {"Rahul", "Priya", "Amit"};
        String[] ids = {"P1001", "P12", "P1003"};

        HealthMonitoringSystem system = new HealthMonitoringSystem();

        system.displayHealthTips();

        for (int i = 0; i < names.length; i++) {
            System.out.println("\nPatient: " + names[i]);

            if (HeartRateMonitor.isPatientIdValid(ids[i]))
                System.out.println("Patient ID Valid");
            else
                System.out.println("Patient ID Invalid");

            system.showHeartRate();
            system.showTemperature();
        }

        System.out.println("\nFinal Health Report Generated.");
    }
}