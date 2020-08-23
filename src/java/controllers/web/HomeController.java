/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.web;

import dtos.HistoryDTO;
import dtos.RankDTO;
import dtos.UserDTO;
import java.io.IOException;
import java.util.Optional;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.IHistoryService;
import services.IRankService;
import services.IUserService;
import utils.SessionUtil;

/**
 * home
 *
 * @author nguyen
 */
@WebServlet(urlPatterns = {"/home"})
public class HomeController extends HttpServlet {

    @Inject
    private IUserService userService;

    @Inject
    private IHistoryService historyService;
    
    @Inject
    private IRankService rankService;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Optional<UserDTO> test = Optional.ofNullable((UserDTO) SessionUtil.getInstance().getValue(request, "USERMODEL"));
        if (test.isPresent() && (test.get().getRole().getId() == Long.valueOf(2 + ""))) {
            UserDTO userDetail = this.userService.findUserByIdAndStatus(test.get().getId(), true);
            HistoryDTO history = new HistoryDTO();
            history.setListResult(this.historyService.findHistoryByUserId(test.get().getId()));
            System.out.println("history: " + history.getListResult().get(0).getDate());
            RankDTO rank = this.rankService.findRankById(userDetail.getRankId());
            request.setAttribute("RANK", rank);
            request.setAttribute("HISTORY", history);
            request.setAttribute("USERDETAIL", userDetail);
        }

        RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
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
