import java.util.*;
import java.util.stream.Collectors;

public class Student implements Comparator<Student> {

    private int id;
    private String firstname;
    private String lastname;
    private int age;

    public Student() {}

    public Student(int id, String firstname, String lastname, int age)
    {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    public int getId()    {
        return id;
    }

    public void setId(int id)    {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void studentInfo()
    {
        System.out.println(firstname + " " + lastname + ", " + age + " лет");
    }

    //1. Реализовать метод сортировки коллекции по одному из полей (например, возраст)
    public int compare(Student a, Student b){

        return a.getAge() - b.getAge();
    }

    //2. Реализовать метод, который выберет (отфильтрует) всех студентов, чья фамилия начинается на определенную букву (метод возращает лист подходящих объетов)
    public static List<Student> studentsBySymbol(List<Student> students, String firstsymb)
    {
        List<Student> filtered = students.stream().filter(l -> l.getLastname().startsWith(firstsymb) | l.getLastname().startsWith(firstsymb.toUpperCase())).collect(Collectors.toList());
        return filtered;
    }

    //3. Реализовать метод, который посчитает среднее арифметическое по возрасту студентов (метод возращает средний арифметический возраст студентов)
    public static int averageAge(List<Student> students)
    {
        float aveage = students.stream().reduce(0, (sum, p) -> sum += p.getAge(), (sum1, sum2) -> sum1 + sum2);
        return Math.round(aveage/students.size());
    }
}