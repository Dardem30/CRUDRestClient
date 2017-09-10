package by.controller;

import by.model.User;
import by.service.RestTemplateService;
import by.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Роман on 30.08.2017.
 */
@Controller
public class MainController {
    @Autowired
    private RestTemplateService restTemplateService;
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView main(){
        ModelAndView modelAndView=new ModelAndView("index");
        modelAndView.addObject("userList",restTemplateService.getListUser());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return modelAndView;
    }
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }
    @RequestMapping(value = "/registration",method = RequestMethod.GET)
    public String registrationUser(Model model){
        model.addAttribute("userForm",new User());
        return "registration";
    }
    @RequestMapping(value = "/registration",method = RequestMethod.POST)
    public String registrationUser(@ModelAttribute("userForm")User user){
        if(restTemplateService.getUserByUsername(user.getUsername())!=null){
            return "redirect:/registration";
        }else {
            restTemplateService.saveUser(user);
            return "redirect:/login";
        }
    }
    @RequestMapping(value = "/updateUser/{id}",method = RequestMethod.GET)
    public String updateUser(@RequestParam("id") int id, Model model){
        User user=restTemplateService.getUserById(id);
        model.addAttribute("user",user);
        return "updateUser";
    }
}
