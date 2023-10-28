package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller /*создали контроллер для отслежки запросов*/
public class MainController {
    @GetMapping("/") /* указываем адрес, к которому будет обращатся */
    public String getCalculation(@RequestParam(value = "a", required = false) Float a,
                       @RequestParam(value = "b",required = false) Float b,
                       @RequestParam(value = "operation", required = false) String operation,
                       Model model){
        if(operation != null && a != null && b != null){
            model.addAttribute("a", a);
            model.addAttribute("b", b);
            model.addAttribute("operation", operation);

            switch (operation){
                case "+":{
                    model.addAttribute("answer", a + b);
                    break;
                }
                case "-":{
                    model.addAttribute("answer", a - b);
                    break;
                }
                case "/":{
                    model.addAttribute("answer", a / b);
                    break;
                }
                case "*":{
                    model.addAttribute("answer", a * b);
                    break;
                }
            }
        }
        return "main"; /* возвращаем имя шаблона */
    }

    @PostMapping("/") /* указываем адрес, к которому будет обращатся */
    public String postCalculation(@RequestParam(value = "c", required = false) Float c,
                                 @RequestParam(value = "d",required = false) Float d,
                                 @RequestParam(value = "operation", required = false) String operation,
                                 Model model){
        if(operation != null && c != null && d != null){
            model.addAttribute("c", c);
            model.addAttribute("d", d);

            switch (operation){
                case "+":{
                    model.addAttribute("answerPost", c + d);
                    break;
                }
                case "-":{
                    model.addAttribute("answerPost", c - d);
                    break;
                }
                case "/":{
                    model.addAttribute("answerPost", c / d);
                    break;
                }
                case "*":{
                    model.addAttribute("answerPost", c * d);
                    break;
                }
            }
        }
        return "main"; /* возвращаем имя шаблона */
    }
}
