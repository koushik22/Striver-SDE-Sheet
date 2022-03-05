/*
Problem Statement

Given N activities with their start time and end time. The task is to find the solution set having a maximum number of non-conflicting activities that can be executed within the given time, assuming only a single activity can be performed at a given time.
 */

 /*
 
 Greedy Algorithm Method:-

The Activity selection problem can be solved using Greedy Approach. Our task is to maximize the number of non-conflicting activities.

Two activities A1 and A2 are said to be non-conflicting if S1 >= F2 or S2 >= F1, where S and F denote the start and end time respectively.

Since we need to maximize the maximum number of activities. The idea would be to choose the activity with the least finish time. Finishing the smallest activities would help adjust the remaining tasks.
  */


/*
Algorithm

1. Sort the arrays according to their finish time, in case they are not sorted.
2. Choose the first activity from the array and insert it into the sol array. As we can assume first activity will always be performed
3. If the start time of ith activity is greater than or equal to the finish time of the (i – 1)th activity, then we can perform the ith activity since it is ready for execution.
4. Repeat the above steps till the end of the array.
 */


 /*
 Time Complexity:

Case 1 : O(N), in case, the given array is sorted according to their finish times, where N is total steps.
Case 2 : O(NlogN), in case, the given array is not sorted according to their finish times, where N is total steps.

Space Complexity:O(1), since no extra space is used.
  */

  class Solution
{
    //Function to find the maximum number of activities that can
    //be performed by a single person.
    public static int activitySelection(int start[], int end[], int n)
    {
        // add your code here
        int[][] intervals = new int[n][2];
        
        for(int i = 0 ; i < n; i++){
            intervals[i][0] = start[i];
            intervals[i][1] = end[i];
        }
        
        // The array is sorted in order of finshing time
        Arrays.sort(intervals , (a,b) -> (a[1] - b[1]));
        
        // we'll assume first meeting will always be performed
        int cnt = 1;
        int st;
        int et = intervals[0][1];
        
        for(int i = 1; i < intervals.length; i++){
            st = intervals[i][0];
            // if start time of current meeting is greater than tyhe end time of previous meeting then only we can perform the meeting
            
            if(st > et){
                cnt++;
                et = intervals[i][1];
            }
        }
        return cnt;
    }
}