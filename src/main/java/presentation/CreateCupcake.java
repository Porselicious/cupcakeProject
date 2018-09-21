/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import data.CupCake;
import data.ShoppingBasket;
import data.UsersDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jonab
 */
@WebServlet(name = "CreateCupcake", urlPatterns = {"/CreateCupcake"})
public class CreateCupcake extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        UsersDAO dao = new UsersDAO();
//        CupCake cupcake = new CupCake();
//        ShoppingBasket sb = new ShoppingBasket();

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreateCupcake</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateCupcake at " + request.getContextPath() + "</h1>");
            out.println("<form action=\"AddToBasket\" method=\"POST\" id=\"bottops[]\">");

            out.println("<select value=\"bottoms\" id=\"bottops\">");
            for (int i = 0; i < dao.getBottoms().size(); i++) {
                out.println("<option value=\"bottom\">" + dao.getBottoms().get(i).getName() + ", " + dao.getBottoms().get(i).getPrice() + " kr" + "</option>");
            }
            out.println("</select>");
            out.println("<select value=\"tops\" id=\"bottops\">");
            for (int i = 0; i < dao.getTops().size(); i++) {
                out.println("<option value=\"top\">" + dao.getTops().get(i).getName() + ", " + dao.getTops().get(i).getPrice() + " kr" + "</option>");
            }

            out.println("</select>");
            out.println("<input type=\"submit\" name=\"submit\" value =\"submit\" />");
            out.println("</form>");

            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
