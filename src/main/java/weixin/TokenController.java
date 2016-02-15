package weixin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {
	
	@RequestMapping("check")
	public String check(String signature, String timestamp, String nonce, String echostr) {
		
		System.out.println(signature);
		System.out.println(timestamp);
		System.out.println(nonce);
		System.out.println(echostr);
		
		return echostr;
	}
	
	
	
}
