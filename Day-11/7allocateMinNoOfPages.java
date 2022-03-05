// Problem Statement: Given an array of integers A of size N and an integer B.

// The College library has N bags, the ith book has A[i] number of pages.

// You have to allocate books to B number of students so that the maximum number of pages allocated to a student is minimum.

// Conditions given :

// A book will be allocated to exactly one student.

// Each student has to be allocated at least one book.

// Allotment should be in contiguous order, for example, A student cannot be allocated book 1 and book 3, skipping book 2.

// Calculate and return the minimum possible number. Return -1 if a valid assignment is not possible.



// Solution: Using Binary Search

// Intuition : 

// Let’s analyze a case. 

// We are given A = [12, 34, 67, 90] and B = 1. So, for one student we can allocate all books to this student. Why so? Because we have to maximize the number of pages allocated to a student and then find the minimum out of it. So, this fact gives us an idea that a single student will be allocated the sum of all pages available.

// Let’s analyze another case.

// We are required to find the minimum number of pages among all possible maximum number of pages of allocations. So, in the worst case, the minimum possible will be minimum pages among all given books.

// Now, we know the lowest possible answer and the maximum possible answer and for general cases, the answer will lie in between these edge cases. Thus, we have a search space. This search space will be sorted. Guess what? We reached our approach to use a binary solution.

// Approach :

// We will set a search space. The lower boundary will be of minimal value among all the books given. The upper boundary will be the sum of all book pages given. Then apply binary search. How to change the range of searching? While searching, allocate pages to each student in such a way that the sum of allocated pages of each student is not greater than the mid-value of search space. If allocating students increases more than the number of students provided, this shows that mid-value should be more, and hence, we move right by restricting our lower boundary as mid+1. If an allocation is possible then reduce the search upper boundary by mid-1. Also, an edge case to check while allocating, each book page should not be greater than mid-value chosen as a barrier.

import java.util.*;
//to check if allocation of books among given students is possible.
class TUF {
    static boolean isPossible(ArrayList < Integer > A, int pages, int students) {
        int cnt = 0;
        int sumAllocated = 0;
        for (int i = 0; i < A.size(); i++) {
            if (sumAllocated + A.get(i) > pages) {
                cnt++;
                sumAllocated = A.get(i);
                if (sumAllocated > pages) return false;
            } else {
                sumAllocated += A.get(i);
            }
        }
        if (cnt < students) return true;
        return false;
    }
    public static int books(ArrayList < Integer > A, int B) {
        if (B > A.size()) return -1;
        int low = A.get(0);
        int high = 0;
        for (int i = 0; i < A.size(); i++) {
            high = high + A.get(i);
            low = Math.min(low, A.get(i));
        }
        int res = -1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            //cout << low << " " << high << " " << mid << endl; 
            if (isPossible(A, mid, B)) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        // return res -> this is also correct
        return low;
    }
    public static void main(String args[]) {
        ArrayList < Integer > A = new ArrayList < > ();
        A.add(12);
        A.add(34);
        A.add(67);
        A.add(90);
        int B = 2;
        System.out.println("Minimum Possible Number is " + books(A, B));
    }
}

// Output: Minimum Possible Number is 113

// Time Complexity : O(NlogN)

// Reason: Binary search takes O(log N). For every search, we are checking if an allocation is possible or not. Checking for allocation takes O(N).

// Space Complexity: O(1)

// Reason: No extra data structure is used to store spaces.