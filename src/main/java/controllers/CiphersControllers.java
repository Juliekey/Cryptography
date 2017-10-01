package controllers;

import entities.Cipher;
import entities.Lab;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import services.CiphersService;

import java.util.Map;

@Controller
public class CiphersControllers {
    CiphersService ciphersService;

    Map<Integer, Lab> labs = CiphersService.getAllLabs();

    @RequestMapping({"/", "/ciphers"})
    public ModelAndView showCiphers() {
        ModelAndView modelAndView = new ModelAndView("ciphers");
        modelAndView.addObject(labs);
        return modelAndView;
    }

    @RequestMapping({"/", "/ciphers"})
    public ModelAndView showCipherResult(@RequestParam Integer labId, @RequestParam Integer cipherId) {
        Cipher cipherObj = labs.get(labId).getCiphers().get(cipherId);
        return null;
    }
}
