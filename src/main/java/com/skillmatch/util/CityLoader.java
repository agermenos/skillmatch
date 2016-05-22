package com.skillmatch.util;

/**
 * Created by agermenos on 5/22/16.
 */

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
}
