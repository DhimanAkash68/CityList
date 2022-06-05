package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities("sortByCities").size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities("sortByCities").size());
        assertTrue(cityList.getCities("sortByCities").contains(city));
    }

    @Test
    public void testDelete() {
        CityList cityList = new CityList();


        City city1 = new City("Magura", "Khulna");
        City city2 = new City("Jhenidah", "Khulna");
        cityList.add(city1);
        cityList.add(city2);
        cityList.delete(city1);
        assertTrue(!cityList.getCities("sortByCities").contains(city1));


    }




    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    public void testDeleteException() {
        CityList cityList = new CityList();


        City city1 = new City("Magura", "Khulna");
        City city2 = new City("Jhenidah", "Khulna");
        cityList.add(city1);
        cityList.add(city2);

        cityList.delete(city1);
        assertEquals(1,cityList.count());
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city1);
        });
    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities("sortByCities").get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities("sortByCities").get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities("sortByCities").get(1)));
    }

    @Test
    public void testSort() {
        CityList cityList =new CityList();
              City city1  = new City("Edmonton", "ABCD");
        cityList.add(city1);
        assertEquals(0,city1.compareTo(cityList.getCities("sortByCities").get(0)));

        City city2 = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city2);

        assertEquals(0, city2.compareTo(cityList.getCities("sortByCities").get(0)));
        assertEquals(0, city1.compareTo(cityList.getCities("sortByProvinces").get(0)));
    }


}
