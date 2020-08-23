/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapper;

import dtos.HistoryDTO;
import java.sql.ResultSet;
import org.apache.log4j.Logger;

/**
 *
 * @author nguyen
 */
public class HistoryMapper implements RowMapper<HistoryDTO>{
    static Logger logger = Logger.getLogger(Logger.class.getName());

    @Override
    public HistoryDTO mapRow(ResultSet rs) {
        try {
            HistoryDTO history = new HistoryDTO();
            history.setDate(rs.getTimestamp("date"));
            history.setAction(rs.getString("action"));
            return history;
        } catch (Exception e) {
            logger.error("HistoryMapper_Exception " + e.getMessage());
            return null;
        }
    }
}
