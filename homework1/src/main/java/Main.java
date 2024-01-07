import com.google.gson.Gson;

/**
 * Проба Gson
 */
public class Main {
    public static void main(String[] args){
        Student student = new Student("Вася", "Пупкин");
        student.setCourseNumber(1);
        student.setGroupNumber(1010);
        System.out.println("Исходный студент: " + student);
        Gson gson = new Gson();
        String serializedStudent = gson.toJson(student);
        System.out.println("Сериализованный студент: " + serializedStudent);
        System.out.println("Десериализованный студент: " + gson.fromJson(serializedStudent, Student.class));
    }
}
