interface LuggageScanner {

    void scanLuggage(String passenger);

    default void displaySecurityGuidelines() {
        System.out.println("Carry only permitted items.");
    }

    static boolean isPassportNumberValid(String passportNo) {
        return passportNo.length() == 8;
    }
}

interface PassportVerifier {

    void verifyPassport(String passportNo);

    default void displaySecurityGuidelines() {
        System.out.println("Passport verification is mandatory.");
    }
}

class AirportSecuritySystem implements LuggageScanner, PassportVerifier {

    public void scanLuggage(String passenger) {
        System.out.println(passenger + " luggage scanned.");
    }

    public void verifyPassport(String passportNo) {
        if (LuggageScanner.isPassportNumberValid(passportNo))
            System.out.println("Passport Verified");
        else
            System.out.println("Invalid Passport");
    }

    public void displaySecurityGuidelines() {
        LuggageScanner.super.displaySecurityGuidelines();
        PassportVerifier.super.displaySecurityGuidelines();
    }

    public static void main(String[] args) {

        String[] passengers = {"Rahul", "Priya", "Amit"};
        String[] passports = {"AB123456", "12345", "CD987654"};

        AirportSecuritySystem system = new AirportSecuritySystem();

        system.displaySecurityGuidelines();

        for (int i = 0; i < passengers.length; i++) {
            system.scanLuggage(passengers[i]);
            system.verifyPassport(passports[i]);

            if (LuggageScanner.isPassportNumberValid(passports[i]))
                System.out.println(passengers[i] + " Can Board");
            else
                System.out.println(passengers[i] + " Cannot Board");

            System.out.println();
        }
    }
}