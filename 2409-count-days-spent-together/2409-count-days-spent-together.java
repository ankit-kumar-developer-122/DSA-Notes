class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int aliceStart = convertToDays(arriveAlice, daysInMonths);
        int aliceEnd = convertToDays(leaveAlice, daysInMonths);
        int bobStart = convertToDays(arriveBob, daysInMonths);
        int bobEnd = convertToDays(leaveBob, daysInMonths);
        
        int overlapStart = Math.max(aliceStart, bobStart);
        int overlapEnd = Math.min(aliceEnd, bobEnd);
        
        return Math.max(0, overlapEnd - overlapStart + 1);
    }
    
    private int convertToDays(String date, int[] daysInMonths) {
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));
        
        int totalDays = day;
        for (int i = 0; i < month - 1; i++) {
            totalDays += daysInMonths[i];
        }
        
        return totalDays;
    }
}