/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import dtos.UserDTO;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.SessionUtil;

/**
 *
 * @author nguyen
 */
public class AuthorizationFilter implements Filter {

    private ServletContext context;

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getRequestURI();
        if (url.startsWith("/admin")) {
            UserDTO user = (UserDTO) SessionUtil.getInstance().getValue(request, "USERMODEL");
            if (user != null) {
                if (user.getRole().getName().equals("admin")) {
                    chain.doFilter(servletRequest, servletResponse);

                } else if (user.getRole().getName().equals("user")) {
                    response.sendRedirect(request.getContextPath() + "/login?action=login&message=notpermission&alert=danger");

                }
            } else {
                response.sendRedirect(request.getContextPath() + "/login?action=login&message=pleaselogin&alert=danger");
            }
        } else {
            chain.doFilter(servletRequest, servletResponse);
        }

    }

    /**
     * Return the filter configuration object for this filter.
     */
    public void destroy() {
    }

    /**
     * Init method for this filter
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
    }

}
