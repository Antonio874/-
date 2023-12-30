public class Main {
    public static void main(String[] args) {

        Student Student1 = new Student("Александр", "Кравчук", 19, "Дмитрий Иванович", 1);
        Student Student2 = new Student("Анна", "Ветрова", 18, "Анастасия Викторовна", 3);
        Student1.printInfo();
        Student1.read();
        System.out.println();
        Student2.printInfo();
        Student2.read();


        System.out.println();

        Teacher Teacher = new Teacher();
        Teacher.setSubject("математика");
        Teacher.setExperience(6);
        Teacher.printInfo();
        Teacher.read();

        System.out.println();

        TeachingAssistant TeachingAssistant = new TeachingAssistant("Константин", "Петров", 24, "Теория вероятности", 4);
        TeachingAssistant.printInfo();
        TeachingAssistant.read();

        System.out.println("Всего человеков:" + Human.getTotalHuman());
    }

}