public class EmployeeBonus {

    public static double[][] generateData() {

        double[][] data = new double[10][2];

        for (int i = 0; i < 10; i++) {
            data[i][0] = (int)(Math.random() * 90000) + 10000;
            data[i][1] = (int)(Math.random() * 10) + 1;
        }

        return data;
    }

    public static double[][] calculateBonus(double[][] data) {

        double[][] result = new double[10][2];

        for (int i = 0; i < 10; i++) {

            double salary = data[i][0];
            double years = data[i][1];

            double bonus;

            if (years > 5) {
                bonus = salary * 0.05;
            } else {
                bonus = salary * 0.02;
            }

            result[i][0] = salary + bonus;
            result[i][1] = bonus;
        }

        return result;
    }

    public static void main(String[] args) {

        double[][] oldData = generateData();
        double[][] newData = calculateBonus(oldData);

        double oldSalary = 0;
        double newSalary = 0;
        double totalBonus = 0;

        System.out.println("OldSalary\tYears\tBonus\tNewSalary");

        for (int i = 0; i < 10; i++) {

            System.out.println(
                    oldData[i][0] + "\t" +
                    oldData[i][1] + "\t" +
                    newData[i][1] + "\t" +
                    newData[i][0]);

            oldSalary += oldData[i][0];
            newSalary += newData[i][0];
            totalBonus += newData[i][1];
        }

        System.out.println("Total Old Salary = " + oldSalary);
        System.out.println("Total New Salary = " + newSalary);
        System.out.println("Total Bonus = " + totalBonus);
    }
}