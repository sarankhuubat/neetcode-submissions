class Solution {
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int i = 0; i < n; i++){
            adj.put(i, new ArrayList<>());
        }

        for(List<Integer> edge : edges){
            adj.get(edge.get(0)).add(new int[]{edge.get(1), edge.get(2)});
        }

        Map<Integer, Integer> shortest = new HashMap<>();
        PriorityQueue<int[]> minheap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minheap.offer(new int[]{0, src});

        while(!minheap.isEmpty()){
            int[] curr = minheap.poll();
            if(shortest.containsKey(curr[1])){
                continue;
            }

            shortest.put(curr[1], curr[0]);
            for(int[] edge : adj.get(curr[1])){
                if(!shortest.containsKey(edge[0])){
                    minheap.offer(new int[]{curr[0] + edge[1], edge[0]});
                }
            }
        }

        for(int i = 0; i < n; i++){
            shortest.putIfAbsent(i, -1);
        }

        return shortest;
    }  
}
