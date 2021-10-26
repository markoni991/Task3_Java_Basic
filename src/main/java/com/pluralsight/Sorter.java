package com.pluralsight;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Sorter {

    List<Person> listOfPersons;
    Person person = new Person();
    CSVFileReader csvFileReader = new CSVFileReader();

    public List<Person> sortById(){

        listOfPersons = csvFileReader.listAllFromCSV("personData.csv");

        Iterator<Person> personIterator = listOfPersons.iterator();
        while (personIterator.hasNext()){
            Person p = personIterator.next();

        }
        Collections.sort(listOfPersons);
        System.out.println("After sorting: ");

        Iterator<Person>afterIterator = listOfPersons.iterator();
        while (afterIterator.hasNext()){
            Person p = afterIterator.next();
            System.out.println(p + "ID:  " + p.getId());
        }
        return listOfPersons;
    }

    public List<Person> sortByBirth(){

        listOfPersons = csvFileReader.listAllFromCSV("personData.csv");

        Collections.sort(listOfPersons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getBirth().compareTo(o2.getBirth());
            }
        });

        System.out.println("Nakon sortiranja: ");
        Iterator<Person>afterIterator = listOfPersons.iterator();
        while (afterIterator.hasNext()){
            Person p = afterIterator.next();
            System.out.println(p + "Date is:  " + p.getBirth());
        }

        return listOfPersons;
    }
}
