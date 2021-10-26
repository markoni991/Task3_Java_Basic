package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ResultFileSaver {

    CSVFileReader fr = new CSVFileReader();
    Sorter sorter = new Sorter();
    List<Person> listOfPersons;

    public List<Person> sortById(){

        listOfPersons = fr.listAllFromCSV("personData.csv");

        Iterator<Person> personIterator = listOfPersons.iterator();
        while (personIterator.hasNext()){
            Person p = personIterator.next();

        }
        Collections.sort(listOfPersons);
        //System.out.println("After sorting: ");

        Iterator<Person>afterIterator = listOfPersons.iterator();
        while (afterIterator.hasNext()){
            Person p = afterIterator.next();
            //System.out.println(p + "ID:  " + p.getId());
        }
        return listOfPersons;
    }
    public List<Person> sortByBirth(){

        listOfPersons = fr.listAllFromCSV("personData.csv");

        Collections.sort(listOfPersons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getBirth().compareTo(o2.getBirth());
            }
        });

        //System.out.println("Nakon sortiranja: ");
        Iterator<Person>afterIterator = listOfPersons.iterator();
        while (afterIterator.hasNext()){
            Person p = afterIterator.next();
            //System.out.println(p + "Date is:  " + p.getBirth());
        }

        return listOfPersons;
    }

    public void writeFile(){

        try {
            listOfPersons = fr.listAllFromCSV("personData.csv");
            FileWriter fileWriter = new FileWriter("sorted-by-id.txt");
            sortById();
            FileWriter fileWriter1= new FileWriter("sorted-by-birth.txt");
            sortByBirth();
            fileWriter.write(Arrays.toString(new List[]{listOfPersons}));
            fileWriter1.write(Arrays.toString(new List[]{listOfPersons}));
            System.out.println("Prvi fajl uspesno upisan!");
            System.out.println("Drugi fajl uspesno upisan!");

            fileWriter.close();
            fileWriter1.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
