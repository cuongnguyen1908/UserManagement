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

            user.setFullName(rs.getString("fullname"));

            try {
                user.setUsername(rs.getString("username"));
            } catch (NullPointerException | SQLException e) {
                logger.warn("UserMapper_Exception " + e.getMessage());
            }

            try {
                user.setPassword(rs.getString("password"));

            } catch (NullPointerException | SQLException e) {
                logger.warn("UserMapper_Exception " + e.getMessage());
            }
            try {
                user.setEmail(rs.getString("email"));
            } catch (NullPointerException | SQLException e) {
                logger.warn("UserMapper_Exception " + e.getMessage());
            }

            try {
                user.setPhone(rs.getString("phone"));
            } catch (NullPointerException | SQLException e) {
                logger.warn("UserMapper_Exception " + e.getMessage());
            }

            try {
                user.setPhoto(rs.getString("photo"));
            } catch (NullPointerException | SQLException e) {
                logger.warn("UserMapper_Exception " + e.getMessage());
            }

            try {
                user.setStatus(rs.getBoolean("status"));
            } catch (NullPointerException | SQLException e) {
                logger.error("UserMapper_Exception " + e.getMessage());

            }

            try {
                user.setId(rs.getLong("id"));
            } catch (NullPointerException | SQLException e) {
                logger.warn("UserMapper_Exception " + e.getMessage());
            }

            try {
                //role
                RoleDTO role = new RoleDTO();
                role.setId(rs.getLong("roleid"));
                role.setName(rs.getString("roname"));
                user.setRole(role);
            } catch (NullPointerException | SQLException e) {
                logger.warn("UserMapper_Exception " + e.getMessage());
            }

            RankDTO rank = new RankDTO();
            try {
                //rank
                rank.setId(rs.getLong("rankid"));
                user.setRank(rank);
                user.setRankId(rs.getLong("rankid"));
            } catch (NullPointerException | SQLException e) {
                logger.warn("UserMapper_Exception " + e.getMessage());
            }
            try {
                rank.setName(rs.getString("raname"));
                user.setRank(rank);
                user.setRankId(rs.getLong("rankid"));
            } catch (NullPointerException | SQLException e) {
                logger.warn("UserMapper_Exception " + e.getMessage());
            }
            return user;
        } catch (SQLException e) {
            logger.warn("UserMapper_Exception " + e.getMessage());
            return null;
        }
    }

}
