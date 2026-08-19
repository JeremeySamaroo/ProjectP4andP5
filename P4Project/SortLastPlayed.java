import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SortLastPlayed {
    public SortLastPlayed() {
    }

    public int[] calculateLengthOfLastPlayedWithOutRepeats(int[] lastPlayedLast, int[] lastPlayedPBeforLast) {
        int temp[] = new int[lastPlayedLast.length+lastPlayedPBeforLast.length];
        int tempIndex = 0;
        for(int value: lastPlayedLast){
            temp[tempIndex++] = value;
        }for(int value: lastPlayedPBeforLast){
            temp[tempIndex++] = value;
        }

        Arrays.sort(temp);
        Set<Integer> set = new HashSet<>();
        for (int i : temp) {
            set.add(i);
        }
        int[] result = new int[set.size()];
        int i = 0;
        for (int num : set) {
            result[i++] = num;
        }

        return result;
    }

    public ArrayList<int[]> getPairCombinations1(int[] lastPlayedNumbersWithoutRepeats) {

            ArrayList<int[]> pairCombinations = new ArrayList<>();

            for (int i = 0; i < lastPlayedNumbersWithoutRepeats.length; i++) {
                for (int j = i + 1; j < lastPlayedNumbersWithoutRepeats.length; j++) {
                    int[] pair = {lastPlayedNumbersWithoutRepeats[i], lastPlayedNumbersWithoutRepeats[j]};
                    pairCombinations.add(pair);
                }
            }

            return pairCombinations;
        }

}
