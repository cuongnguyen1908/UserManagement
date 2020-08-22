/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapper;

import dtos.RankDTO;
import dtos.RoleDTO;
import java.sql.ResultSet;
import org.apache.log4j.Logger;

/**
 *
 * @author nguyen
 */
public class RankMapper implements RowMapper<RankDTO>{

    static Logger logger = Logger.getLogger(Logger.class.getName());

    @Override
    public RankDTO mapRow(ResultSet rs) {
        try {
            RankDTO rank = new RankDTO();
            rank.setId(rs.getLong("id"));
            rank.setName(rs.getString("name"));
            return rank;
        } catch (Exception e) {
            logger.error("RankMapper_Exception " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    
    
}
