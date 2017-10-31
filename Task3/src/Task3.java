import java.util.*;
import java.util.stream.Stream;

public class Task3 {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();

        students.add(0, new Student(0,"Denis","Alfer",27));
        students.add(1, new Student(21, "Eugene", "Romaniuk", 27));
        students.add(2, new Student(113,"Tatiana", "Pivovarchik", 18));
        students.add(3, new Student(25, "Valentina", "Horoshilova", 19));
        students.add(4, new Student(15, "Emil", "Gasanov",36));
        students.add(5, new Student(109, "Alexander", "Martsynkevich", 44));
        students.add(6, new Student(93, "Dmitry", "Kirienko", 14));
        students.add(7, new Student(29, "Anhelina", "Kuznetsova", 20));
        students.add(8, new Student(320, "Ekaterina", "Svitina", 19));
        students.add(9, new Student(100, "Ekaterina", "Amurskaya", 13));

        Stream<Student> streamFromCollection = students.stream();
        System.out.println("Отсортированный по возрасту список студентов:");
                streamFromCollection.sorted(new Student())
                .forEach(p->p.studentInfo());

        System.out.println();
        System.out.println("Введите начальную букву фамилии:");
        Scanner scan = new Scanner(System.in);
        String firstsymb = scan.next().substring(0);

        System.out.println("Список студентов, чья фамилия начинается с буквы '" + firstsymb + "':");
        Student.studentsBySymbol(students,firstsymb).stream().forEach(s -> s.studentInfo());

        int averageage = Student.averageAge(students);
        System.out.println();
        System.out.println("Средний возраст всех студентов ~ " + averageage);
    }
}
