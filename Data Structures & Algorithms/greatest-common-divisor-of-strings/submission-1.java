class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1 + str2).equals(str2 + str1)){
            return "";
        }

        int g = gcd(str1.length(), str2.length());
        return str1.substring(0, g);
    }

    private int gcd(int l1, int l2){
        return l2 == 0 ? l1 : gcd(l2, l1 % l2);
    }
}