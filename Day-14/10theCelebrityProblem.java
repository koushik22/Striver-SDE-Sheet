// Brute Force
// Algorithm is as follows:

// 1. Initialize an integer variable 'CELEBRITY' := -1.
// 2. Run a loop where ‘i’ ranges from 0 to ‘N’ - 1, and check whether the person having id ‘i’ is a celebrity or not. This can be done as follow -:
//         a. Initialize two boolean variables, ‘KNOWANY’ and ‘KNOWNTOALL’.
//         b. Run a loop where ‘j’ ranges from 0 to ‘N’ - 1. If ‘knows(i, j)’ returns false for all ‘j’,  then set ‘KNOWANY’:= false
//         c. Run a loop where ‘j’ ranges from 0 to ‘N’ - 1 and if  ‘knows(j, i)’ return true for all ‘j’ except when ‘j’ = ‘i’, then set  ‘KNOWNTOALL’ := true
//         d. If ‘KNOWANY’ is ‘false’ and ‘KNOWNTOALL’ is ‘true’, then assign ‘CELEBRITY’:= ‘i’ and break the loop.
// 3. Return ‘CELEBRITY’.
// Time Complexity
// O(N*N), where ‘N’ is the number of people at the party.

 

// The outer loop will run ‘N’ times and two inner loops both will run ‘N’ times.

// Space Complexity
// O(1).
// No extra space is used here.

/*
    Time complexity: O(N*N)
    Space complexity: O(1)
    
    Where 'N' is the number of people at the party.
*/
	
public class Solution {
	public static int findCelebrity(int n) {

        int celebrity = -1;

	    // Check one by one whether the person is a celebrity or not.
	    for(int i = 0; i < n; i++) {
	        boolean knowAny = false, knownToAll = true;

	        // Check whether perosn with id 'i' knows any other person.
	        for(int j = 0; j < n; j++) {
	            if(Runner.knows(i, j)) {
	                knowAny = true;
	                break;
	            }
	        }

	        // Check whether perosn with id 'i' is known to all the other person.
	        for(int j = 0; j < n; j++) {
	            if(i != j && !Runner.knows(j, i)) {
	                knownToAll = false;
	                break;
	            }
	        }

	        if(!knowAny && knownToAll) {
	            celebrity = i;
	            break;
	        }
	    }

	    return celebrity;
    }
}


// Approach: 2 , Using Stack

// Approach: If for any pair (i, j)  such that ‘i’!= ‘j’, if  ‘knows(i, j)’ returns true, then it implies that the person having id ‘i’ cannot be a celebrity as it knows the person having id ‘j’. Similarly if ‘knows(i, j)’ returns false, then it implies that the person having id ‘j’ cannot be a celebrity as it is not known by a person having id ‘i’. We can use this observation to solve this problem


// Algorithm is as follows:

// 1. Create a stack and push all ids in it.
// 2. Run a loop while there are more than one element in the stack and in each iteration do the following-:
//         a. Pop two elements from the stack, let these elements be ‘id1’ and ‘id2’.
//         b. If the person with ‘id1’ knows the person with ‘id2’  i.e ‘knows(id1, id2)’ return true, then the person with ‘id1’ cannot be a celebrity, so push ‘id2’ in the stack.
//         c. Otherwise, if the person with ‘id1’ doesn't know the person with ‘id2’  i.e knows(id1, id2) return false, then the person with ‘id2’ cannot be a celebrity, so push ‘id1’ in the stack.
// 3. Only one id remains in the stack, you need to check whether the person having this id is a celebrity or not, this can be done by running two loops. One checks whether this person is known to everyone or not and another loop will check whether this person knows anyone or not.
// 4. If this person is a celebrity return his id otherwise return -1.

/*
    Time complexity: O(N)
    Space complexity: O(N)
    
    Where 'N' is the number of people at the party.
*/
	
import java.util.Stack;

