/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import daos.IUserDAO;
import dtos.UserDTO;
import javax.inject.Inject;
import services.IUserService;

/**
 *
 * @author nguyen
 */
public class UserService implements IUserService{
    
    @Inject
    private IUserDAO userDAO;
    

    @Override
    public UserDTO findByUserNameAndPasswordAndStatus(String username, String password, boolean status) {
        return userDAO.finByUserNameAndPasswordAndStatus(username, password, true);
    }
    
    
}
