/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.UserDTO;

/**
 *
 * @author nguyen
 */
public interface IUserDAO {
    UserDTO finByUserNameAndPasswordAndStatus(String username, String password, boolean status);
}
