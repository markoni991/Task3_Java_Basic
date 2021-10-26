package com.pluralsight;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVFileReader {

    public Person createPerson(String [] data){

        int id = Integer.parseInt(data[0]);
        String name = data[1];
        String birth = data[2];

        return new Person(id, name, birth);
    }

    public List<Person> listAllFromCSV(String filename){

        List<Person> persons = new ArrayList<>();

        File fajl = new File(filename);
        try {
            BufferedReader bf = new BufferedReader(new FileReader(fajl));
            String line = bf.readLine();
            while(line != null){
                String [] values = line.split("; ");

                Person person = createPerson(values);
                persons.add(person);

                line = bf.readLine();

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return persons;
    }

}
