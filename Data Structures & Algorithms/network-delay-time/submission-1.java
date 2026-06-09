class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj= new HashMap<>();
        for(int i = 1; i < n + 1; i++){
            adj.put(i, new ArrayList<>());
        }

        for(int[] time : times){
            adj.get(time[0]).add(new int[]{time[1], time[2]});
        }

        Queue<int[]> minheap = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        minheap.offer(new int[]{0, k});
        Set<Integer> visited = new HashSet<>();
        int t = 0;
        while(!minheap.isEmpty()){
            int[] curr = minheap.poll();
            int w1 = curr[0], n1 = curr[1];
            if(visited.contains(n1)){
                continue;
            }
            visited.add(n1);
            t = w1;

            if(adj.containsKey(n1)){
                for(int[] next:adj.get(n1)){
                    int n2 = next[0], w2 = next[1];
                    if(!visited.contains(n2)){
                        minheap.offer(new int[]{w1+w2, n2});
                    }
                }
            }
        }

        return visited.size() == n ? t : -1;
    }
}
