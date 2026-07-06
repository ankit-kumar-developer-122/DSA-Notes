import java.util.Arrays;

class Solution {
    public int findMinArrowShots(int[][] points) {
        // Agar koi balloon nahi hai, toh 0 arrows chahiye
        if (points.length == 0) {
            return 0;
        }

        // 1. Sabse pehle balloons ko sort karo unke end points ke basis par.
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        // 2. Kam se kam ek arrow toh lagega hi (agar balloons hain toh).
        int arrowsCount = 1;
        
        // 3. Pehle arrow ko pehle balloon ke end par shoot karo.
        int currentArrowPos = points[0][1];

        // 4. Ab baaki saare balloons ko ek-ek karke check karenge.
        for (int i = 1; i < points.length; i++) {
            int balloonStart = points[i][0];
            int balloonEnd = points[i][1];

            // Agar agle balloon ka start, hamare current arrow position ke baad hai,
            // toh iska matlab purana arrow usse nahi phod payega.
            if (balloonStart > currentArrowPos) {
                // Naya arrow chahiye!
                arrowsCount++;
                // Naya arrow naye balloon ke end par shoot karo.
                currentArrowPos = balloonEnd;
            }
            // Agar balloonStart <= currentArrowPos hai, toh balloon already phut gaya,
            // toh kuch karne ki zaroorat nahi hai, aage badho.
        }

        return arrowsCount;
    }
}