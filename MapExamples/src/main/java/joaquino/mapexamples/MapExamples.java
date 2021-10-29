/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joaquino.mapexamples;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author joaqu
 */
public class MapExamples {
    public static void main(String[] args){
        Map<String, Integer> populations = new HashMap<>();
        //adding objects in the map using a key and the value associated with it
        //String, Integer type
        populations.put("USA", 200000000);
        populations.put("Canada", 34000000);
        populations.put("United Kingdom", 12700000);
        populations.put("Japan", 12700000);
        //printing out the map size
        System.out.println("Map size is: " + populations.size());
        //printing out a particular key
        //Integer usaPopulation = populations.get("USA");
        //System.out.println(usaPopulation);
        //changing the value of a key
        //populations.put("USA", 313000000);
        //usaPopulation = populations.get("USA");
        //System.out.println(usaPopulation);
        //getting all the keys
        //assume that the user doesn't know the key names
        //therefore they won't know how to search for the values of keys
        Set<String> keys = populations.keySet();
        
        for(String currentKey : keys){
            Integer currentPopulation = populations.get(currentKey);
            System.out.println("The population of " + currentKey + " is " + currentPopulation);
            
        }
       
       //sometimes, keys have the same values as other keys. Collections would
       //be used for that instead of Set
       
      /* Collection<Integer> populationValues = populations.values();
       
       for(Integer currentPopulation : populationValues){
           System.out.println(currentPopulation);
           
       }*/
    }
    
}
