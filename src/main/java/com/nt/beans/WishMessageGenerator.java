package com.nt.beans;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component can make only user-defined classes spring beans 
//and it is class level  annotation.


@Component("wmg")
public class WishMessageGenerator {
	
    @Qualifier("ltd")
        @Autowired
    private LocalDateTime date;
	
	public WishMessageGenerator() {
	System.out.println("wishMessageGenerator::0-param constructor");
	}

public  String  generateWishMessage(String user) {
	System.out.println("WishMessageGenerator.generateWishMessage(-)");
	int hour=date.getHour();
	
	if(hour<12)
		return "GOOD MORNING::"+user;
	else if(hour<16)
		return "GOOD AFTERNOON::"+user;
	
	else if(hour<20)
		return "GOOD Evening::"+user;
		
	return "GOOD NIGHT::"  +user;


  }
}
