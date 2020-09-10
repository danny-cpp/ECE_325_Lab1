/**
 * Lab 1: Java Basics, Merge Sort and Maven <br />
 * The {@code MergeSort} class
 * @author <your-name>
 */
public class MergeSort {

    // More methods can be added here

    /**
     * The merge sort procedure
     * @param numbers   {@code int[]} The integer array to be sorted
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

        // The idea of merge sort is: Assume that we have 2 sorted lists, we merge them to make 1 sorted list
        // so, why don't we merge sort the sub lists, then merge? This is recursive fundamental
        ArrayLeft = sort(ArrayLeft);
        ArrayRight = sort(ArrayRight);

        // Dont forget to return the merged version
        return merge(ArrayLeft, ArrayRight);
    }

    /**
     * Main entry: test the HeapSort
     * @param args      {@code String[]} Command line arguments
     */
    public static void main(String[] args) {
        int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 200);
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        // numbers = sort(numbers);
        //
        // for (int n: numbers)
        //     System.out.print(n + " ");
        // System.out.println();
    }

}
