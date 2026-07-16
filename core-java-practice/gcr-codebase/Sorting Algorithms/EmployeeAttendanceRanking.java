import java.util.Arrays;

public class EmployeeAttendanceRanking {

    static int[] topKEmployees(int[] ids, int[] attendance, int k) {

        int n = ids.length;

        for (int i = 0; i < n - 1; i++) {

            int max = i;

            for (int j = i + 1; j < n; j++) {

                if (attendance[j] > attendance[max] ||
                        (attendance[j] == attendance[max] && ids[j] < ids[max])) {

                    max = j;
                }
            }

            int temp = attendance[i];
            attendance[i] = attendance[max];
            attendance[max] = temp;

            temp = ids[i];
            ids[i] = ids[max];
            ids[max] = temp;
        }

        return Arrays.copyOf(ids, k);
    }

    public static void main(String[] args) {

        int[] ids = {101,102,103,104,105};
        int[] attendance = {92,85,98,92,80};

        System.out.println(Arrays.toString(topKEmployees(ids, attendance, 3)));
    }
}