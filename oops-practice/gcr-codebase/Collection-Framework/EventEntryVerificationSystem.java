import java.util.*;
public class EventEntryVerificationSystem {

    static HashSet<String> participants = new HashSet<>();

    static void register(String email) {
        if (participants.add(email))
            System.out.println("Registration Successful.");
        else
            System.out.println("Duplicate Registration Rejected.");
    }

    static void displayParticipants() {
        System.out.println("Registered Participants");

        for (String email : participants)
            System.out.println(email);

        System.out.println("Total Attendees = " + participants.size());
    }

    public static void main(String[] args) {
        register("rahul@gmail.com");
        register("amit@gmail.com");
        register("priya@gmail.com");
        register("rahul@gmail.com");

        displayParticipants();
    }
}