public class Main {
    public static void main(String[] args) {
        HashTable<Integer, String> hashTable = new HashTable<>();
        hashTable.put(1, "9");
        hashTable.put(2, "5");
        hashTable.put(3, "4");

        System.out.println(hashTable.get(1));
        System.out.println(hashTable.get(2));

        hashTable.remove(1);
        System.out.println(hashTable.get(1));

        System.out.println(hashTable.size());
        System.out.println(hashTable.isEmpty());

        Employee employee = new Employee("Коля","99999999999$","Глав Босс");
        HashTable<Integer, Employee> hashTable2 = new HashTable<>();
        hashTable2.put(1, employee);
        System.out.println(hashTable2.get(1));

        hashTable2.printHashTable();
    }
}