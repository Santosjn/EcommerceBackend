package com.ecommerce.model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class Greeting {

	@RequestMapping("/greeting")
	public @ResponseBody String greeting() {
		return "Hello";
	}
}
