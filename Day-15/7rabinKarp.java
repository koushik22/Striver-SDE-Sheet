// Problem Statement
// You are given a string ‘str’ of length 'N' and a string ‘pat’ of length 'M'. Your task is to find the starting index of all the occurrences of ‘pat’ in str.
// You need to return a list of integers that denote the indices from which ‘pat’ is present in ‘str’(consider 0 based indexing).
// For example,
// Let str= “AABAACAADAABAABA”
// And pat= “AABA”
// We will return the array/list [0,9,12] as we can clearly see that from indices 0 9 and 12 we have the same pattern ‘pat’ in ‘str’

// Brute Force
// The key idea in solving this problem using this approach is that we can naively search for pattern ‘ptr’ in ‘str’ by simply iterating through the ‘str’. If we find a match we add the current index in our array/list ‘result’.

// The algorithm will be -

//     a. We start iterating from the start of the string ‘str’ to (size of ‘str’ - size of ‘pat’) to check for a match.
//     b. In each iteration, we define a variable ‘j’ which and take a loop from ‘i’ to ‘i+ size of ‘pat’) to match the pattern string with the current string from index ‘i’. If the current substring from index ‘i’ matches the pat string, we add ‘i’ to our array/list ‘result’.
//     c. Finally, we return the array/list ‘result’.
// Time Complexity
// O(N*M), where ‘N’ is the length of the string str and ‘M’ is the length of string pat.

 

// In the worst case we need to check for each character if it matches ‘pat’ or not so the complexity will be O(N*M)

// Space Complexity
// O(N), where ‘N’ is the length of the string ‘str’

// The maximum size of the array/list ‘result’ will be O(N).

/*
    Time Complexity: O(N*M)
    Space Complexity: O(N)

    Where 'N' is the length of the string 'str' and 'M' is the length of 'pat'
*/

import java.util.ArrayList;

public class Solution {
	public static ArrayList<Integer> stringMatch(String str, String pat) {

		ArrayList<Integer> result = new ArrayList<Integer>();

		// Iterate through all possible starting indices
		for (int i = 0; i <= str.length() - pat.length(); i++) {

			boolean flag = true;

			for (int j = 0; j < pat.length(); j++) {
				// If a character mismatch occurs
				if (str.charAt(i + j) != pat.charAt(j)) {
					flag = false;
				}
			}

			if (flag) {
				result.add(i);
			}
		}

		return result;
	}
}


// For optimized solution(Using Rabin Karp Algo) follow this https://www.codingninjas.com/codestudio/problems/1115738?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=2