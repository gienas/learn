package pl.ene.web.controller.jsf;

import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import org.course.ejb.StatefullBean;

//@Named
//@SessionScoped

@ManagedBean
@SessionScoped
public class TestStatefullBean {

	private String all;
	private String name;
	
	@Inject 
	StatefullBean sfsb;
	
	public void onclick() {
		System.out.println("--------------------------------------------");
		System.out.println("get name = " + getName());
		sfsb.putValue(getName());
		all = sfsb.getList().toString();
		System.out.println(all);
		
	}

	public String getAll() {
		return all;
	}

	public void setAll(String all) {
		this.all = all;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	
}
