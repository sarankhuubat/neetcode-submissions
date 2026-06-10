class Solution {
    public int minimumSpanningTree(List<List<Integer>> edges, int n) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(List<Integer> edge : edges){
            int n1 = edge.get(0), n2 = edge.get(1), w = edge.get(2);
            adj.putIfAbsent(n1, new ArrayList<>());
            adj.putIfAbsent(n2, new ArrayList<>());

            adj.get(n1).add(new int[]{n2, w});
            adj.get(n2).add(new int[]{n1, w});
        }

        int count = 0;
        HashSet<Integer> visit = new HashSet<>();
        visit.add(0);
        Queue<int[]> minheap = new PriorityQueue<>((n1, n2) -> (n1[0] - n2[0]));
        
        for(int[] nei : adj.get(0)){
            int n1 = nei[0], w = nei[1];
            minheap.offer(new int[]{w, 0, n1});
        }

        while(visit.size() < n && !minheap.isEmpty()){
            int[] curr = minheap.poll();
            int w = curr[0], n1 = curr[1], n2 = curr[2];
            if(visit.contains(n2)){
                continue;
            }

            count+=w;
            visit.add(n2);
            for(int[] nei : adj.get(n2)){
                int an = nei[0], aw = nei[1];
                if(!visit.contains(an))
                    minheap.offer(new int[]{aw, n2, an});
            }
        }

        return visit.size() == n ? count : -1;
    }
}