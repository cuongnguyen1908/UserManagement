/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos.impl;

import daos.IHistoryDAO;
import dtos.HistoryDTO;
import java.sql.Timestamp;
import java.util.List;
import mapper.HistoryMapper;

/**
 *
 * @author nguyen
 */
public class HistoryDAO extends AbstractDAO<HistoryDTO> implements IHistoryDAO{

    @Override
    public Long saveHistory(Long id, String date, String action) {
        String sql = "INSERT INTO history(userid, date, action) values(?, ?, ?)";
        return insert(sql, id, date, action);
    }

    @Override
    public List<HistoryDTO> findHistoryByUserId(Long id) {
        String sql = "SELECT date, action "
                + "FROM history "
                + "WHERE userid = ? "
                + "ORDER BY date DESC";
        List<HistoryDTO> history = query(sql, new HistoryMapper(), id);
        return history;
    }

}
