import java.util.List;

public class Student {
    private String name;
    private String group;
    private int course;
    private List<Integer> grades;

    public Student(String name, String group, int course, List<Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public String getName() { return name; }
    public int getCourse() { return course; }

    // Метод расчета среднего балла
    public double getAverageGrade() {
        if (grades.isEmpty()) return 0;
        double sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    // Метод перевода на следующий курс
    public void nextCourse() {
        if (getAverageGrade() >= 3.0) {
            this.course++;
        }
    }

    @Override
    public String toString() {
        return name + " (Курс: " + course + ", Средний балл: " + String.format("%.2f", getAverageGrade()) + ")";
    }
}

