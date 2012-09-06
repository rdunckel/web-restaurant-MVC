/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.distributedjava.restaurant.model;

import java.util.List;

/**
 *
 * @author Tivoli
 */
public class MenuService {

    private List<String> entrees;
    private List<String> beverages;
    private List<String> desserts;
    private MenuDao menuDao;

    public MenuService() {
        menuDao = new MenuDao();
    }

    public List<String> getEntrees() {
        return menuDao.obtainEntrees();
    }

    public List<String> getBeverages() {
        return menuDao.obtainBeverages();
    }

    public List<String> getDesserts() {
        return menuDao.obtainDesserts();
    }
}
