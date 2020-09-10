/**
 * Lab 1: Java Basics, Merge Sort and Maven <br />
 * The {@code MergeSort} class
 * @author Danh Nguyen, ID: 1592873
 */
public class MergeSort {

    // Debug tool here
    /**
     * This function print out all object in array
     *
     * @param arr the integer array to be displayed on the terminal,
     *            useful for debugging.
     */
    public static void printArray(int[] arr) {
        for (Object i : arr) {
            System.out.print(i + " ");
        }
    }


    /**
     * This function tests any sorting algorithm. It generates a random list of integer, sort it with
     * the algorithm that being tested, compare that to java built-in sort.
     *
     * @param len indicate the length of the testing array
     *
     * @return void     Print out sorted array and report if the algorithm sorts successfully or not
     */
    public static void sortTester(int len) {
        int[] numbers = new int[len];

        System.out.println("The random generated array: ");
        for (int i = 0; i < len; i++) {
            numbers[i] = (int) (Math.random() * 200);
            System.out.print(numbers[i] + " ");
        }

        System.out.println();
        System.out.println();

        // Debug test here
        int[] numbers_test = numbers.clone();
        java.util.Arrays.sort(numbers_test);

        numbers = sort(numbers);

        System.out.println("The array after sorted with MergeSort: ");
        printArray(numbers);

        // Debug result
        System.out.println();
        System.out.println();
        System.out.print("The algorithm successfully executed: ");
        System.out.println(java.util.Arrays.equals(numbers, numbers_test));
    }


    /**
     * The merge sort procedure
     *
     * @param numbers   {@code int[]} The integer array to be sorted
     *
     * @return numbers  Return a <strong>NEW</strong> array that is sorted.
     *                  Self-refer call will cause variable name to re-reference to
     *                  the new object.
     */
    public static int[] sort(int[] numbers) {
        // This is a recursive sorting algorithm, we need a base case that break recursive loop
        // If the array is length 1, it is already sorted
        if (numbers.length == 1) {
            return numbers;
        }

        // We cache the length here for ease of use
        int total_length = numbers.length;
        int left_length = total_length/2; // This is integer division (round down)
        int right_length = total_length - left_length; // By doing this, even if total left is odd, this would solve the problem

        // If they array is not yet split to length 1, recursively call split...
        int[] ArrayLeft = new int[left_length];
        int[] ArrayRight = new int[right_length];

        // Copy the number in
        for (int i = 0; i < left_length; i++) {
            ArrayLeft[i] = numbers[i];
        }
        for (int i = 0; i < right_length; i++) {
            ArrayRight[i] = numbers[i + left_length];
        }

        // The idea of merge sort is: Assume that we have 2 sorted lists, we merge them to make 1 sorted list
        // so, why don't we merge sort the sub lists, then merge? This is recursive fundamental
        ArrayLeft = sort(ArrayLeft);
        ArrayRight = sort(ArrayRight);

        // Dont forget to return the merged version
        return merge(ArrayLeft, ArrayRight);
    }


    // Now we need to implement our special merge function, which takes in 2 sorted lists to create
    // 1 big sorted list
    /**
     * This method is a sub-function for merge sort. It cherry-pick numbers from 2 sorted
     * arrays to form a new big sorted array
     *
     * @param ArrayLeft             Any integer array that already sorted
     * @param ArrayRight            Any integer array that already sorted
     * @return BigSortedArray       A sorted integer array that created from the 2 input arrays
     */
    public static int[] merge(int[] ArrayLeft, int[] ArrayRight) {
        // We cache the length here for ease of use and reduce computation time
        int left_length = ArrayLeft.length;
        int right_length = ArrayRight.length;
        int total_length = left_length + right_length;

        // Initiate the final array
        int[] BigSortedArray = new int[total_length];

        // Now we compare left-to-right each element in 2 arrays and place them in the big array
        // Initiate control index
        int leftIndex = 0;
        int rightIndex = 0;
        int bigIndex = 0;

        // While 2 arrays still have numbers to compare
        while (leftIndex < left_length && rightIndex < right_length) {
            if (ArrayLeft[leftIndex] < ArrayRight[rightIndex]) {
                BigSortedArray[bigIndex] = ArrayLeft[leftIndex];
                leftIndex++;
            }
            else {
                BigSortedArray[bigIndex] = ArrayRight[rightIndex];
                rightIndex++;
            }

            // Don't forget to advance big array
            bigIndex++;

        }

        // When 1 array is exhausted, copy the rest of the other array into big array
        while (leftIndex < left_length) {
            BigSortedArray[bigIndex] = ArrayLeft[leftIndex];
            bigIndex++;
            leftIndex++;
        }

        while (rightIndex < right_length) {
            BigSortedArray[bigIndex] = ArrayRight[rightIndex];
            bigIndex++;
            rightIndex++;
        }

        return BigSortedArray;
    }


    /**
     * Main entry: test the HeapSort
     * @param args      {@code String[]} Command line arguments
     */
    public static void main(String[] args) {
        sortTester(20);
    }

}
