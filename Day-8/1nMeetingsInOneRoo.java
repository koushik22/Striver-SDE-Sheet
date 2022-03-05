class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.


    /*
    We'll sort the meetings in order of their finishing time. The sooner a meeting finishes, we have more chance of organizing
    another meetings. 
     */
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        if(n == 1)return 1;
        int[][] intervals = new int[n][2];
        // meetings are stored in a 2 column sized 2d array where one column is starting time of a meeting and another
        // column is ending time of the meeting.
        for(int i = 0; i < n; i++){
            intervals[i][0] = start[i];
            intervals[i][1] = end[i];
        }

            // meeting array is sorted according tto the finishing time of the meetings
            Arrays.sort(intervals , (a,b)-> a[1] - b[1]);
            
            
            int start_time;
            int end_time = intervals[0][1];

            // we'll assume that first meeting always will be performed
            int count = 1;
            // we'll iterate the meeting arr from 2nd meeting onwards
            for(int i = 1; i < n; i++){

                start_time = intervals[i][0];
                // if start time of current meeting is greater than ending time of previous meeting then only we can perform
                // the meeting, otherwise not.
                if(start_time > end_time){
                    count++;
                    end_time = intervals[i][1];
                }
                
            }
            
            return count;
        }
    }