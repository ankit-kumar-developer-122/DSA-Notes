class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int low =1; int high = arr.length -2;
        while(low <= high){
            int mid= (low + high)/2;
            if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1] && mid>0 && mid<arr.length-1) return mid;
            else if(arr[mid]>arr[mid-1] && arr[mid]<arr[mid+1] && mid>0 && mid<arr.length-1) low= mid+1;
            else high = mid-1;
        }
        return -1;
    }
}
