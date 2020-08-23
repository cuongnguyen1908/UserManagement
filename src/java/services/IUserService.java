/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dtos.UserDTO;
import java.util.List;

/**
 *
 * @author nguyen
 */
public interface IUserService {
    UserDTO findByUserNameAndPasswordAndStatus(String username, String password, boolean status);
    
    List<UserDTO> findAll(boolean status);
    
    List<UserDTO> findAllByFullNameAndStatus(String textSearch, boolean status);

    List<UserDTO> findAllByFullNameAndRoleAndStatus(String textSearch, Long roleId, boolean status);
    
    boolean delete(Long id, boolean status);
    
    UserDTO findUserByIdAndStatus(Long id, boolean status);
    
    Long save(UserDTO userDTO);
    
    boolean update(UserDTO userDTO);
    
    boolean existUserByUsername(String username);
    
    boolean updateRankById(Long id, Long rankId);
    
    List<UserDTO> findAllUserPromotion(boolean status);
    
    boolean deleleRankById(Long id, Long rankId);
    
    
    
}
