public class Student {
    private String name, surname;
    private int courseNumber, groupNumber;
    private double GPA;
    public Student(){
        //Пустой конструктор для сериализатора
    }

    public Student(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", courseNumber=" + courseNumber +
                ", groupNumber=" + groupNumber +
                ", GPA=" + GPA +
                '}';
    }
}
