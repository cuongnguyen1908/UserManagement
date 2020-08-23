/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.HistoryDTO;
import java.util.List;

/**
 *
 * @author nguyen
 */
public interface IHistoryDAO {

    Long saveHistory(Long id, String date, String action);

    List<HistoryDTO> findHistoryByUserId(Long id);

}
