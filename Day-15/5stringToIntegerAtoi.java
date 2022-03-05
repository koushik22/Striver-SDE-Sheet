// Algorithm

// 1. Initialize two variables:
//     a. sign (to store the sign of the final result) as 1.
//     b. result (to store the 32-bit integer result) as 0.
// 2. Skip all leading whitespaces in the input string.
// 3. Check if the current character is a '+' or '-' sign:
//     a. If there is no symbol or the current character is '+', keep sign equal to 1.
//     b. Otherwise, if the current character is '-', change sign to -1.
// 4. Iterate over the characters in the string as long as the current character represents a digit or until we reach the end of the input string.
//     a. Before appending the currently selected digit, check if the 32-bit signed integer range is violated. If it is violated, then return INT_MAX or INT_MIN as appropriate.
//     b. Otherwise, if appending the digit does not result in overflow/underflow, append the current digit to the result.
// 5. Return the final result with its respective sign, sign * result.


class Solution {
    public int myAtoi(String input) {
        int sign = 1; 
        int result = 0; 
        int index = 0;
        int n = input.length();
        
        // Discard all spaces from the beginning of the input string.
        while (index < n && input.charAt(index) == ' ') { 
            index++; 
        }
        
        // sign = +1, if it's positive number, otherwise sign = -1. 
        if (index < n && input.charAt(index) == '+') {
            sign = 1;
            index++;
        } else if (index < n && input.charAt(index) == '-') {
            sign = -1;
            index++;
        }
        
        // Traverse next digits of input and stop if it is not a digit
        while (index < n && Character.isDigit(input.charAt(index))) {
            int digit = input.charAt(index) - '0';

            // Check overflow and underflow conditions. 
            if ((result > Integer.MAX_VALUE / 10) || 
                (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {     
                // If integer overflowed return 2^31-1, otherwise if underflowed return -2^31.    
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            // Append current digit to the result.
            result = 10 * result + digit;
            index++;
        }
        
        // We have formed a valid number without any overflow/underflow.
        // Return it after multiplying it with its sign.
        return sign * result;
    }
}