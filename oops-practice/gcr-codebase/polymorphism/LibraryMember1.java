class LibraryMember {
    String memberName;
    String memberId;

    LibraryMember(String memberName, String memberId) {
        this.memberName = memberName;
        this.memberId = memberId;
    }

    double calculateFine(int overdueDays) {
        return 0;
    }

    void display() {
        System.out.println(memberName + " " + memberId);
    }
}

class StudentMember extends LibraryMember {

    StudentMember(String name, String id) {
        super(name, id);
    }

    double calculateFine(int overdueDays) {
        return overdueDays * 2;
    }
}

class FacultyMember extends LibraryMember {

    FacultyMember(String name, String id) {
        super(name, id);
    }

    double calculateFine(int overdueDays) {
        return overdueDays * 1;
    }
}

class GuestMember extends LibraryMember {

    GuestMember(String name, String id) {
        super(name, id);
    }

    double calculateFine(int overdueDays) {
        return overdueDays * 5;
    }
}

public class LibraryMember1 {
    public static void main(String[] args) {

        LibraryMember[] members = {
                new StudentMember("Rahul", "S101"),
                new FacultyMember("Priya", "F201"),
                new GuestMember("Amit", "G301")
        };

        String searchId = "F201";

        for (LibraryMember m : members) {
            m.display();
            System.out.println("Fine: " + m.calculateFine(4));
            System.out.println();
        }

        System.out.println("Search Result:");

        for (LibraryMember m : members) {
            if (m.memberId.equals(searchId)) {
                m.display();
            }
        }
    }
}