import java.util.concurrent.ConcurrentHashMap;
public class SalesTracker {
    private ConcurrentHashMap<String, Integer> sales;
    public SalesTracker() {
        sales = new ConcurrentHashMap<>();
    }
    // добавляет новую продажу в переменную sales
    public void addSale(String item, int quantity) {
        sales.put(item, sales.getOrDefault(item, 0) + quantity);
    }
    // выводит список всех продаж
    public void printSales() {
        System.out.println("Sales:");
        for (String item : sales.keySet()) {
            System.out.println(item + ": " + sales.get(item));
        }
    }
    // возвращает общее количество продаж
    public int getTotalSales() {
        int totalSales = 0;
        for (int salesCount : sales.values()) {
            totalSales += salesCount;
        }
        return totalSales;
    }
    // возвращает наиболее популярный товар
    public String getMostPopularItem() {
        String mostPopularItem = null;
        int maxSales = 0;
        for (String item : sales.keySet()) {
            int itemSales = sales.get(item);
            if (itemSales > maxSales) {
                mostPopularItem = item;
                maxSales = itemSales;
            }
        }
        return mostPopularItem;
    }
}