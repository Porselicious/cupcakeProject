/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fen
 */
@WebServlet(name = "LoginOrNewUserServlet", urlPatterns = {"/LoginOrNewUserServlet"})
public class LoginOrNewUserServlet extends HttpServlet {

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
        if (request.getSession(false) == null) {
            notLoggedInHTML(response);
        } else {
            alreadyLoggedInHTML(response, request);
        }
        
    }

    private void notLoggedInHTML(HttpServletResponse response) throws IOException {
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginOrNewUserServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>LoginOrNewUserServlet</h1>");
            //out.println("<form action = \"Validate\" method = \"POST\">");
            out.println("username: <input type = \"text\" name='username'>");
            out.println("<br />");
            out.println("password: <input type = \"text\"  name='password' />");
            out.println("<br />");
            out.println("email: <input type = \"text\"  name='email' />");
            out.println("<input type = \"submit\" value = \"Login\" " //test
                    + " form action = \"Validate\" method = \"POST\">");
            out.println("<input type = \"submit\" value = \"Create user\"" //test
                    + " form action = \"SubmitUser\" method = \"POST\" >");
            out.println("</form>");
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    private void alreadyLoggedInHTML(HttpServletResponse response, HttpServletRequest request) throws IOException {
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>LoginOrNewUserServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>You are already logged in " + request.getSession(false).getAttribute("user") + "</h1>");
            
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
