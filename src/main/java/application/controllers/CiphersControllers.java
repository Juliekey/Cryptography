package application.controllers;

import application.dto.EncryptDTO;
import application.services.CiphersService;
import entities.Cipher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestScope
public class CiphersControllers {
    CiphersService ciphersService;

    @Autowired
    public CiphersControllers(CiphersService ciphersService) {
        this.ciphersService = ciphersService;
    }

    @GetMapping(value = {"/", "ciphers"})
    public ModelAndView showCiphers() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("encryptdto", new EncryptDTO());
        modelAndView.addObject("labs", ciphersService.getAllLabs());
        return modelAndView;
    }

    @PostMapping({"getResult"})
    public ModelAndView showCipherResult(@ModelAttribute EncryptDTO encryptDTO) {
        Map<Integer, Cipher> allCiphers = ciphersService.getAllCiphers();
        Cipher cipher = allCiphers.get(encryptDTO.getId());
        ModelAndView modelAndView = new ModelAndView("result");
        String encrypted = cipher.encrypt(encryptDTO.getWord());
        modelAndView.addObject("word", encryptDTO.getWord());
        modelAndView.addObject("encrypted", encrypted);
        modelAndView.addObject("key", cipher.getKey());
        modelAndView.addObject("tableOfChange", cipher.getTableOfChange());
        modelAndView.addObject("cipher", cipher.getName());
        return modelAndView;
    }
}
