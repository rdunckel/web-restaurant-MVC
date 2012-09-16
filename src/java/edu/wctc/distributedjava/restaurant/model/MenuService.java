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

    private MenuDao menuDao;

    public MenuService() {
        menuDao = new MenuDao();
    }

    public List<MenuItem> getEntrees() {       
        return menuDao.getEntrees();
    }
    
    public List<MenuItem> getSides() {       
        return menuDao.getSides();
    }

    public List<MenuItem> getBeverages() {
        return menuDao.getBeverages();
    }

    public List<MenuItem> getDesserts() {
        return menuDao.getDesserts();
    }
}
