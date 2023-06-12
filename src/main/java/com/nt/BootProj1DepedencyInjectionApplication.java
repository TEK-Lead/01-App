
/*
to cfg  pre-definded  java class  as spring use 
 @Bean  method  definitation in  @Configuration  class.
                                 (alternate to spring bean  cfg  file(xml))

@Spring Boot application 
@Configuration (to make java class as cfg class)
@CompoenetScan =>  to Reconized current package  and its sub package   
maintained  stero type  annotatations  based  java classes 	 as  spring beans 

@EnableAutoConfiguratin(To  enable  AutoConfiguration)


video no 4
49:29

IMP POINT
if u do not follow this convention  then 
u need to write explicitly write @CmponentScan.


Sb is not giving 
IDE is giving a default class for simplying our life 

if u created dynamic web project then it will give web.xml 









what is the difference @Component and @bean ?
@Component can make only user-defined classes spring beans and it is class level  annotation.

@Bean:- can make any user defined /pre-defined  class  obj given by  underlying  method as 
spring bean  and it  can be  used at  method  level  only  in @Configuration class. 


SpringApplication.run(-); internally   uses  AnnotationConfigApplicationContext class to create 
and retrun IOC  container  by taking  given  java class  as @Configuration  class
(in fact it  takes  current  class is  nothing but  Client  App  cum  configuration  class  as 
the cofiguration  class)

 








*/

package com.nt;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.nt.beans.WishMessageGenerator;

@SpringBootApplication
public class BootProj1DepedencyInjectionApplication {

//to cfg  pre-definded  java class  as spring use 
// @Bean  method  definitation in  @Configuration  class.
//                                 (alternate to spring bean  cfg  file(xml))
	
	
//@Bean:- can make any user defined /pre-defined  class  obj given by  underlying  method as 
//spring bean  and it  can be  used at  method  level  only  in @Configuration class. 

	
	@Bean(name="ltd")
     @Scope("prototype")
	public LocalDateTime createLocalDateTime() {
		System.out.println("hello");
		LocalDateTime ltd=LocalDateTime.now();
		return ltd;
	}
	
	@Bean(name="ltd1")
	@Scope("prototype")
	public LocalDateTime createLocalDateTime1() {
		System.out.println("hi");
		LocalDateTime ltd=LocalDateTime.now();
		return ltd;
	}
	


public static void main(String[] args) {

ApplicationContext ctx = SpringApplication.run(BootProj1DepedencyInjectionApplication.class, args);
		WishMessageGenerator generator = ctx.getBean("wmg", WishMessageGenerator.class);

		String result = generator.generateWishMessage("raja");
		System.out.println(result);
		((ConfigurableApplicationContext) ctx).close();

	}

}

/*


	@Bean(name = "ltd")
@Scope("protoType")
	public LocalDateTime createLocalDateTime() {
		System.out.println("");
		LocalDateTime ltd = LocalDateTime.now();
		return ltd;
	}

default bean  id::createLocalDateTime
                  method name



============================================================================================

spring                                        Spring Boot

*/
