/*

A Simple Solution is to generate all subsets of a given set of jobs and check individual subsets for the feasibility of jobs in that subset. Keep track of maximum profit among all feasible subsets. The time complexity of this solution is exponential. 
This is a standard Greedy Algorithm problem. 



Following is the algorithm.

1) Sort all jobs in decreasing order of profit. 
2) Iterate on jobs in decreasing order of profit.For each job , do the following : 
a)Find a time slot i, such that slot is empty and i < deadline and i is greatest.Put the job in 
this slot and mark this slot filled. 
b)If no such i exists, then ignore the job. 

The Following is the implementation of the above algorithm. 
 */

 class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Sort all jobs according to
        // decreasing order of profit
        Arrays.sort(arr , ((a,b) -> b.profit - a.profit));
        int maxi = 0;
        
        // maximum deadline of a job to form the result array. 
        for(int i = 0; i < arr.length; i++){
            if(arr[i].deadline > maxi)maxi = arr[i].deadline;
        }
        
        int countJobs = 0 , jobsProfit = 0;
        
         // To keep track of free time slots
        int[] result = new int[maxi+1];
        
        for(int i = 1; i <= maxi; i++)result[i] = -1;
        
        // Iterate through all given jobs
        for(int i = 0; i < n; i++){
            
            // Find a free slot for this job
            // (Note that we start from the last possible slot to ensure that other jobs which has lesser deadine also get
            // a chance to get completed)
            for(int j = arr[i].deadline; j > 0; j--){

                  // Free slot found
                if(result[j] == -1){
                    // ith job has been performed
                    result[j] = arr[i].id;
                    countJobs++;
                    jobsProfit += arr[i].profit;
                    break;
                }
            }
            
            
        }
        
        int[] ans = new int[2];
        ans[0] = countJobs; ans[1] = jobsProfit;
        return ans;
        
    }
}

/*
Basically we are checking for each job id's, and for each job id we are checking from deadline to 1 to get a free slot, so if deadline is m
the TC is - o(n*m). And o(nlogn) is for sorting
 */

// TC - O(nlogn) + O(n*m)
// SC - O(m)