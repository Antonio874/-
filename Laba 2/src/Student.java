public class Student extends Human {
    private String parent;
    private int course;

    public Student(String name, String surname, int old, String parent) {
        super(name, surname, old);
        this.parent = parent;
    }
    public Student(String name, String surname, int old, String parent, int course) {
        super(name, surname, old);
        this.parent = parent;
        this.course = course;
    }
    
    @Override
    public void printInfo() {
        System.out.println("Student: " + getName() + " " + getSurname() + ", Old: " + getOld() + ", Parent: " + parent + ", Course: " +  course);
    }
    
    @Override
    public void read() {
        System.out.println("Платная основа обучения " + getName());
    }
}
