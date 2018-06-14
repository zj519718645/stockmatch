package com.yongquan;
import java.io.*;

import javax.servlet.http.*;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class Example {

    
    @RequestMapping("/hello")
    public void hello(HttpServletRequest request,HttpServletResponse response) throws IOException {
    	
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Example.class, args);
    }

}
