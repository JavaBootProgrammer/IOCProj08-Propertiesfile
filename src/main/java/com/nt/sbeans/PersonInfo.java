package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("pInfo")
public class PersonInfo {
	@Value("123456789")  //direct value Injection
	private  long aadharNo;
	
	//Injecting the values collected from the properties file
	@Value("${per.id}")   
	private Integer pid;
	
	@Value("${per.name}")
	private String pname;
	@Value("${per.addrs}")
	private String addrs;
	
	//Injecting the System proeprties vlaues
	@Value("${os.name}")
	private  String  osName;
	
	@Value("${os.version}")
	private  String  osVer;
	
	//injecting the values of the Env.. variables
	@Value("${Path}")
	private  String pathData;

	//toString()  (alt+shift+s,s)
	@Override
	public String toString() {
		return "PersonInfo [aadharNo=" + aadharNo + ", pid=" + pid + ", pname=" + pname + ", addrs=" + addrs
				+ ", osName=" + osName + ", osVer=" + osVer + ", pathData=" + pathData + "]";
	}
	
	
	
	
	
	
	

}
