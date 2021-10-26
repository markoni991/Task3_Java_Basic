package com.pluralsight;

import java.util.Arrays;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class Main {

    private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void init(){
        FileHandler fh;
        try{
            fh = new FileHandler("C:/Users/milic/files/JAVA3_fundamentals.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            logger.info("Logger initialized!");

        }catch (Exception e){
            logger.log(Level.WARNING, "Exception: " , e);
        }

    }

    public static void main(String[] args) {

        CSVFileReader fr = new CSVFileReader();
        Sorter sorter = new Sorter();
        List<Person> listOfPersons = fr.listAllFromCSV("personData.csv");
        ResultFileSaver resultFileSaver = new ResultFileSaver();

        System.out.println("Lista osoba CSV fajla: ");
        System.out.println(Arrays.asList(listOfPersons));
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("Sortiranje liste po ID broju: ");
        sorter.sortById();
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("Sortiranje liste po datumu rodjenja: ");
        sorter.sortByBirth();
        resultFileSaver.writeFile();


        logger.info("End of program...");



    }


}
