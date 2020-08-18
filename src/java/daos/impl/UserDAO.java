/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos.impl;

import daos.IUserDAO;
import dtos.UserDTO;
import java.util.List;
import mapper.UserMapper;

/**
 *
 * @author nguyen
 */
public class UserDAO extends AbstractDAO<UserDTO> implements IUserDAO{

    @Override
    public UserDTO finByUserNameAndPasswordAndStatus(String username, String password, boolean status) {
        String sql = "SELECT username, password, fullname, status, roleid, name "
                + "FROM [user] as u INNER JOIN role as r on r.id = u.roleid "
                + "WHERE username = ? AND password = ? AND status = ?";
                    System.out.println("worked in find");

            List<UserDTO> user = query(sql, new UserMapper(), username, password, status);
            System.out.println(user.size());
            return user.isEmpty() ? null : user.get(0);
    }
    
}
