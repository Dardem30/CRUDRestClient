package by.controller;

import by.DAO.RoleDAO;
import by.model.Role;
import by.model.User;
import by.service.RestTemplateService;
import by.service.RoleService;
import by.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Роман on 30.08.2017.
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping(value = "/restController")
public class RestController {
    @Autowired
    private UserService userService;
    @Autowired
    private RestTemplateService restTemplateService;

    @RequestMapping(value = "/listUser",method = RequestMethod.GET)
    public List<User> getListUser(){
        return restTemplateService.getListUser();
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public User getUserById(@RequestParam int id){
        return restTemplateService.getUserById(id);
    }

    @RequestMapping(value = "/saveUser",method = RequestMethod.POST)
    public ModelAndView saveUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return new ModelAndView("login");
    }
    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public ModelAndView updateUser(@ModelAttribute("user")User user){
        restTemplateService.updateUser(user);
        ModelAndView modelAndView=new ModelAndView("index");
        modelAndView.addObject("userList",restTemplateService.getListUser());
        return modelAndView;
    }
     @RequestMapping(value = "/deleteUser/{id}",method = RequestMethod.GET)
    public ModelAndView deleteUser(@RequestParam("id")int id){
        restTemplateService.deleteUser(id);
         ModelAndView modelAndView=new ModelAndView("index");
         modelAndView.addObject("userList",restTemplateService.getListUser());
         return modelAndView;
     }
}
