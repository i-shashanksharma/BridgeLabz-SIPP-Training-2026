import java.util.Arrays;

public class BubbleSortProductPrices {

    static void bubbleSort(long[] prices) {

        for (int i = 0; i < prices.length - 1; i++) {

            boolean swapped = false;

            for (int j = 0; j < prices.length - i - 1; j++) {

                if (prices[j] > prices[j + 1]) {

                    long temp = prices[j];
                    prices[j] = prices[j + 1];
                    prices[j + 1] = temp;

                    swapped = true;
                }
            }

            if (!swapped)
                break;
        }
    }

    public static void main(String[] args) {

        long[] prices = {450,120,780,300,250,600};

        bubbleSort(prices);

        System.out.println(Arrays.toString(prices));
    }
}