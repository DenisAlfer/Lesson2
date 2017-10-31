import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student implements Comparable<Student> {

    private int id;
    private String firstname;
    private String lastname;
    private int age;

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
    @Override
    public int compareTo(Student student) {
        int compareage=student.getAge();
        return this.age-compareage;
    }

    //2. Реализовать метод, который выберет (отфильтрует) всех студентов, чья фамилия начинается на определенную букву (метод возращает лист подходящих объетов)
    public static List<Student> studentsBySymbol(List<Student> students, char firstsymb)
    {
        ArrayList<Student> filtered = new ArrayList();
        for(int i=0; i<students.size(); i++)
        {
            char symb = students.get(i).getLastname().charAt(0);
            if ((symb==firstsymb) || (symb==Character.toUpperCase(firstsymb)))
            {
                filtered.add(students.get(i));
            }
        }
        return filtered;
    }

    //3. Реализовать метод, который посчитает среднее арифметическое по возрасту студентов (метод возращает средний арифметический возраст студентов)
    public static int averageAge(List<Student> students)
    {
        float aveage = 0;

        for(int i = 0; i < students.size(); i++)
            aveage += students.get(i).getAge();
        return Math.round(aveage/students.size());
    }

    //4. Реализовать метод, который преобразует лист студентов в мапу <id студента - студент> (метод возвращает Map) - опционально
    public static Map<String,Student> listToMap(List<Student> students)
    {
        Map mapstudents = new HashMap();
        for (int i=0; i<students.size(); i++)
        {
            mapstudents.put(students.get(i).getId(),students.get(i));
        }
        return mapstudents;
    }

    //5. Из Map предыдущего пункта отобрать (отфильтровать) студентов, id которых больше 100 (метод возвращает Map) - опционально
    public static Map<String,Student> filterMap(Map<String,Student> studentMap)
    {
        Map filteredmap = new HashMap();
        for(Map.Entry<String,Student> entry : studentMap.entrySet()) {
            if (entry.getValue().getId()>100)
            {
                filteredmap.put(entry.getKey(),entry.getValue());
            }
        }

        return filteredmap;
    }
}