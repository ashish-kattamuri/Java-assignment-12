package JavaAssignments.Assignment12;
import java.util.*;
import java.util.stream.*;
public class Student {
    int  id;String name;int age;String gender;String engDepartment;
    int yearofenrollment ;double perTillDate;
    public Student(int  id,String name,int age,String gender,String engDepartment,
                   int yearofenrollment ,double perTillDate) {
        this.id=id;
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.engDepartment=engDepartment;
        this.perTillDate=perTillDate;
        this.yearofenrollment=yearofenrollment;
    }
    public String getDept() {
        return engDepartment;
    }
    public String getStudentName() {
        return name;
    }
    public int yearOfEnroll() {
        return yearofenrollment;
    }
    public int getAge() {
        return age;
    }
    public boolean isMale() {
        return gender.equalsIgnoreCase("male");
    }
    public String getGender() {
        return gender;
    }
    public double getPercentile() {
        return perTillDate;
    }
    public static void main(String[] args) {
        Student s1=new Student(111, "Jiya Brein", 17, "Female", "Computer Science", 2018, 70.8);
        Student s2=new Student(122, "Paul Niksui", 18, "Male", "Mechanical", 2016, 50.2);
        Student s3=new Student(133, "Martin Theron", 17, "Male", "Electronic", 2017, 90.3);
        Student s4= new Student(144, "Murali Gowda", 18, "Male", "Electrical", 2018, 80);
        Student s5=new Student(155, "Nima Roy", 19, "Female", "Textile", 2016, 70);
        Student s6=new Student(166, "Iqbal Hussain", 18, "Male", "Security", 2016, 70);
        Student s7=new Student(177, "Manu Sharma", 16, "Male", "Chemical", 2018, 70);
        Student s8=new Student(188, "Wang Liu", 20, "Male", "Computer Science", 2015, 80);
        Student s9=new Student(199, "Amelia Zoe", 18, "Female", "Computer Science", 2016, 85);
        Student s10=new Student(200, "Jaden Dough", 18, "Male", "Security", 2015, 82);
        Student s11=new Student(211, "Jasna Kaur", 20, "Female", "Electronic", 2019, 83);
        Student s12=new Student(222, "Nitin Joshi", 19, "Male", "Textile", 2016, 60.4);
        Student s13=new Student(233, "Jyothi Reddy", 16, "Female", "Computer Science", 2015, 45.6);
        Student s14=new Student(244, "Nicolus Den", 16, "Male", "Electronic", 2017, 95.8);
        Student s15=new Student(255, "Ali Baig", 17, "Male", "Electronic", 2018, 88.4);
        Student s16=new Student(266, "Sanvi Pandey", 17, "Female", "Electric",2019, 72.4);
        Student s17=new Student(277, "Anuj Chettiar", 18, "Male", "Computer Science", 2017, 57.5);
        List<Student> list= new ArrayList<>( List.of(s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17));
        System.out.println("Printing Departments");
        System.out.println();
        printdepartments(list);
        System.out.println("names of all students who have enrolled after 2018");
        getNamesOfStudentsAfter2018(list);
        System.out.println();
        System.out.println("details of all male student in the computer sci department");
        malesinCSE(list);
        System.out.println();
        System.out.println("male and female students ");
        maleFemaleFriends(list);
        System.out.println();
        System.out.println(" average age of male and female students");
        averageAge(list);
        System.out.println();
        System.out.println("student having highest percentage");
        highestPercentage(list);
        System.out.println();
        System.out.println("number of students in each department");
        numberOfStudentsInEachDepartment(list);
        System.out.println();
        System.out.println("average percentage achieved in each department");
        averagePercentageAchievedInEachDepartment(list);
        System.out.println();
        System.out.println("details of youngest male student in the Electronic department");
        youngestMaleStudentInElectronicDepartment(list);
        System.out.println();
        System.out.println("male and female students are there in the computer science department");
        studentsinCSE(list);

    }
    private static void highestPercentage(List<Student> list) {
        Optional<Student>  student=list.stream()
                .collect(Collectors.maxBy(Comparator.comparingDouble(Student::getPercentile)));
        Student s=student.get();
        System.out.println(s.name+","+s.id+","+s.name+","+s.age+","+s.gender+","+s.engDepartment+","+
                s.yearofenrollment+","+s.perTillDate);

    }
    private static void studentsinCSE(List<Student> list) {
        Map<String,Long> h=list.stream()
                .filter(s->s.getDept().equals("Computer Science"))
                .collect(Collectors.groupingBy(Student::getGender,Collectors.counting()));
        System.out.println(h);

    }
    private static void youngestMaleStudentInElectronicDepartment(List<Student> list) {
        Optional<Student> youngest=list.stream()
                .filter(st->st.getDept().equals("Electronic") && st.getGender().equals("Male"))
                .collect(
                        Collectors.minBy(Comparator.comparingInt(Student::getAge)));
        Student s=youngest.get();
        System.out.println(s.name+","+s.id+","+s.name+","+s.age+","+s.gender+","+s.engDepartment+","+
                s.yearofenrollment+","+s.perTillDate);

    }
    private static void averagePercentageAchievedInEachDepartment(List<Student> list) {
        Map<String, Double> h=list.stream()
                .collect(
                        Collectors.groupingBy(Student::getDept,Collectors.averagingDouble(Student::getPercentile)));
        System.out.println(h);


    }
    private static void numberOfStudentsInEachDepartment(List<Student> list) {
        Map<String,Long> h=list.stream()
                .collect(Collectors.groupingBy(Student::getDept,Collectors.counting()));
        System.out.println(h);

    }
    private static void averageAge(List<Student> list) {

        Map<String, Double> avgAgeOfMaleAndFemaleEmployees=list.stream()
                .collect(Collectors.groupingBy
                        (Student::getGender, Collectors.averagingInt(Student::getAge)));

        System.out.println(avgAgeOfMaleAndFemaleEmployees);

    }
    private static void maleFemaleFriends(List<Student> list) {
        Map <String, Long> byGender = list.stream()
                .collect(Collectors.groupingBy(p -> p.getGender(), Collectors.counting()));
        System.out.println(byGender);
    }
    private static void malesinCSE(List<Student> list) {
        List<Student> l=list.stream()
                .filter(m->m.isMale())
                .collect(Collectors.toList());
        for(Student s:l)
            System.out.println(s.name+","+s.id+","+s.name+","+s.age+","+s.gender+","+s.engDepartment+","+
                    s.yearofenrollment+","+s.perTillDate);

    }
    private static void getNamesOfStudentsAfter2018(List<Student> list) {
        list.stream()
                .filter(sa->sa.yearOfEnroll()>2018)
                .map(Student::getStudentName)
                .forEach(System.out::println);

    }
    private static void printdepartments(List<Student> list) {
        list.stream()
                .map(Student::getDept)
                .distinct()
                .forEach(System.out::println);

    }
}
