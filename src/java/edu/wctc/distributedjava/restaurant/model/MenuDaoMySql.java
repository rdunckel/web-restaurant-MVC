/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.distributedjava.restaurant.model;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rdunckel
 */
public class MenuDaoMySql implements MenuDao {

    private Connection conn;
    private static final Logger logger = Logger.getLogger(MenuDaoMySql.class.getName());

    public static void main(String[] args) {

        MenuDaoMySql menu = new MenuDaoMySql();
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
                System.out.println(item.getPrice());
                System.out.println(item.getDescription());
            }
        }
    }

    @Override
    public List<MenuItem> getEntrees() {

        String dbTable = "entree";
        List<MenuItem> entrees = getMenuItems(dbTable);

        return entrees;
    }

    @Override
    public List<MenuItem> getSides() {

        String dbTable = "side";
        List<MenuItem> entrees = getMenuItems(dbTable);

        return entrees;
    }

    @Override
    public List<MenuItem> getBeverages() {

        String dbTable = "beverage";
        List<MenuItem> beverages = getMenuItems(dbTable);

        return beverages;
    }

    @Override
    public List<MenuItem> getDesserts() {

        String dbTable = "dessert";
        List<MenuItem> desserts = getMenuItems(dbTable);

        return desserts;
    }

    private List<MenuItem> getMenuItems(String dbTable) {

        List<MenuItem> items = new ArrayList<MenuItem>();
        MenuItem item = null;

        Properties dbProps = getDbProps();

        String driverClassName = dbProps.getProperty("DRIVER_CLASS_NAME");
        String url = dbProps.getProperty("URL");
        String userName = dbProps.getProperty("USER_NAME");
        String password = dbProps.getProperty("PASSWORD");

        try {
            Class.forName(driverClassName);
            conn = DriverManager.getConnection(url, userName, password);
        } catch (ClassNotFoundException ex) {
            logger.log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
        }

        if (conn == null) {
            return null;
        }

        String sql = "SELECT * FROM " + dbTable;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;

        int count = 0;

        try {
            prepStmt = conn.prepareStatement(sql);

            rs = prepStmt.executeQuery();
            while (rs.next()) {
                item = new MenuItem();
                item.setName(rs.getString(2));
                item.setPrice(rs.getDouble(3));
                item.setDescription(rs.getString(4));
                items.add(item);
                count++;
            }
            if (count == 0) {
                logger.log(Level.WARNING, count + " records retrieved from the " + dbTable + " table");
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
        } finally {
            try {
                prepStmt.close();
                conn.close();
            } catch (SQLException ex) {
                logger.log(Level.SEVERE, null, ex);
            }
        }

        return items;
    }

    private Properties getDbProps() {

        InputStream inStream = null;
        Properties dbProps = new Properties();
        try {
            inStream = MenuDaoMySql.class.getResourceAsStream("db.properties");
            dbProps.load(inStream);
        } catch (IOException ex) {
            logger.log(Level.SEVERE, null, ex);
        } finally {
            try {
                inStream.close();
            } catch (IOException ex) {
                logger.log(Level.SEVERE, null, ex);
            }
        }

        return dbProps;
    }

    @Override
    public double getItemPrice(String itemName) {
        double price = 0.0;

        Properties dbProps = getDbProps();

        String driverClassName = dbProps.getProperty("DRIVER_CLASS_NAME");
        String url = dbProps.getProperty("URL");
        String userName = dbProps.getProperty("USER_NAME");
        String password = dbProps.getProperty("PASSWORD");

        try {
            Class.forName(driverClassName);
            conn = DriverManager.getConnection(url, userName, password);
        } catch (ClassNotFoundException ex) {
            logger.log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
        }

        if (conn == null) {
            logger.log(Level.SEVERE, "Error establishing connection.");
            return 0.0;
        }

        String dbTable = "entree";
        String sql = "SELECT price FROM " + dbTable + " WHERE name = ?";

        PreparedStatement prepStmt = null;
        ResultSet rs = null;

        int count = 0;

        try {
            prepStmt = conn.prepareStatement(sql);
            prepStmt.setString(1, itemName);

            rs = prepStmt.executeQuery();

            while (rs.next()) {
                price = rs.getDouble(1);
                count++;
            }
            if (count == 0) {
                logger.log(Level.WARNING, count + " records retrieved from the " + dbTable + " table");
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
        } finally {
            try {
                prepStmt.close();
                conn.close();
            } catch (SQLException ex) {
                logger.log(Level.SEVERE, null, ex);
            }
        }

        return price;
    }
}
