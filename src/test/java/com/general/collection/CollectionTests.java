package com.general.collection;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toSet;

public class CollectionTests {

    private List<Employee> employeeList = new ArrayList<>();
    ;

    @BeforeEach
    void setUp() {
        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
    }

    @Test
    public void testClassCastExceptionWhileGettingValue() {
        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(2);
            addtolist(list);
            Integer i = list.get(2);
        });
        Assert.assertEquals(ClassCastException.class, exception.getClass());
    }

    private void addtolist(List list) {
        list.add("hello"); //OK
    }


    @Test
    public void testCheckedCollection() {
        //ClassCast exception while adding values
        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            List<Integer> list = new ArrayList<>();
            list = Collections.checkedList(list, Integer.class);
            list.add(1);
            list.add(2);
            addtolist(list);
        });
        Assert.assertEquals(ClassCastException.class, exception.getClass());
    }

    @Test
    void checkArrayListModificationWhileIterating() {
        List<String> lists = new ArrayList<>(Arrays.asList("hello", "world", "to", "me!"));
        Iterator<String> itr = lists.iterator();
        while (itr.hasNext()) {
            lists.set(3, "everyone");
            itr.next();
        }
        lists.parallelStream().forEach(e -> {
            lists.set(3, "everyone");
        });
        Predicate<String> pre = (t) -> t.startsWith("a");
        Predicate<String> p1 = (t) -> t.length() > 10;
        pre.and(p1);
    }

    @Test
    void getSecondHighestSalaryOfDept() {
        Map<String, Double> secondHighestSalaryByDept = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collector.of(() -> new PriorityQueue<Double>(), (queue, emp) -> {
                    queue.add(emp.getSalary());
                    if (queue.size() > 2)
                        queue.remove();
                }, (left, right) -> {
                    left.addAll(right);
                    return left;
                }, (queue) -> queue.peek())));
    }

    @Test
    void countMalesAndFemalesInOrganization() {
        Map<String, Long> genderCount = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        Assertions.assertEquals(11, genderCount.get("Male"));
        Assertions.assertEquals(6, genderCount.get("Female"));
    }

    @Test
    void getNamesOfAllDepartments() {
        List<String> departments = employeeList.stream().map(Employee::getDepartment).distinct().collect(Collectors.toList());
        Assertions.assertEquals(6, departments.size());
    }

    @Test
    void getAverageAgeOfMaleAndFemaleEmployees() {
        Map<String, Double> averageAgeByGender = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,
                Collectors.averagingInt(Employee::getAge)));
               /* Collector.of(()-> new DoubleSummaryStatistics(),
                        (d, emp)-> d.accept(emp.getAge()),
                        (sumaary1, summary2) -> { sumaary1.accept(summary2.getSum()); return sumaary1; },
                        (summary) -> summary.getAverage())));*/
        //Collector.of(()-> new long[2], (a, emp) -> { a[0]+= 1; a[1]++;}, (a, b)->{ a[0]+=b[0]; a[1]+=b[1]; return a; },(a) -> (a[1] == 0) ? 0.0d : (double) a[0] / a[1])));
    }

    @Test
    void getDetailsOfHighestPaidEmployeeInTheOrganization() {
        Employee emp = employeeList.stream().max((emp1, emp2) -> Double.compare(emp1.getSalary(), emp2.getSalary())).get();
        Assertions.assertEquals(277, emp.getId());
    }

    @Test
    void getNamesOfAllEmployeesJoinedAfter2015() {
        List<String> employeeNamesJoinedAfter2015 = employeeList.stream().filter(emp -> emp.yearOfJoining > 2015)
                .map(Employee::getName).collect(Collectors.toList());
        Assertions.assertEquals(5, employeeNamesJoinedAfter2015.size());
    }

    @Test
    void getYoungestMaleEmployeeInPDDepartment() {
        Employee youngestMaleEmployeePDDepartment = employeeList.stream()
                .filter(emp -> emp.getDepartment().equals("Product Development") && emp.getGender().equals("Male"))
                .min(Comparator.comparingInt(Employee::getAge)).get();
        Assertions.assertEquals(222, youngestMaleEmployeePDDepartment.getId());
    }

    @Test
    void mostWorkingExperienceInTheOrganization() {
        Employee mostWorkingExperience = employeeList.stream().min(Comparator.comparingInt(Employee::getYearOfJoining)).get();
        Assertions.assertEquals(177, mostWorkingExperience.getId());
    }

    @Test
    void getMaleFemaleCountByDepartment() {
        Map<String, Long> maleFemaleCountByDepartment = employeeList.stream().filter(e -> e.getDepartment().equals("Sales And Marketing"))
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        Assertions.assertEquals(2, maleFemaleCountByDepartment.get("Male"));
    }

    @Test
    void getAverageSalariesByGender() {
        Map<String, Double> avgSalariesByGender = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,
                Collectors.collectingAndThen(Collectors.summarizingDouble(Employee::getSalary), (summary) -> summary.getAverage())));
        Assertions.assertEquals(20850.0, avgSalariesByGender.get("Female"));
    }

    @Test
    void getAverageAndTotalSalaryOfOrganization() {
        DoubleSummaryStatistics doubleSummaryStatistics = employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        Assertions.assertEquals(21141.235294117647, doubleSummaryStatistics.getAverage());
        Assertions.assertEquals(359401.0, doubleSummaryStatistics.getSum());
    }

    @Test
    void separateEmployeesOlderAndYoungerThan25() {
        Map<Boolean, List<Employee>> partitionByAge = employeeList.stream().collect(Collectors.partitioningBy(emp -> emp.getAge() > 25));
        /*Map<Boolean, List<Employee>> byAge = employeeList.stream().collect(Collectors.groupingBy((emp) ->  emp.getAge() > 25 ? true : false,
                Collector.of(() -> new ArrayList<Employee>(), (list, emp) -> list.add(emp), (list1, list2) -> {list1.addAll(list2); return list1; })));*/
        System.out.println("h");
    }

    @Test
    void getMaleFemaleCountOfEachDepartment() {
        Map<String, Map<String, Integer>> count = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collector.of(() -> new HashMap<String, Integer>(),
                        (map, emp) -> {
                            map.computeIfPresent(emp.getGender(), (key, value) -> ++value);
                            map.computeIfAbsent(emp.getGender(), (key) -> 1);
                        }, (map1, map2) -> {
                            map1.putAll(map2);
                            return map1;
                        })));

    }

    @Test
    void testFindFirstAndFindAny() {
        Optional<Employee> employee = employeeList.parallelStream().filter(emp -> emp.getName().startsWith("J")).findFirst();
        Assertions.assertTrue(employee.isPresent());
        Assertions.assertEquals("Jiya Brein", employee.get().getName());
        List<Integer> list = new ArrayList<>();
        list.stream().collect(Collectors.averagingInt(e -> e));
    }

    @Test
    void findUnvisitedLeaves() throws ClassNotFoundException {
        int N = 3;
        int leaves = 4;
        int[] frogs = {3, 2, 4};
        int[] leaveStatus = new int[leaves + 1];
        int[] leavesVisited = new int[leaves + 1];
        for (int i = 0; i < N; i++) {
            if (frogs[i] <= leaves && leavesVisited[frogs[i]] == 0) {
                for (int j = frogs[i]; j <= leaves; j += frogs[i])
                    leaveStatus[i] = 1;
                leavesVisited[i]++;
            }
        }

        Arrays.sort(frogs);
        if (frogs[0] == 1) {
            System.out.println("All will be visited");
            return;
        }
        Set<Integer> leavesSet = IntStream.rangeClosed(1, leaves).boxed().collect(toSet());
        for (int i = 0; i < frogs.length; i++) {
            for (int j = frogs[i]; j <= leaves; j += frogs[i])
                leavesSet.remove(j);
        }
        System.out.println("Number of leaves unvisited : " + leavesSet.size());
    }

    class Employee {
        protected int id;

        private String name;

        int age;

        String gender;

        String department;

        int yearOfJoining;

        double salary;

        public Employee() {
        }

        public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.department = department;
            this.yearOfJoining = yearOfJoining;
            this.salary = salary;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getGender() {
            return gender;
        }

        public String getDepartment() {
            return department;
        }

        public int getYearOfJoining() {
            return yearOfJoining;
        }

        public double getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return "Id : " + id
                    + ", Name : " + name
                    + ", age : " + age
                    + ", Gender : " + gender
                    + ", Department : " + department
                    + ", Year Of Joining : " + yearOfJoining
                    + ", Salary : " + salary;
        }

    }
}
