package weixin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName="xml")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Message {
	@JacksonXmlProperty(localName="ToUserName")
	private String toUserName;
	@JacksonXmlProperty(localName="FromUserName")
	private String fromUserName;
	@JacksonXmlProperty(localName="CreateTime")
	private Long createTime;
	@JacksonXmlProperty(localName="MsgType")
	private String msgType;
	
	public Message() {
		this.createTime = System.currentTimeMillis();
	}
	
	public String getToUserName() {
		return toUserName;
	}
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}
	public String getFromUserName() {
		return fromUserName;
	}
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}
	public Long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	
}
