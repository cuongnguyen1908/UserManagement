/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.web;

import dtos.UserDTO;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.IUserService;
import utils.HashFunctions;
import utils.SessionUtil;

/**
 *
 * @author nguyen
 */
@WebServlet(urlPatterns = {"/login", "/logout"})
public class AuthenticationController extends HttpServlet {

    @Inject
    private IUserService userService;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("login")) {
            String alert = request.getParameter("alert");
            String message = request.getParameter("message");
            if (message != null && alert != null) {
                request.setAttribute("message", message);
                request.setAttribute("alert", alert);
            }
            RequestDispatcher rd = request.getRequestDispatcher("/views/login.jsp");
            rd.forward(request, response);
        } else if (action != null && action.equals("logout")) {
            SessionUtil.getInstance().removeValue(request, "USERMODEL");
            response.sendRedirect(request.getContextPath() + "/home");

        } else {
            RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
            rd.forward(request, response);
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
        String action = request.getParameter("action");
        if (action != null && action.equals("login")) {
            UserDTO model = new UserDTO();
            model.setUsername(request.getParameter("username"));
            String password = request.getParameter("password");
            String passHash = HashFunctions.getHash(password.trim().getBytes(), "SHA-256");
            model.setPassword(passHash);
            model = userService.findByUserNameAndPasswordAndStatus(model.getUsername(), model.getPassword(), true);

            if (model != null) {
                SessionUtil.getInstance().putValue(request, "USERMODEL", model);
                if (model.getRole().getName().equals("user")) {
                    response.sendRedirect(request.getContextPath() + "home");
                } else if (model.getRole().getName().equals("admin")) {
                    response.sendRedirect(request.getContextPath() + "admin-home");

                }
            } else {
                response.sendRedirect(request.getContextPath() + "/login?action=login&message=usernamepasswordinvalid&alert=danger");
            }

        }

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
