# iocproj08-propertiesfile
 
# Code

```Java
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

```

```Java
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

```

```Java
package com.nt.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.nt.sbeans")
@PropertySource("com/nt/commons/Info.properties")
public class AppConfig {

}

```

```properties
#Personal information
per.id=1001
per.name=raja
per.addrs=hyd

```

# POM
```xml
  <dependencies>
        <!-- https://mvnrepository.com/artifact/org.springframework/spring-context-support -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context-support</artifactId>
            <version>6.1.5</version>
        </dependency>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13.2</version>
            <scope>test</scope>
        </dependency>

    </dependencies>
```

# UML
![UML](src/main/resources/UML.png)