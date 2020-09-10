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
        // TODO: Lab 1 -- write mergesort here

	return numbers;
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
