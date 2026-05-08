class Solution {

    public String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();

        for(String s : strs){
            encodedString.append(s).append("~");
        }

        return encodedString.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0, j = 0;

        for(char ch : str.toCharArray()){
            if(ch == '~'){
                result.add(str.substring(i, j));
                i = j+1;
            }
            j++;
        }

        return result;
    }
}
