package com.yongquan;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;
import org.apache.log4j.Logger;
import java.util.Arrays;
import javax.servlet.http.*;
import java.io.*;


@RestController
@SpringBootApplication
public class SpringBootWebApplication extends SpringBootServletInitializer{
	
    @Override 
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	return application.sources(SpringBootWebApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootWebApplication.class, args);
    }
    
    
    @RequestMapping("/")
    String home() {
	return "hello world!";
    }
    @RequestMapping("/getResult")
    public void getWxResult(HttpServletRequest req, HttpServletResponse res) {
	String TOKEN = "LiangSheng998_LoveKunan1314";	
    	Logger logger= Logger.getLogger(SpringBootWebApplication.class);
    	String signature = req.getParameter("signature"); 
	String timestamp = req.getParameter("timestamp");
	String nonce = req.getParameter("nonce");
	String echostr = req.getParameter("echostr");
	PrintWriter out = null;
	//return echostr;
	String[] str = { TOKEN, timestamp, nonce };
	Arrays.sort(str);
	String bigStr = str[0] + str[1] + str[2];
	String digest = new SHA1().getDigestOfString(bigStr.getBytes()).toLowerCase();
	logger.info("siganature is :" + signature);
	logger.info("after sh1 string is: " + digest);
	if (digest.equals(signature)){
        try {  
            out = res.getWriter();  
            out.print(echostr);  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            out.close();  
            out = null;  
        }  
	}
	
    }
}
