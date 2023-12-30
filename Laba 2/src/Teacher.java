public class Teacher extends Human {
    private String subject;
    private int experience;
    
    public Teacher() {
        super("Игорь" , "Барисович", 46);
    }
    
    @Override
    public void printInfo() {
        System.out.println("Teacher: " + getName() + " " + getSurname() + ", Old: " + getOld() + ", Subject: " + subject + ", Experience: " + experience + " years");
    }
    
    @Override
    public void read() {
        System.out.println("Доцент " + getName());
    
    }
    public void setSubject(String subject){
        this.subject = subject;
    }
    public void setExperience(int experience){
        this.experience = experience;
    }
}