import java.util.*;

class LongestConsecutiveUserIDs {

    public int longestConsecutiveRun(int[] ids) {

        Set<Integer> idSet = new HashSet<>();

        for (int id : ids) {
            idSet.add(id);
        }

        int longest = 0;

        for (int id : idSet) {

            if (!idSet.contains(id - 1)) {

                int current = id;
                int length = 1;

                while (idSet.contains(current + 1)) {
                    current++;
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;
    }

    public static void main(String[] args) {

        LongestConsecutiveUserIDs obj = new LongestConsecutiveUserIDs();

        int[] ids = {100, 4, 200, 1, 3, 2};

        System.out.println(obj.longestConsecutiveRun(ids));
    }
}