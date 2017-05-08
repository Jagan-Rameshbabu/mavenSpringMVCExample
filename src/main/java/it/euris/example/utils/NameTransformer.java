package it.euris.example.utils;

import org.springframework.stereotype.Component;


public class NameTransformer {
	
	
	public NameTransformer(){}
	
	public String ChangeName(String name){
		return "Mr. " + name;
	}
	
	
}
