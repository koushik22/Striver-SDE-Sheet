/*
The idea is to sort the intervals by their starting points. Then, we take the first interval and compare its end with the 
next intervals starts. As long as they overlap, we update the end to be the max end of the overlapping intervals. Once we 
find a non overlapping interval, we can add the previous "extended" interval and start over.

Sorting takes O(n log(n)) and merging the intervals takes O(n). So, the resulting algorithm takes O(n log(n)).
 */

 class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        // base cases
        if(intervals == null || intervals.length == 0)return res.toArray(new int[0][]);
        
        // sort the array according to the starting time
        Arrays.sort(intervals , (a,b) -> a[0] - b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        
        for(int[] arr : intervals){
            // if the intervals merges, update the end point(No need to update the start point, as the arr is already sorted
            // according to the start point)
            if(arr[0] <= end){
                end = Math.max(end , arr[1]);
            }
            // otherwise put the pair of merged intervals in the result and update start and end point.
            else{
                res.add(new int[]{start,end});
                start = arr[0];
                end = arr[1];
            }
        }
        // for the last(merged/non-merged) interval
        res.add(new int[]{start,end});
        return res.toArray(new int[0][]);
    }
}