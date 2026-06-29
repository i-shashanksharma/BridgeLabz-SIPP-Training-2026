import java.util.*;
public class EmployeeSkillAssignment {
    static void findTeams(int[] arr, int target, int i, List<Integer> list, int sum) {
        if (sum == target) {
            System.out.println(list);
            return;
        }

        if (i == arr.length || sum > target)
            return;

        list.add(arr[i]);
        findTeams(arr, target, i + 1, list, sum + arr[i]);

        list.remove(list.size() - 1);
        findTeams(arr, target, i + 1, list, sum);
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 7};
        findTeams(arr, 10, 0, new ArrayList<>(), 0);
    }
}