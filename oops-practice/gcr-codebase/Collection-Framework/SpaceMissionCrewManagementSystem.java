import java.util.*;
class Astronaut {
    String astronautId;
    String name;
    String specialization;

    Astronaut(String astronautId, String name, String specialization) {
        this.astronautId = astronautId;
        this.name = name;
        this.specialization = specialization;
    }
}

public class SpaceMissionCrewManagementSystem {

    static HashMap<String, List<Astronaut>> missions = new HashMap<>();
    static HashMap<String, HashSet<String>> assigned = new HashMap<>();

    static void addMission(String mission) {
        missions.putIfAbsent(mission, new ArrayList<>());
        assigned.putIfAbsent(mission, new HashSet<>());
    }

    static void assignAstronaut(String mission, Astronaut astronaut) {

        addMission(mission);

        if (assigned.get(mission).add(astronaut.astronautId)) {
            missions.get(mission).add(astronaut);
            System.out.println(astronaut.name + " assigned to " + mission);
        } else {
            System.out.println("Duplicate assignment not allowed.");
        }
    }

    static void displayMissions() {

        for (String mission : missions.keySet()) {

            System.out.println("Mission: " + mission);

            for (Astronaut a : missions.get(mission)) {
                System.out.println(a.astronautId + " " + a.name + " " + a.specialization);
            }

            System.out.println("Total Astronauts: " + missions.get(mission).size());
        }
    }

    public static void main(String[] args) {

        assignAstronaut("Moon Mission", new Astronaut("A101", "Rahul", "Pilot"));
        assignAstronaut("Moon Mission", new Astronaut("A102", "Amit", "Engineer"));
        assignAstronaut("Mars Mission", new Astronaut("A103", "Priya", "Scientist"));
        assignAstronaut("Moon Mission", new Astronaut("A101", "Rahul", "Pilot"));

        displayMissions();
    }
}