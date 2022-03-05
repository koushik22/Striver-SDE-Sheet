// 1. Initialise sum (or) Push the mapped value of the last character of the string in our sum variable.
// 2. Compare last two character values in the map
// 3. Start loop from n-2
// 4. If s[a] < s[a+1] then sum = sum - s[a], Otherwise sum = sum + s[a]
// 5. Return sum;

import java.util.*;
class Solution {
    public int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int res = 0;
        
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        res += map.get(s.charAt(s.length() - 1));
        
        for(int i = s.length() - 2; i >= 0; i--){
            if(map.get(s.charAt(i)) < map.get(s.charAt(i + 1))){
                res -= map.get(s.charAt(i));
            }
            else{
                res += map.get(s.charAt(i));
            }
        }
        
       
        return res;
    }
}