//package controller;
//
//import data.entity.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//
//public class userController {
//    @Autowired
//    private UserServletImpl userServlet;
//    @PostMapping("/createUser")
//    public String saveUser(@ModelAttribute("user") User user)  {
//        userServlet.getServletName();
//        return "redirect:/";
//    }
//}
