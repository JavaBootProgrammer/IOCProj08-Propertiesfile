package com.nt.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import com.nt.config.AppConfig;
import com.nt.sbeans.PersonInfo;

public class PropertiesFileTest {

	public static void main(String[] args) {
		//create the IOC container
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		//get Spring bean class obj ref
		PersonInfo info=ctx.getBean("pInfo",PersonInfo.class);
		System.out.println(info);
		
		//Get Environment object
		Environment env=ctx.getEnvironment();
		System.out.println(env.getProperty("os.name"));
		System.out.println(env.getProperty("per.id"));
		
		//close the container
		ctx.close();
	}

}
