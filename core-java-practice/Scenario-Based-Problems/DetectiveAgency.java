import java.util.*;

public class DetectiveAgency {

    static HashMap<String, ArrayList<String>> suspects = new HashMap<>();

    static String mostInvestigatedSuspect() {

        String result = "";
        int maxCases = 0;

        for (String suspect : suspects.keySet()) {

            if (suspects.get(suspect).size() > maxCases) {
                maxCases = suspects.get(suspect).size();
                result = suspect;
            }
        }

        return result;
    }


    static ArrayList<String> suspectsInExactlyTwoCases() {

        ArrayList<String> result = new ArrayList<>();

        for (String suspect : suspects.keySet()) {

            if (suspects.get(suspect).size() == 2)
                result.add(suspect);
        }

        return result;
    }


    static ArrayList<String> alwaysTogetherPairs() {

        ArrayList<String> result = new ArrayList<>();

        ArrayList<String> names =
                new ArrayList<>(suspects.keySet());

        for (int i = 0; i < names.size(); i++) {

            for (int j = i + 1; j < names.size(); j++) {

                ArrayList<String> first =
                        suspects.get(names.get(i));

                ArrayList<String> second =
                        suspects.get(names.get(j));

                if (first.equals(second)) {
                    result.add(
                            names.get(i) + " & " + names.get(j)
                    );
                }
            }
        }

        return result;
    }


    static int[] subarrayWithTargetSum(int[] arr, int k) {

        HashMap<Integer, Integer> prefix =
                new HashMap<>();

        prefix.put(0, -1);

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];

            if (prefix.containsKey(sum - k)) {

                return new int[]{
                        prefix.get(sum - k) + 1,
                        i
                };
            }

            prefix.put(sum, i);
        }

        return new int[]{-1, -1};
    }


    public static void main(String[] args) {

        suspects.put("John",
                new ArrayList<>(Arrays.asList("Case1", "Case2")));

        suspects.put("Alice",
                new ArrayList<>(Arrays.asList("Case1", "Case2", "Case3")));

        suspects.put("Mark",
                new ArrayList<>(Arrays.asList("Case4", "Case5")));

        suspects.put("David",
                new ArrayList<>(Arrays.asList("Case6")));


        System.out.println("Most Investigated Suspect: "
                + mostInvestigatedSuspect());

        System.out.println("Suspects in Exactly 2 Cases: "
                + suspectsInExactlyTwoCases());

        System.out.println("Always Together Pairs: "
                + alwaysTogetherPairs());


        int[] evidence = {10, 2, -2, -20, 10};

        int[] result =
                subarrayWithTargetSum(evidence, -10);

        System.out.println("Subarray with Target Sum K: "
                + Arrays.toString(result));
    }
}