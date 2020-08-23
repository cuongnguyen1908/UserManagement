/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.IHistoryService;
import services.IUserService;

/**
 *
 * @author nguyen
 */
@WebServlet(urlPatterns = {"/admin-delete-promotion"})
public class DeletePromotionController extends HttpServlet {

    @Inject
    private IHistoryService historyService;
    
    @Inject
    private IUserService userService;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("id");
        String rankId = request.getParameter("rankId");
        System.out.println("id in delete: " + id);
        System.out.println("rankid in delete: " + rankId);
        boolean check = this.userService.deleleRankById(Long.valueOf(id), null);
        Timestamp date = new Timestamp(System.currentTimeMillis());
        Long checkHistory = this.historyService.saveHistory(Long.valueOf(id), date.toString(), "Unassign");
        if (check && checkHistory > 0) {
            request.setAttribute("TYPE", "success");
            request.setAttribute("MESSAGE", "Delete success!");
        } else {
            request.setAttribute("TYPE", "danger");
            request.setAttribute("MESSAGE", "Delete fail!");
        }
        
        RequestDispatcher rd = request.getRequestDispatcher("/admin-view-promotion");

        rd.forward(request, response);
        
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
