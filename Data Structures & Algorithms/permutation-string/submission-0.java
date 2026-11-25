class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if(n1 > n2){
            return false;
        }
        int[] freq = new int[26];
        int[] windowfreq = new int[26];
        for(int i = 0 ; i < n1 ; i++){
            freq[s1.charAt(i) - 'a']++;
            windowfreq[s2.charAt(i) - 'a']++;
        }
        if(Arrays.equals(freq,windowfreq)){
            return true;
        }
        for(int right = n1 ; right < n2 ; right++){
            windowfreq[s2.charAt(right) - 'a']++;
            windowfreq[s2.charAt(right - n1) - 'a']--;

            if(Arrays.equals(freq,windowfreq)){
                return true;
            }
        }
        return false;
    }
}
