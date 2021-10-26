package com.pluralsight;

import java.util.Comparator;
import java.util.Date;

public class Person implements Comparable<Person> {

    private int id;
    private String name;
    private String birth;

    public Person() {
    }

    public Person(int id, String name, String birth) {
        this.id = id;
        this.name = name;
        this.birth = birth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birth='" + birth + '\'' +
                '}';
    }


    @Override
    public int compareTo(Person o) {
        if (this.getId() > o.getId()){
            return 1;
        }else if (this.getId() < o.getId()){
            return -1;
        }
        return  0;
    }

}
