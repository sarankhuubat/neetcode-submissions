class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hashmap = new HashMap<>();

        for(int n : nums){
            hashmap.put(n , hashmap.getOrDefault(n, 0) + 1);
        }

        List<int[]> arr = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : hashmap.entrySet()){
            arr.add(new int[]{entry.getValue(), entry.getKey()});
        }

        arr.sort((a, b) -> b[0] - a[0]);

        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = arr.get(i)[1];
        }

        return res;
    }
}
