public abstract class Human {
    protected String name;
    protected String surname;
    protected int old;

    public static int totalHuman = 0;
    
    public Human(String name, String surname, int old) {
        this.name = name;
        this.surname = surname;
        this.old = old;
        totalHuman += 1;
    }
    
    public abstract void printInfo();
    
    public abstract void read();
    
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getOld() {
        return old;
    }
    public static int getTotalHuman() {
        return totalHuman;
    }
}