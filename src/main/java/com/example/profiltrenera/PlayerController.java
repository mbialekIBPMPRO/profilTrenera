package com.example.profiltrenera;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class PlayerController {

    @Autowired
    private playersRepository playersRepository;

    private final JdbcTemplate jdbcTemplate;

    public PlayerController(com.example.profiltrenera.playersRepository playersRepository, JdbcTemplate jdbcTemplate) {
        this.playersRepository = playersRepository;
        this.jdbcTemplate = jdbcTemplate;
    }


    @GetMapping("/")
    public String homePage(Model model){
        List<Players> players = (List<Players>) playersRepository.findAll();
        model.addAttribute("players",players);
         return "index";
    }


    @PostMapping("/addOne")
    public String addOne(@RequestParam("fname") String fname, @RequestParam("lname") String lname){
        this.playersRepository.save(new Players(fname,lname));
        return "redirect:/";
    }
}
