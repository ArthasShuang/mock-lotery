import java.time.Instant;
import java.util.HashMap;

public class LRUCache {
    private int capacity;
    private HashMap<Integer, Info> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    int get(int key){
        return map.get(key).getValue();
    }

    void put(int key, int value){
        map.put(key, new Info(value, Instant.now().getNano(), 0));
        if(map.keySet().size()>capacity){
            int removeKey = map.entrySet().stream().min((entry1, entry2)->entry1.getValue().getTime()>entry2.getValue().getTime()?1:0).get().getKey();
            map.remove(removeKey);
        }
    }

    class Info {
        public Info(int value, int time, int count) {
            this.value = value;
            this.time = time;
            this.count = count;
        }

        private int value;
        private int time;
        private int count;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
}
