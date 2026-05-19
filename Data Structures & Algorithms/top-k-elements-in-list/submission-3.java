class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<int[]> arr = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            arr.add(new int[]{entry.getKey(), entry.getValue()});
        }

        arr.sort((a,b) -> b[1] - a[1]);

        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = arr.get(i)[0];
        }

        return res;
    }
}
