package com.example.citylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if that city does not exist
     * @param city
     *      This is the city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     *      Return the sorted list of cities
     */
    public List<City> getCities(String option) {

        List<City> cityList = cities;
        if(option.equalsIgnoreCase("sortByCities")) {
            Collections.sort(cityList);
        }
        else
        {
            Collections.sort(cityList, new Comparator<City>() {
                @Override
                public int compare(City city, City t1) {
                    return city.getProvinceName().compareTo(t1.getProvinceName()) ;
                }
            });
        }
        return cityList;
    }

    /**
     * Deletes city from cities(Citylist)
     * @param city
     * throws exceptions if city not in cities
     */

    public void delete(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException("City doesn't exists");
        }
        else
        {
            cities.remove(city);
        }
    }

    /**
     * This returns number of cities i.e size of cities(CityList)
     * @return
     * Retutns size of cities
     */

    public int count() {
       return cities.size();
    }


}
