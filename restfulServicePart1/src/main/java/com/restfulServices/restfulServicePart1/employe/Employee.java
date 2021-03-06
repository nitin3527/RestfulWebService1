package com.restfulServices.restfulServicePart1.employe;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Employee {
    Integer id;

    @Pattern(regexp = "[a-zA-Z][a-zA-Z ]*")
    @Size(min = 2)
    String name;

    @Min(value = 18)
    @Max(value = 60)
    Integer age;

    protected Employee(){

    }
    Employee(Integer id, String name, Integer age){
        super();
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
