/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapper;

import dtos.RankDTO;
import dtos.RoleDTO;
import dtos.UserDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;

/**
 *
 * @author nguyen
 */
public class UserMapper implements RowMapper<UserDTO> {

    static Logger logger = Logger.getLogger(Logger.class.getName());

    @Override
    public UserDTO mapRow(ResultSet rs) {
        try {
            UserDTO user = new UserDTO();
            user.setUsername(rs.getString("username"));
            user.setFullName(rs.getString("fullname"));
            try {
                
                //role
                RoleDTO role = new RoleDTO();
                role.setId(rs.getLong("roleid"));
                role.setName(rs.getString("roname"));
                user.setRole(role);
                

                user.setRankId(rs.getLong("rankid"));
                user.setId(rs.getLong("id"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setPhoto(rs.getString("photo"));
                user.setStatus(rs.getBoolean("status"));
                user.setPassword(rs.getString("password"));
                                //rank
                RankDTO rank = new RankDTO();
                rank.setId(rs.getLong("rankid"));
                rank.setName(rs.getString("raname"));
                user.setRank(rank);

            } catch (Exception e) {
                logger.error("UserMapper_Exception " + e.getMessage());
//                e.printStackTrace();
            }
            return user;
        } catch (SQLException e) {
            logger.error("UserMapper_Exception " + e.getMessage());
                e.printStackTrace();

            return null;
        }
    }

}
