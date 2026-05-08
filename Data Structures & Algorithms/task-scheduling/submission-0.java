class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : tasks){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(Integer i : map.values()){
            pq.add(i);
        }

        int tmp = pq.poll() - 1;
        int result = tmp * n; //2
        int tmpres = result;

        while(!pq.isEmpty()){
            int cur = pq.poll();
            tmpres -= Math.min(tmp, cur);
        }

        if(tmpres >= 0)
            return tmpres + tasks.length;
        
        return tasks.length;
    }
}
// A - 3 //0 (3) 4 (3) 8
// B - 1 //1 (3) 5 (3) 9
// C - 1

// X - 2
// Y - 2
// result = 4
// tmpres = 4 - 2 - 2 =0
// return tasks.len