/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import daos.IHistoryDAO;
import dtos.HistoryDTO;
import java.util.List;
import javax.inject.Inject;
import services.IHistoryService;

/**
 *
 * @author nguyen
 */
public class HistoryService implements IHistoryService{

    @Inject
    private IHistoryDAO historyDAO;
    
    @Override
    public Long saveHistory(Long id, String date, String action) {
        return this.historyDAO.saveHistory(id, date, action);
    }

    @Override
    public List<HistoryDTO> findHistoryByUserId(Long id) {
        return this.historyDAO.findHistoryByUserId(id);
    }
    
}
