import java.util.Arrays;

public class combinationThing {


    public static int[][] combinations(int k, int[] arr) {
        int n = arr.length;
        int numCombinations = factorial(n) / (factorial(k) * factorial(n - k));
        int[][] result = new int[numCombinations][k];
        int[] indices = new int[k];

        for (int i = 0; i < k; i++) {
            indices[i] = i;
            result[0][i] = arr[i];
        }

        for (int i = 1; i < numCombinations; i++) {
            int j = k - 1;
            while (j >= 0 && indices[j] == n - k + j) {
                j--;
            }
            indices[j]++;
            for (int l = j + 1; l < k; l++) {
                indices[l] = indices[l - 1] + 1;
            }
            for (int l = 0; l < k; l++) {
                result[i][l] = arr[indices[l]];
            }
        }

        return result;
    }

    public static int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 3, 4, 5, 6}; 

        System.out.println("\nOriginal Array: \n" + Arrays.toString(test));

        int[][] combos3 = combinations(3, test);
        System.out.println("\nLength 3 Combinations: ");
        System.out.println(Arrays.deepToString(combos3));


        int[][] combos4 = combinations(4, test);
        System.out.println("\nLength 4 Combinations: ");
        System.out.println(Arrays.deepToString(combos4));


        int[][] combos5 = combinations(5, test);
        System.out.println("\nLength 5 Combinations: ");
        System.out.println(Arrays.deepToString(combos5));

    }
}