package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.concurrent.ThreadLocalRandom;

@Controller
public class DiceController {

    @GetMapping("/roll-dice")
    public String sendPage() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{n}")
    public String returnShowDice(@PathVariable int n, Model model) {
        int roll = ThreadLocalRandom.current().nextInt(1, 6 + 1);
        model.addAttribute("guess", n);
        model.addAttribute("roll", roll);
        return "dice-guess";
    }

}
