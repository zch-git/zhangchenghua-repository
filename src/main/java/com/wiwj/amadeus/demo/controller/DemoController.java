package com.wiwj.amadeus.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("api/wiwj/amadeus/deamo")
public class DemoController {

    @GetMapping("/test")
    @ResponseBody
    public String testController(@RequestParam("username")String userName,@RequestParam("describe") String describe){
        return "大家好，我叫"+userName+"，后面是我想要说的话："+describe;
    }
}
