/*The pascal triangle problem has a very simple and intuitive dynamic programming approach. As the definition states, 
every element of a row is formed by the sum of the two numbers directly above. So, we can just apply DP and use the previously
 stored rows of trianlge to calculate the new rows.

We can just initialize the start and end elements of each row as 1 and update only the elements between them. This will make 
the code simpler and avoid the need of having extra checks for edge elements of each row. */

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> curr = new LinkedList<>();
        List<Integer> pre = null;
        
        for(int i=0;i<numRows;i++){
            curr = new LinkedList<>();
            for(int j=0; j<=i; j++){
                if(j == 0 || j == i){
                    curr.add(1);
                }
                else{
                    curr.add(pre.get(j-1) + pre.get(j));
                }
            }
            pre = curr;
            result.add(pre);
        }
        return result;
        }
    }


    // We can also solve this by applying binomial co-efficient, THINK HOW?