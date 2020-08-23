/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dtos.HistoryDTO;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author nguyen
 */
public interface IHistoryService {
        Long saveHistory(Long id, String date, String action);
        
        List<HistoryDTO> findHistoryByUserId(Long id);

}
