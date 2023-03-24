import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        new Thread(()-> {System.out.println("Printing from the Runnable class");
            System.out.println("Line 2 !!");
            System.out.format("This is line %d\n",3);
        }).start();

        Employee joe = new Employee("John", 35);
        Employee qarl = new Employee("Karl",42);
        Employee nate = new Employee("Nate", 51);
        Employee pen = new Employee("Penworth",29);

        List<Employee> employees = new ArrayList<>();
        employees.add(joe);
        employees.add(qarl);
        employees.add(nate);
        employees.add(pen);

        Collections.sort(employees,( emp1, emp2) ->
                emp1.getName().compareTo(emp2.getName())
                );
        for(Employee emp1:employees){
            System.out.println(emp1.getName());
        }
        /*String theThing = doStringThing(new UpperConcat() {
            @Override
            public String upperAndConcat(String s1, String s2) {
                return s1.toUpperCase() + s2.toUpperCase();
            }
        }, employees.get(0).getName(),employees.get(1).getName());
        System.out.println(theThing);*/
        UpperConcat uc = (s1, s2) -> {
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };

        String theThing = doStringThing(uc, employees.get(0).getName(),employees.get(1).getName());
        System.out.println(theThing);

    }
    public final static String doStringThing(UpperConcat uc, String s1, String s2){
        return uc.upperAndConcat(s1, s2);
    }
}

class CodeToRun implements Runnable{
    @Override
    public void run() {
        System.out.println("Printing from the runnable");
    }
}

class Employee{

    private String name;
    private int age;

    public Employee (String name,int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

interface UpperConcat{
    public String upperAndConcat(String s1, String s2);
}
//class AnotherClass{
//
//    public String doSomething(){
//        return Main.doStringThing(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                return s1.toUpperCase()+s2.toUpperCase();
//            }
//        }, "String1 ","String2 ");
//    }
//}

