package ru.otus.gpbu.pse.homework09.mybooks.common.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/library")
@Slf4j
public class MainMenuController {

    @GetMapping
    public String mainPage() {
        return "index";
    }
}
