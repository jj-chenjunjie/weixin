package weixin;

import java.io.IOException;
import java.util.Map;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@RestController
public class WeixinController {

	private ObjectMapper xmlMapper = new XmlMapper();
	
	private static final String MESSAGE_PACKGE = "weixin";
	
	@RequestMapping(method=RequestMethod.GET)
	public String get(String signature, String timestamp, String nonce, String echostr) {
		
		System.out.println(signature);
		System.out.println(timestamp);
		System.out.println(nonce);
		System.out.println(echostr);
		
		return echostr;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String post(/*@RequestBody Map<String, String> message, */@RequestBody String xml) throws JsonParseException, JsonMappingException, IOException {
		String result = "";
		Message message = this.xml2Message(xml);
		exchangeUserName(message);
		
		/*MessageType messageType = MessageType.valueOf(message.get("MsgType"));
		
		
		switch (messageType) {
		case event:
			System.out.println("event -> " + message.get("Event"));
			Event event = Event.valueOf(message.get("Event"));
			switch (event) {
			case subscribe:
				TextMessage textMessage = new TextMessage();
				textMessage.setContent("感谢您关注jason的微信订阅号");
				textMessage.setCreateTime(System.currentTimeMillis());
				textMessage.setFromUserName(message.get("ToUserName"));
				textMessage.setToUserName(message.get("FromUserName"));
				textMessage.setMsgType("text");
				result = xmlMapper.writeValueAsString(textMessage);				
				break;
			
			case unsubscribe: 
				
				break;

			default:
				break;
			}
			break;
			
		case text:
			TextMessage textMessage = new TextMessage();
			textMessage.setContent("刚发送的消息: " + message.get("Content"));
			textMessage.setCreateTime(System.currentTimeMillis());
			textMessage.setFromUserName(message.get("ToUserName"));
			textMessage.setToUserName(message.get("FromUserName"));
			textMessage.setMsgType("text");
//			Message msg = textMessage;
			result = xmlMapper.writeValueAsString(textMessage);
			break;

		default:
			break;
		}*/
		result = xmlMapper.writeValueAsString(message);
		result = result.replace(" xmlns=\"\"", "");
		System.out.println(result);
		return result;
	}
	
	
	private Message xml2Message(String xml) throws JsonParseException, JsonMappingException, IOException{
		Message message = xmlMapper.readValue(xml, Message.class); 
		String msgType = message.getMsgType();
		try {
			message = (Message) xmlMapper.readValue(xml, Class.forName(MESSAGE_PACKGE + "." + msgType.replaceFirst("\\S", msgType.substring(0, 1).toUpperCase()) + "Message" ));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return message;
	}
	
	private void exchangeUserName(Message message){
		String fromUserName = message.getFromUserName();
		message.setFromUserName(message.getToUserName());
		message.setToUserName(fromUserName);
	}

}
