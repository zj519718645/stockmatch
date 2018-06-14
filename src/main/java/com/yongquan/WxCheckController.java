package com.yongquan;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.bind.annotation.RestController;  
  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import java.io.IOException;  
import java.io.PrintWriter;  
import net.binjoo.utils.SHA1;
  
@RestController  
@RequestMapping("/getResult")  
public class WxCheckController {  

  
  
	private String TOKEN = "LiangSheng998_LoveKunan1314";
    /** 
     * 与公众号服务器配置进行比对 
     * @param req 
     * @param res 
     */  
    @RequestMapping(method = RequestMethod.GET)  
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
        
        System.out.println(req);  
    }  
  
    /** 
     * 接收公众号的各种信息 
     * @param request 
     * @return 
     */  
    @RequestMapping(method = RequestMethod.POST)  
    public String processRequest(HttpServletRequest request) {  
        String message = wxUserService.saveWxUserOperation(request);  
        return message;  
    }  
  
  
  
}  
