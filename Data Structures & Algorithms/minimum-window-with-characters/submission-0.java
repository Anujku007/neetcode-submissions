class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }
        int[] need = new int[128];
        for(int i = 0 ; i < t.length() ; i++){
            need[t.charAt(i)]++;
        }
        int left = 0;
        int minlen = Integer.MAX_VALUE;
        int recquired = t.length();
        int start = 0;
        
        for(int right = 0 ; right < s.length() ; right++){
            char rightchar = s.charAt(right);

            if(need[rightchar] > 0){
                recquired--;
            }
            need[rightchar]--;

            while(recquired == 0){
                int currentlen = right-left+1;
                if(currentlen < minlen){
                    minlen = currentlen;
                    start = left;
                }
                char leftchar = s.charAt(left);
                need[leftchar]++;

                if(need[leftchar] > 0){
                    recquired++;
                }
                left++;
            }
        }
        return minlen == Integer.MAX_VALUE ? "" : s.substring(start , start+minlen);
    }
}
