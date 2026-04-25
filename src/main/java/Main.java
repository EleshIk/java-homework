import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Иван", "А-1", 1, List.of(5, 4, 3, 4))); // ср: 4.0
        students.add(new Student("Петр", "Б-2", 2, List.of(2, 3, 2, 3))); // ср: 2.5
        students.add(new Student("Анна", "А-1", 1, List.of(5, 5, 5, 4))); // ср: 4.75

        System.out.println("До обработки: " + students);

        removeWeakStudents(students);
        System.out.println("После удаления: " + students);

        promoteStudents(students);
        System.out.println("После перевода: " + students);

        System.out.println("\nСтуденты 2 курса:");
        printStudents(students, 2);
    }

    public static void removeWeakStudents(List<Student> students) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getAverageGrade() < 3.0) {
                iterator.remove();
            }
        }
    }

    public static void promoteStudents(List<Student> students) {
        for (Student s : students) {
            s.nextCourse();
        }
    }

    public static void printStudents(List<Student> students, int course) {
        students.stream()
                .filter(s -> s.getCourse() == course)
                .forEach(s -> System.out.println(s.getName()));
    }




}
