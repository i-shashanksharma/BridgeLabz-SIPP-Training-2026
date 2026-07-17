import java.util.*;

class DuplicateSessionTokenDetection {

    public boolean hasDuplicateToken(String[] tokens) {
        Set<String> seen = new HashSet<>();

        for (String token : tokens) {
            if (!seen.add(token)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        DuplicateSessionTokenDetection obj = new DuplicateSessionTokenDetection();

        String[] tokens = {"ABC123", "XYZ456", "PQR789", "ABC123"};

        System.out.println(obj.hasDuplicateToken(tokens));
    }
}