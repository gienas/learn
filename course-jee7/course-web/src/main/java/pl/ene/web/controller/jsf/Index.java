package pl.ene.web.controller.jsf;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

@Named(value="index")
public class Index {
	
	@PostConstruct
	public void post()
	{
		
	}
	
	public String hello() {
		System.out.println("Hello from JSF");
		return "Hello from JSF";
	}

}
