public class TeachingAssistant extends Human {
    private String specialization;
    private int workday;
    
    public TeachingAssistant(String name, String surname, int old, String specialization, int workday) {
        super(name, surname, old);
        this.specialization = specialization;
        this.workday = workday;
    }
    
    @Override
    public void printInfo() {
        System.out.println("TeachingAssistant: " + getName() + " " + getSurname() + ", Old: " + getOld() + ", Specialization: " + specialization + ", Workday: " + workday);
    }
    
    @Override
    public void read() {
        System.out.println("Стажёр " + getName());
    }

}