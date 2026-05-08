class TimeMap {

    HashMap<String, List<Pair<Integer, String>>> store;
    public TimeMap() {
        store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!store.containsKey(key)){
            store.put(key, new ArrayList<>());
        } 
        store.get(key).add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!store.containsKey(key))
            return "";
        else {
            List<Pair<Integer, String>> tmp = store.get(key);
            if(tmp.get(tmp.size()-1).getKey() <= timestamp){
                return tmp.get(tmp.size()-1).getValue();
            }
        }

        List<Pair<Integer, String>> tmp = store.get(key);
        int l = 0, r = tmp.size();
        String result = "";
        while(l <= r){
            int mid = l + (r-l)/2;

            if(tmp.get(mid).getKey() <= timestamp){
                l = mid + 1;
                result = tmp.get(mid).getValue();
            }else
                r = mid - 1;
        }

        return result;
    }

    private static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}






