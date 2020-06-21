package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.*;
import com.dhkim9549.mlptictactoe.RMIInterface;

import java.util.*;

@RestController
public class GreetingController {

	@GetMapping("/greeting")
	public String greeting(@RequestParam(value = "board", defaultValue = "") String board) {
    
		System.out.println("board = " + board);

		String a = "";
    
		RMIInterface look_up = null;
    
		try {
			look_up = (RMIInterface)Naming.lookup("//bada.ai/MyServer");
			a += look_up.helloTo(board);
			Thread.sleep(300);
		} catch(Exception ex){
			a += ex;
		}    

		return a;
	}

	@GetMapping("/hello")
	public Set hello() {
		TreeSet set = new TreeSet();
		set.add("kkk");
		set.add("aaa");
		set.add("asdfsadf");
		Random r = new Random();
		set.add("" + r.nextDouble());
		return set;
	}
}
