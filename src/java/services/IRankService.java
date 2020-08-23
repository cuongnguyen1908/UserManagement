/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dtos.RankDTO;
import java.util.List;

/**
 *
 * @author nguyen
 */
public interface IRankService {
    List<RankDTO> findAll();
    
    RankDTO findRankById(Long id);
}
