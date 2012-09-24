/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.distributedjava.restaurant.controller;

import edu.wctc.distributedjava.restaurant.model.MenuService;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tivoli
 */
public class ConfirmationController extends HttpServlet {

    private static final String CONFIRMATION_PAGE = "confirmation.jsp";
    @Inject
    private MenuService menu;

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String[] entrees = request.getParameterValues("entrees");
        String[] sides = request.getParameterValues("sides");
        String[] beverages = request.getParameterValues("beverages");
        String[] desserts = request.getParameterValues("desserts");
        String name = request.getParameter("name");

        request.setAttribute("entrees", entrees);
        request.setAttribute("sides", sides);
        request.setAttribute("beverages", beverages);
        request.setAttribute("desserts", desserts);
        request.setAttribute("name", name);

        String[] orderItems = combineArrays(entrees, sides, beverages, desserts);
        double orderTotal = calculateOrderTotal(orderItems);
        request.setAttribute("orderTotal", orderTotal);

        RequestDispatcher view = request.getRequestDispatcher(CONFIRMATION_PAGE);
        view.forward(request, response);

    }

    private Double calculateOrderTotal(String[] orderItems) {
        double orderTotal = 0.0;

        if (orderItems != null) {
            for (String item : orderItems) {
                orderTotal += menu.getItemPrice(item);
            }
        }
        return orderTotal;
    }

    public static <T> T[] combineArrays(T[]... rest) {

        int totalLength = 0;
        T[] first = null;
        int firstIndex = 0;

        for (int i = 0; i < rest.length; i++) {
            if (rest[i] != null) {
                if (first == null) {
                    first = Arrays.copyOf(rest[i], rest[i].length);
                    firstIndex = i;
                }
                totalLength += rest[i].length;
            }
        }

        T[] result = null;

        if (first != null) {
            result = Arrays.copyOf(first, totalLength);
        } else {
            return null;
        }

        int offset = first.length;

        rest[firstIndex] = null;

        for (T[] array : rest) {
            if (array != null) {
                System.arraycopy(array, 0, result, offset, array.length);
                offset += array.length;
            }
        }
        return result;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
