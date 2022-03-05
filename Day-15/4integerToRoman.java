// Idea:
// Just like Roman to Integer, this problem is most easily solved using a lookup table for the conversion between digit and numeral. In this case, we can easily deal with the values in descending order and insert the appropriate numeral (or numerals) as many times as we can while reducing the our target number (N) by the same amount.

// Once N runs out, we can return ans.

// Implementation:
// Java's StringBuilder can take care of repeated string concatenations without some of the overhead of making string copies.

class Solution {
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
	    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        
        int i = 0;
        
        while(num > 0){
            while(num >= values[i]){
                result.append(roman[i]);
                num -= values[i];
            }
            i++;
        }
        return result.toString();
    }
}