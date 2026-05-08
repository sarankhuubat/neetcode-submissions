class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupString = new HashMap<>();

        for(String s : strs){
            char[] tmpCharArray = s.toCharArray();
            Arrays.sort(tmpCharArray);

            String sortedStr = String.valueOf(tmpCharArray);
            if(!groupString.containsKey(sortedStr))
                groupString.put(sortedStr, new ArrayList<>());
            groupString.get(sortedStr).add(s);
        }

        return new ArrayList(groupString.values());
    }
}
