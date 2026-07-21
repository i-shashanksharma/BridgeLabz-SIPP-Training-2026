import java.util.PriorityQueue;
class Patient {
    String name;
    int severity;

    Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    @Override
    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}

public class EmergencyRoomTriage {

    private PriorityQueue<Patient> triageQueue =
            new PriorityQueue<>((a, b) -> b.severity - a.severity);

    public void addPatient(Patient p) {
        triageQueue.offer(p);
    }

    public Patient treatNext() {
        return triageQueue.poll();
    }

    public static void main(String[] args) {

        EmergencyRoomTriage er = new EmergencyRoomTriage();

        er.addPatient(new Patient("John", 4));
        er.addPatient(new Patient("Alice", 9));
        er.addPatient(new Patient("Bob", 6));

        while (!er.triageQueue.isEmpty()) {
            System.out.println(er.treatNext());
        }
    }
}
