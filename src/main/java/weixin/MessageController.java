package weixin;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
	
	@RequestMapping("text.xml")
	public TextMessage receiveText(@RequestBody TextMessage message) {
		
		
		System.out.println(message.getContent());
		
		return message;
	}
	
}
