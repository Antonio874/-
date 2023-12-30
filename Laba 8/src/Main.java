public class Main {
    public static void main(String[] args) {
        DataManager manager = new DataManager();

        NameSort processor1 = new NameSort();
        ValueSort processor2 = new ValueSort();
        MoreThan processor3 = new MoreThan(400);

        manager.registerDataProcessor(processor1);
        manager.registerDataProcessor(processor2);
        manager.registerDataProcessor(processor3);

        manager.loadData("Data.txt");
        manager.processData();
        manager.saveData("newData.txt");
    }
}