public class Solution {
	public static int findCelebrity(int n) {

        // Create a stack and push all ids in it.
        Stack<Integer> ids = new Stack<Integer>();
	    for(int i = 0; i < n; i++) {
	        ids.push(i);
	    }

	    // Finding celebrity.
	    while(ids.size() > 1) {
	        int id1 = ids.peek();
	        ids.pop();
	        int id2 = ids.peek();
	        ids.pop();
	        
	        if(Runner.knows(id1, id2)) {
	        	// Because person with id1 can not be celebrity. 
	            ids.push(id2);
	        }
	        else {
	        	// Because person with id2 can not be celebrity.
	            ids.push(id1);
	        }
	    }

        // This can be potentially a celebrity
	    int celebrity = ids.pop();
	    boolean knowAny = false, knownToAll = true;

	    // Verify whether the celebrity knows any other person.
	    for(int i = 0; i < n; i++) {
	        if(Runner.knows(celebrity, i)) {
	            knowAny = true;
	            break;
	        }
	    }

	    // Verify whether the celebrity is known to all the other person.
	    for(int i = 0; i < n; i++) {
	        if(i != celebrity && !Runner.knows(i, celebrity)) {
	            knownToAll = false;
	            break;
	        }
	    }

	    if(knowAny || !knownToAll) {
	        // If verificatin failed, then it means there is no celebrity at the party.
	        celebrity = -1;
	    }

	    return celebrity;
    }
}


// Approach 3 : Two Pointer Approach
// Approach: If for any pair ('i', ‘j’)  such that 'i' != ‘j’, If ‘knows(i, j)’ returns true, then it implies that the person having id ‘i’ cannot be a celebrity as it knows the person having id ‘j’. Similarly if ‘knows(i, j)’ returns false, then it implies that the person having id ‘j’ cannot be a celebrity as it is not known by a person having id ‘i’. 

// So, the Two Pointer approach can be used where two pointers can be assigned, one at the start and the other at the end of the elements to be checked, and the search space can be reduced. This approach can be implemented as follow -:

 

// Algorithm is as follows: 

// 1.Initialize two integer variables ‘P’:= 0 and ‘Q’:= 'N' - 1. ‘P’  and ‘Q’ will be two pointers pointing at the start and end of search space respectively.
// 2.Run a while loop till 'P' < ‘Q’ and in each iteration do the following.
//     a. If ‘knows(P, Q)’ returns true, then increment ‘P’ by 1.
//     b. If ‘knows(P, Q)’ returns false, then decrement ‘Q’ by 1.
// 3.Check whether the person having id ‘P’ is a celebrity or not, this can be done by running two loops. One checks whether this person is known to everyone or not and another loop will check whether this person knows anyone or not.
// 4.If a person having id ‘P’ is a celebrity then return ‘P’, otherwise return -1.
// Time Complexity
// O(N), where ‘N’ is the number of people at the party.

 

// The number of queries from the matrix ‘M’ will be of order ‘N’.

// Space Complexity
// O(1).

 

// No extra space is used here.


/*
    Time complexity: O(N)
    Space complexity: O(1)
    
    Where 'N' is the number of people at the party.
*/

public class Solution {
	public static int findCelebrity(int n) {

        // Two pointers pointing at start and end of search space.
	    int p = 0, q = n - 1; 

	    // Finding celebrity.
	    while(p < q) {
	        if(Runner.knows(p, q)) {
	            // This means p cannot be celebrity.
	            p++;  
	        }
	        else {
	            // This means q cannot be celebrity.
	            q--; 
	        }
	    }

	    int celebrity = p;
	    boolean knowAny = false, knownToAll = true;

	    // Verify whether the celebrity knows any other person.
	    for(int i = 0; i < n; i++) {
	        if(Runner.knows(celebrity, i)) {
	            knowAny = true;
	            break;
	        }
	    }

	    // Verify whether the celebrity is known to all the other person.
	    for(int i = 0; i < n; i++) {
	        if(i != celebrity && !Runner.knows(i, celebrity)) {
	            knownToAll = false;
	            break;
	        }
	    }

	    if(knowAny || !knownToAll) {
	        // If verificatin failed, then it means there is no celebrity at the party.
	        celebrity = -1;
	    }

	    return celebrity;
    }
}