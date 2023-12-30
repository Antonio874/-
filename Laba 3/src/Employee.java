public class Employee {
    private String name;
    private String wages;
    private String post;
    public Employee(String name, String wages, String post) {
        this.name = name;
        this.wages = wages;
        this.post = post;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", wages=" + wages +
                ", post='" + post + '\'' +
                '}';
    }
    public String getPost() {
        return post;
    }
    public void setPost(String post) {
        this.post = post;
    }
    public String getWages() {
        return wages;
    }
    public void setWages(String wages) {
        this.wages = wages;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}