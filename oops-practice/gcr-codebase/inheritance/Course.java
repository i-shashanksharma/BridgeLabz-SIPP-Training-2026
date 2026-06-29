class Course {
    String courseName;
    int duration;

    Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }
}

class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;

    OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }
}

class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount;

    PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    void displayDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " Hours");
        System.out.println("Platform: " + platform);
        System.out.println("Recorded: " + isRecorded);
        System.out.println("Fee: " + fee);
        System.out.println("Discount: " + discount + "%");
    }

    public static void main(String[] args) {
        PaidOnlineCourse c = new PaidOnlineCourse("Java Programming", 40, "Udemy", true, 5000, 20);
        c.displayDetails();
    }
}