public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.peek());

        SalesTracker tracker = new SalesTracker();
        tracker.addSale("Apple", 3);
        tracker.addSale("Banana", 5);
        tracker.addSale("Orange", 2);
        tracker.printSales();
        System.out.println("Total sales: " + tracker.getTotalSales());
        System.out.println("Most popular item: " + tracker.getMostPopularItem());
    }
}
