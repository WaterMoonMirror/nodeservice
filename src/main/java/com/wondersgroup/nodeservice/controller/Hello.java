package com.wondersgroup.nodeservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lizhu@wondesgroup.com
 * @date: 2021/1/7 16:35
 * @description: test controller class
 */
@RestController
public class Hello {
    @GetMapping("/hello")
    public String hello(){
     return  "this is hello page";
    }
}
