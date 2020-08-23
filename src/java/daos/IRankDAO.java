/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.RankDTO;
import java.util.List;

/**
 *
 * @author nguyen
 */
public interface IRankDAO {
    List<RankDTO> findAll();
    
        RankDTO findRankById(Long id);

}
