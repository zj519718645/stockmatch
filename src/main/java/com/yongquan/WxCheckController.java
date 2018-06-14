package com.yongquan;

import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import java.io.IOException;  
import java.io.PrintWriter;  

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
 
@SpringBootApplication
public class WxCheckController {  
  
    private String TOKEN = "LiangSheng998_LoveKunan1314";
    /** 
     * 与公众号服务器配置进行比对 
     * @param req 
     * @param res 
     */  
    @RequestMapping("/getResult")
    public void getWxResult(HttpServletRequest req, HttpServletResponse res){  
        // 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。  
        String signature = req.getParameter("signature");  
        // 时间戳  
        String timestamp = req.getParameter("timestamp");  

        // 随机数  
        String nonce = req.getParameter("nonce");  
        // 随机字符串  
        String echostr = req.getParameter("echostr");  
  
        String[] str = { TOKEN, timestamp, nonce };

        String bigStr = str[0] + str[1] + str[2];
        
        String digest = new SHA1().getDigestOfString(bigStr.getBytes()).toLowerCase();
        
        if (digest.equals(signature)) {
        	try {
				res.getWriter().print(echostr);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }  
  
    public static void main(String[] args) throws Exception {
        SpringApplication.run(WxCheckController.class, args);
    } 
  
}  
