public class ReverseanArray {

    /**
     * Reverses the given array in-place.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void reverseArray(int[] arr) {
        int n = arr.length;
        int r = n - 1;
        
        // Use a two-pointer approach to swap elements
        for (int l = 0; l < n / 2; l++) {
            int tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            r--;
        }
    }

    // Main method for local testing
    public static void main(String[] args) {
        int[] example = {1, 4, 3, 2, 6, 5};
        
        System.out.print("Original Array: ");
        printArray(example);
        
        reverseArray(example);
        
        System.out.print("Reversed Array: ");
        printArray(example);
    }

    // Helper method to print array contents
    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
}
