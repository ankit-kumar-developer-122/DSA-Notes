/**
 * PROBLEM:
 * Given a sorted array arr[] where every element appears exactly twice, 
 * except for one element that appears only once. Find that unique element.
 *
 * EXAMPLE:
 * Input: arr[] = [1, 1, 2, 2, 3, 3, 4, 50, 50, 65, 65]
 * Output: 4
 * Explanation: 4 is the only element that appears once.
 *
 * SOLUTION EXPLANATION (Hinglish):
 * Is problem ko solve karne ke liye hum Binary Search ka use karenge. 
 * Array sorted hai, isliye $O(\log n)$ time complexity achieve ho sakti hai.
 * * Logic ye hai ki:
 * 1. Pehle edge cases check karo (array size 1 hai, ya pehla/aakhri element hi unique hai).
 * 2. Binary search mein `mid` calculate karo.
 * 3. Agar `arr[mid]` apne dono neighbors (`mid-1` aur `mid+1`) ke equal nahi hai, 
 * toh wahi hamara answer hai.
 * 4. Agar woh duplicate hai, toh pata lagao ki woh pair ka pehla element hai ya dusra.
 * 5. Ek trick use karo: Agar `left` side mein bache hue elements ka count `even` hai, 
 * toh iska matlab unique element `right` side mein hai. Agar `odd` hai, 
 * toh unique element `left` side mein hai.
 */

// LINK = https://www.geeksforgeeks.org/problems/find-the-element-that-appears-once-in-sorted-array0624/1
public class SingleElementSortedArray {
    public static int findSingle(int[] arr) {
        int n = arr.length;

        // Base cases
        if (n == 1) return arr[0];
        if (arr[0] != arr[1]) return arr[0];
        if (arr[n - 1] != arr[n - 2]) return arr[n - 1];

        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if mid is the unique element
            if (arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1]) {
                return arr[mid];
            }

            // Determine if the current pair starts at an even index
            // 'f' will be the first occurrence of the pair, 's' the second
            int f = (arr[mid] == arr[mid - 1]) ? mid - 1 : mid;
            int s = (arr[mid] == arr[mid - 1]) ? mid : mid + 1;

            // If elements before the pair are even, the unique element is on the right
            if ((f - low) % 2 == 0) {
                low = s + 1;
            } else {
                // Otherwise, it's on the left
                high = f - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 3, 4, 50, 50, 65, 65};
        System.out.println("The single element is: " + findSingle(arr));
    }
}
