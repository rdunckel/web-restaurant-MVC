/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.distributedjava.restaurant.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.enterprise.inject.Alternative;

/**
 *
 * @author rdunckel
 */
@Alternative
public class MenuDaoMock implements MenuDao {

    @Override
    public List<MenuItem> getEntrees() {

        List<String> tempNames = new ArrayList<String>();
        tempNames.add("Steak");
        tempNames.add("Lobster");
        tempNames.add("Chicken");

        List<Double> tempPrices = new ArrayList<Double>();
        tempPrices.add(11.26);
        tempPrices.add(24.56);
        tempPrices.add(12.56);

        List<MenuItem> entrees = buildList(tempNames, tempPrices);

        return entrees;
    }

    @Override
    public List<MenuItem> getSides() {

        List<String> tempNames = new ArrayList<String>();
        tempNames.add("Mashed Potatoes");
        tempNames.add("Asparagus");
        tempNames.add("Steamed Brocolli");

        List<Double> tempPrices = new ArrayList<Double>();
        tempPrices.add(16.26);
        tempPrices.add(21.46);
        tempPrices.add(18.45);

        List<MenuItem> sides = buildList(tempNames, tempPrices);

        return sides;
    }

    @Override
    public List<MenuItem> getBeverages() {

        List<String> tempNames = new ArrayList<String>();
        tempNames.add("Water");
        tempNames.add("Martini");
        tempNames.add("Wine");

        List<Double> tempPrices = new ArrayList<Double>();
        tempPrices.add(8.46);
        tempPrices.add(16.36);
        tempPrices.add(19.42);

        List<MenuItem> beverages = buildList(tempNames, tempPrices);

        return beverages;
    }

    @Override
    public List<MenuItem> getDesserts() {

        List<String> tempNames = new ArrayList<String>();
        tempNames.add("Creme Brulee");
        tempNames.add("Chocolate Cake");
        tempNames.add("Bananas Foster");

        List<Double> tempPrices = new ArrayList<Double>();
        tempPrices.add(16.32);
        tempPrices.add(8.65);
        tempPrices.add(12.82);

        List<MenuItem> desserts = buildList(tempNames, tempPrices);

        return desserts;
    }

    private List<MenuItem> buildList(List<String> itemNames, List<Double> itemPrices) {

        List<MenuItem> items = new ArrayList<MenuItem>();

        for (int i = 0; i < itemNames.size(); i++) {
            MenuItem item = new MenuItem();
            item.setName(itemNames.get(i));
            item.setPrice(itemPrices.get(i));
            items.add(item);
        }

        return items;

    }

    @Override
    public double getItemPrice(String itemName) {
        Random generator = new Random();

        return generator.nextDouble() * 50;
    }
}
