package weixin;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class NormalMessage extends Message {
	@JacksonXmlProperty(localName="MsgId")
	private Long msgId;

	public Long getMsgId() {
		return msgId;
	}

	public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}
	
}
