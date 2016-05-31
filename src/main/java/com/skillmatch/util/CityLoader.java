package com.skillmatch.util;

/**
 * Created by agermenos on 5/22/16.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Loads the city, state, country values
 * from the Adwords database (https://goo.gl/d3O4W7)
 * And stores them in the catalog table, as city, country and state...
 * Countries -> Country
 * Country -> States
 * States -> Cities
 * Each line in the csv file follows the order:
 * Criteria ID,Name,Canonical Name,Parent ID,Country Code,Target Type,Status
 * 1000010,Abu Dhabi,"Abu Dhabi,Abu Dhabi,United Arab Emirates",9041082,AE,City,Active
 * We'll take the canonical data, taking only the Active values.
 */


public class CityLoader {

    Map<String, Map> countries = new HashMap();
    Map<String, List> states = new HashMap();
    List<String> cities=new ArrayList();

    public void readFile(String file){
        String str = "";
        try (BufferedReader bufReader = new BufferedReader(new FileReader(new File(file)),1024)) {
            while ( (str = bufReader.readLine() ) != null ) {
                String lineArray[] = str.split(",");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
