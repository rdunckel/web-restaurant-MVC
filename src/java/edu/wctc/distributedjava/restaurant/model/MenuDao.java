/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.distributedjava.restaurant.model;

import java.util.List;

/**
 *
 * @author rdunckel
 */
public interface MenuDao {

    List<MenuItem> getBeverages();

    List<MenuItem> getDesserts();

    List<MenuItem> getEntrees();

    List<MenuItem> getSides();
    
}
