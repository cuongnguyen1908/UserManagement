/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos.impl;

import daos.IRankDAO;
import dtos.RankDTO;
import java.util.List;
import mapper.RankMapper;

/**
 *
 * @author nguyen
 */
public class RankDAO extends AbstractDAO<RankDTO> implements IRankDAO{

    @Override
    public List<RankDTO> findAll() {
        String sql = "SELECT id, name FROM rank";
        List<RankDTO> result = query(sql, new RankMapper());
        return result;
    }

    @Override
    public RankDTO findRankById(Long id) {
        String sql = "SELECT name FROM rank WHERE id = ?";
        List<RankDTO> rank = query(sql, new RankMapper(), id);
        return rank.isEmpty() ? null : rank.get(0);
        
    }
    
    
}
