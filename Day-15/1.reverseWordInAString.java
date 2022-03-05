class Solution {
    public String reverseWords(String s) {
        // to remove one or more spaces 
        String[] parts = s.split(" +");
        StringBuilder sb = new StringBuilder("");
        
        for(int i = parts.length - 1; i >= 0; i--){
            if(!parts[i].equals(" ")){
                sb.append(parts[i]);
                sb.append(" ");
            }
        }
        
        return sb.toString().trim();
    }
}
