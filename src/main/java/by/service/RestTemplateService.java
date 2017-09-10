package by.service;

import by.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Роман on 02.09.2017.
 */
@Service
public class RestTemplateService {
    RestTemplate restTemplate=new RestTemplate();
    public List<User> getListUser(){
        List<User> userList=restTemplate.getForObject("http://localhost:8080/restController/users",ArrayList.class);
        return userList;
    }
    public User getUserById(int id){
        User user=restTemplate.getForObject("http://localhost:8080/restController/userById/"+id,User.class);
        return user;
    }
    public User getUserByUsername(String username){
        User user=restTemplate.getForObject("http://localhost:8080/restController/userByUsername/"+username,User.class);
        return user;
    }
    public void saveUser(User user){
        restTemplate.postForObject("http://localhost:8080/restController/user",user,User.class);
    }
    public void deleteUser(int id){
        restTemplate.delete("http://localhost:8080/restController/user/"+id);
    }
    public void updateUser(User user){
        restTemplate.put("http://localhost:8080/restController/user",user);
    }
}
