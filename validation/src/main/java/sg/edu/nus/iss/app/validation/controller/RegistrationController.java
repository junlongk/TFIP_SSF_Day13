package sg.edu.nus.iss.app.validation.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sg.edu.nus.iss.app.validation.models.Person;

@Controller
@RequestMapping(path="/register")
public class RegistrationController {

    @GetMapping
    public String getRegForm(Model model) {
        model.addAttribute("registration", new Person());
        return "register";
    }

    @PostMapping
    public String postRegistration(@Valid Person p, BindingResult bResult, Model model) {
        if (bResult.hasErrors()) {
            model.addAttribute("registration", p);
            return "register";
        }
        return "thankyou";
    }
}
