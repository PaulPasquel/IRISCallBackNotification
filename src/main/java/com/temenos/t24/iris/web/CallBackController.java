package com.temenos.t24.iris.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class CallBackController {

	private void printMap(Map<String, Object> payload, int n){
		String tab = new String(new char[n]).replace("\0", "   ");
		for (String key : payload.keySet() ) {
			Object o = payload.get(key);
			if(o instanceof Map){
				System.out.println(tab + key + "{");
				printMap((Map<String, Object>) o, n +1 );
				System.out.println(tab + "}");
			} else {
				System.out.println(tab + key + ":" + o);
			}

		}
	}

	@PostMapping(path="/callback/customerUpdate", consumes = "text/plain;charset=UTF-8")
	public String index(@RequestBody String payload) {
		//printMap(payload,0);
		System.out.println(payload);
		return "{\"response\" : \"ok\"}";
	}

}