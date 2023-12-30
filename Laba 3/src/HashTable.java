import java.util.LinkedList;
public class HashTable<K, V> {
    private int size = 0;
    private LinkedList<Entry<K, V>>[] table;
    public HashTable() {
        table = new LinkedList[10];
    }
    public void put(K key, V value) {
        int index = getIndex(key);
        if (table[index] == null){
            table[index] = new LinkedList<Entry<K, V>>();
        }
        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        table[index].add(new Entry<>(key, value));
        size++;
    }


    public V get(K key) {
        int index = getIndex(key);
        if (table[index] == null){
            table[index] = new LinkedList<Entry<K, V>>();
        }
        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }
    public void remove(K key) {
        int index = getIndex(key);
        if (table[index] == null){
            table[index] = new LinkedList<Entry<K, V>>();
        }
        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                table[index].remove(entry);
                size--;
                return;
            }
        }
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    private int getIndex(K key) {
        return Math.abs(key.hashCode() % table.length);
    }
    private static class Entry<K, V> {
        private K key;
        private V value;
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public K getKey() {
            return key;
        }
        public V getValue() {
            return value;
        }
        public void setValue(V value) {
            this.value = value;
        }
    }
    public void printHashTable() {
        for (LinkedList<Entry<K, V>> sublist : table) {
            if (sublist != null) {
                for (Entry<K, V> entry : sublist) {
                    System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
                }
            }
        }
    }
}