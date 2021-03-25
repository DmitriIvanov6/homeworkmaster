package Lesson5;

public class Employee {
    private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Employee (String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void printInfo() {
        System.out.printf("Сотрудник Имя: %s, должность: %s, почта %s, телефон %s, з/п: %s, возраст %s%n", name, position,
                email, phone, salary, age);
    }



}
