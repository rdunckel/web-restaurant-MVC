/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.distributedjava.restaurant.model;

/**
 *
 * @author Tivoli
 */
public class MenuItem {

    private String name;
    private Double price;
    private String description;

    /**
     * @return the itemName
     */
    public String getName() {
        return name;
    }

    /**
     * @param itemName the itemName to set
     */
    public void setName(String itemName) {
        this.name = itemName;
    }

    /**
     * @return the price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
