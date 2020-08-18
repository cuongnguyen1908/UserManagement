/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapper;

import dtos.RoleDTO;
import dtos.UserDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author nguyen
 */
public class UserMapper implements RowMapper<UserDTO> {
    
    @Override
    public UserDTO mapRow(ResultSet rs) {
        try {
            UserDTO user = new UserDTO();
            
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setFullName(rs.getString("fullname"));
            user.setStatus(rs.getBoolean("status"));
            try {
                RoleDTO role = new RoleDTO();
                role.setName(rs.getString("name"));
                user.setRole(role);
            } catch (Exception e) {
                System.out.print(e.getMessage());
            }            
            return user;
        } catch (SQLException e) {
            return null;
        }
    }
    
}
