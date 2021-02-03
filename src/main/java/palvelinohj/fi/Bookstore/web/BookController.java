package palvelinohj.fi.Bookstore.web;

import org.springframework.stereotype.Controller;

@Controller
public class BookController {

	@GetMapping("/index")
	public String greetingForm(Model model) {
	model.addAttribute("message", new Message());
	return "hello";
	}
}
