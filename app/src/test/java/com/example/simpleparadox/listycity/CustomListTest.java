package com.example.simpleparadox.listycity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;

    @BeforeEach
    public void createList() {
        list = new CustomList(null, new ArrayList<City>());
    }

    @Test
    public void addCityTest() {
        int listSize = list.getCount();
        list.addCity(new City("Edmonton", "Alberta"));
        assertEquals(listSize+1, list.getCount());
    }

    @Test
    public void hasCityTest() {
        City mockCity = new City("Edmonton", "Alberta");
        assertEquals(false, list.hasCity(mockCity));
        list.addCity(mockCity);
        assertEquals(true, list.hasCity(mockCity));
    }

    @Test
    public void deleteCityTest() {
        City mockCity = new City("Edmonton", "Alberta");
        list.addCity(mockCity);
        list.deleteCity(mockCity);
        assertEquals(false, list.hasCity(mockCity));
        assertThrows(IllegalArgumentException.class, () -> {
            list.deleteCity((new City("Toronto", "Ontario")));
        });
    }
}
