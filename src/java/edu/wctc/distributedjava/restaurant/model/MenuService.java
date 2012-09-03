/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.distributedjava.restaurant.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tivoli
 */
public class MenuService {

    private List<String> entrees;
    private List<String> beverages;
    private List<String> desserts;

    public MenuService() {
        entrees = new ArrayList<String>();
        entrees.add("Steak");
        entrees.add("Lobster");
        entrees.add("Chicken");

        beverages = new ArrayList<String>();
        beverages.add("Water");
        beverages.add("Martini");
        beverages.add("Wine");

        desserts = new ArrayList<String>();
        desserts.add("Creme Brulee");
        desserts.add("Chocolate Cake");
        desserts.add("Bananas Foster");
    }

    public List<String> getEntrees() {
        return entrees;

    }

    /**
     * @param entrees the entrees to set
     */
    public void setEntrees(List<String> entrees) {
        this.entrees = entrees;
    }

    /**
     * @return the beverages
     */
    public List<String> getBeverages() {
        return beverages;
    }

    /**
     * @param beverages the beverages to set
     */
    public void setBeverages(List<String> beverages) {
        this.beverages = beverages;
    }

    /**
     * @return the desserts
     */
    public List<String> getDesserts() {
        return desserts;
    }

    /**
     * @param desserts the desserts to set
     */
    public void setDesserts(List<String> desserts) {
        this.desserts = desserts;
    }
}
