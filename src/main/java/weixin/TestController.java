package weixin;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping(value="person", produces="application/xml")
	public Person person2xml() {
		System.out.println("xml");
		return new Person("Jason", 23);
	}
	
	@RequestMapping("person.json")
	public Person person2json() {
		System.out.println("json");
		return new Person("Jason", 23);
	}
	
	@RequestMapping("add.xml")
	public Person add(@RequestBody Person person) {
		return person;
	}
}
