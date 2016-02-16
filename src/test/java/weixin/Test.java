package weixin;

public class Test {
	public static void main(String[] args) {
		MessageType type = MessageType.valueOf("text");
//		System.out.println(MessageType.text.name().equals("text"));
//		type.setValue("event");
		System.out.println(type == MessageType.text);
		
		String lower = "text";
		lower = lower.replaceFirst("\\S", lower.substring(0, 1).toUpperCase());
		System.out.println(lower);
	}
}
