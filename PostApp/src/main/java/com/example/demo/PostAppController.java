package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import com.example.demo.User;

@RestController
public class PostAppController {
	
	@GetMapping("/myposts/{id}")
	public User getMyPost(@PathVariable("id") String id) {
		
		System.out.println("in get my post"+id);
		
		String url = "https://jsonplaceholder.typicode.com/posts/"+id;
		
		RestClient rc = RestClient.create();
		
		User response = rc.get().uri(url).retrieve().body(User.class);
		
		System.out.println("response is "+ response.getBody());
		return response;
	}

}
