/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import daos.IRankDAO;
import dtos.RankDTO;
import java.util.List;
import javax.inject.Inject;
import services.IRankService;

/**
 *
 * @author nguyen
 */
public class RankService implements IRankService{

    @Inject
    private IRankDAO rankDAO;
    
    @Override
    public List<RankDTO> findAll() {
        return this.rankDAO.findAll();
    }

    @Override
    public RankDTO findRankById(Long id) {
        return this.rankDAO.findRankById(id);
    }
    
}
