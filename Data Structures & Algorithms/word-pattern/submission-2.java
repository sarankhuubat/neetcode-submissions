class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, Integer> map = new HashMap<>();
        String[] strs = s.trim().split("\\s+");

        if(pattern.length() != strs.length) return false;

        for(int i = 0; i < pattern.length(); i++){
            if(map.containsKey(pattern.charAt(i))){
                if(!strs[map.get(pattern.charAt(i))].equals(strs[i])){
                    return false;
                }
            } else {
                for(Map.Entry<Character, Integer> entry : map.entrySet()){
                    if(strs[entry.getValue()].equals(strs[i])){
                        return false;
                    }
                }
                map.put(pattern.charAt(i), i);
            }

            
        }

        return true;
    }
}