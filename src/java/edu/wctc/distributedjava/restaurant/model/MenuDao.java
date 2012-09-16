/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.distributedjava.restaurant.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rdunckel
 */
public class MenuDao {

    private Connection conn;
    private static final String URL = "jdbc:mysql://localhost:3306/wctc_distributed_java";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "admin";
    private static final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";

    public static void main(String[] args) {

        MenuDao menu = new MenuDao();
        List<List<MenuItem>> lists = new ArrayList<List<MenuItem>>();

        List<MenuItem> entrees = menu.getBeverages();
        lists.add(entrees);
        
        List<MenuItem> sides = menu.getSides();
        lists.add(sides);

        List<MenuItem> beverages = menu.getBeverages();
        lists.add(beverages);

        List<MenuItem> desserts = menu.getDesserts();
        lists.add(desserts);

        for (List<MenuItem> list : lists) {
            for (MenuItem item : list) {
                System.out.println(item.getName());
            }
        }
    }

    public List<MenuItem> getEntrees() {

        String dbTable = "entree";
        List<MenuItem> entrees = getMenuItems(dbTable);

        return entrees;
    }
    
    public List<MenuItem> getSides() {

        String dbTable = "side";
        List<MenuItem> entrees = getMenuItems(dbTable);

        return entrees;
    }

    public List<MenuItem> getBeverages() {

        String dbTable = "beverage";
        List<MenuItem> beverages = getMenuItems(dbTable);

        return beverages;
    }

    public List<MenuItem> getDesserts() {

        String dbTable = "dessert";
        List<MenuItem> desserts = getMenuItems(dbTable);

        return desserts;
    }

    private List<MenuItem> getMenuItems(String dbTable) {

        List<MenuItem> items = new ArrayList<MenuItem>();
        MenuItem item = null;

        try {
            Class.forName(DRIVER_CLASS_NAME);
            conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MenuDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MenuDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        Statement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM " + dbTable;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(MenuDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        int count = 0;

        try {
            while (rs.next()) {
                item = new MenuItem();
                item.setName(rs.getString(2));
                items.add(item);
                count++;
            }
            if (count == 0) {
                Logger.getLogger(MenuDao.class.getName()).log(Level.WARNING, count + " records retrieved from the " + dbTable + " table");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MenuDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(MenuDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return items;
    }
}
