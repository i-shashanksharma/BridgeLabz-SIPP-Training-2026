class RescueTeam {
    String teamId;
    String location;

    RescueTeam(String teamId, String location) {
        this.teamId = teamId;
        this.location = location;
    }

    void performDuty() {
    }
}

class MedicalTeam extends RescueTeam {

    MedicalTeam(String id, String location) {
        super(id, location);
    }

    void performDuty() {
        System.out.println(teamId + " Providing Medical Help");
    }
}

class FireRescueTeam extends RescueTeam {

    FireRescueTeam(String id, String location) {
        super(id, location);
    }

    void performDuty() {
        System.out.println(teamId + " Extinguishing Fire");
    }
}

class FoodSupplyTeam extends RescueTeam {

    FoodSupplyTeam(String id, String location) {
        super(id, location);
    }

    void performDuty() {
        System.out.println(teamId + " Distributing Food");
    }
}

public class RescueTeam1 {

    static void findTeamByLocation(RescueTeam[] teams, String location) {
        for (RescueTeam t : teams)
            if (t.location.equalsIgnoreCase(location))
                System.out.println(t.teamId);
    }

    static void displayTeamsByPrefix(RescueTeam[] teams, String prefix) {
        for (RescueTeam t : teams)
            if (t.teamId.startsWith(prefix))
                System.out.println(t.teamId);
    }

    public static void main(String[] args) {

        RescueTeam[] teams = {
                new MedicalTeam("M101", "Delhi"),
                new MedicalTeam("M102", "Delhi"),
                new FireRescueTeam("F101", "Noida"),
                new FoodSupplyTeam("FS101", "Delhi"),
                new FoodSupplyTeam("FS102", "Lucknow")
        };

        int medical = 0, fire = 0, food = 0;

        for (RescueTeam t : teams) {

            t.performDuty();

            if (t instanceof MedicalTeam)
                medical++;
            else if (t instanceof FireRescueTeam)
                fire++;
            else if (t instanceof FoodSupplyTeam)
                food++;
        }

        findTeamByLocation(teams, "Delhi");

        displayTeamsByPrefix(teams, "FS");

        System.out.println("Medical = " + medical);
        System.out.println("Fire = " + fire);
        System.out.println("Food = " + food);

        if (medical >= fire && medical >= food)
            System.out.println("Maximum Deployment : Medical Team");
        else if (fire >= medical && fire >= food)
            System.out.println("Maximum Deployment : Fire Rescue Team");
        else
            System.out.println("Maximum Deployment : Food Supply Team");
    }
}