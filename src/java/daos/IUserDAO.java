/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.UserDTO;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author nguyen
 */
public interface IUserDAO {
    UserDTO findByUserNameAndPasswordAndStatus(String username, String password, boolean status);
    
    List<UserDTO> findAll(boolean status);
    
    List<UserDTO> findAllByFullNameAndRoleAndStatus(String textSearch, Long roleId, boolean status);
    
        List<UserDTO> findAllByFullNameAndStatus(String textSearch, boolean status);

        void delete(Long id, boolean status);
        
        UserDTO findUserByIdAndStatus(Long id, boolean status);
    
    Long save(UserDTO userDTO);
    
    void update(UserDTO userDTO);

    public boolean existUserByUserName(String username);
    
    

}
