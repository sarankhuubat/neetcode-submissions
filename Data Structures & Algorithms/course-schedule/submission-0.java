class Solution {
    Map<Integer, List<Integer>> pre = new HashMap<>();
    Set<Integer> visiting = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        for(int i = 0; i < numCourses; i++){
            pre.put(i, new ArrayList<>());
        }

        for(int[] n : prerequisites){
            pre.get(n[0]).add(n[1]);
        }

        for(int i = 0; i < numCourses; i++){
            if(!dfs(i)) return false;
        }

        return true;
    }

    private boolean dfs(int course){
        if(visiting.contains(course))
            return false;

        if(pre.get(course).isEmpty())
            return true;

        visiting.add(course);
        for(int p : pre.get(course)){
            if(!dfs(p))
                return false;
        }

        visiting.remove(course);
        pre.put(course, new ArrayList<>());
        return true;
    }
}
