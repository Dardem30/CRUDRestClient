package by.service;

import by.DAO.RoleDAO;
import by.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Роман on 03.09.2017.
 */
@Service
@Transactional
public class RoleService {
    @Autowired
    private RoleDAO roleDAO;
    public Role getRoleById(int id){
        return roleDAO.getRoleById(id);
    }
}
