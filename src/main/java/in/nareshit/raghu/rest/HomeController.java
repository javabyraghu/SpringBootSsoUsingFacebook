package in.nareshit.raghu.rest;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/home")
	public String showAll() {
		return "WELCOME TO ALL";
	}
	
	@GetMapping("/data")
	public String afterLoginAll() {
		return "WELCOME TO USER !";
	}
	
	@GetMapping("/user")
	public Authentication showUser(Principal p) {
		System.out.println(p.getClass().getName());
		System.out.println("Hello user!" + p.getName());
		return SecurityContextHolder.getContext().getAuthentication();
		//return "WELCOME TO USER !";
	}
}
