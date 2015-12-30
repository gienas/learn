package org.course.ejb;



import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.ejb.Stateless;

@Stateful
public class StatefullBean {

	private List<String> list;
	
	@PostConstruct
	public void postContruct()
	{
		list = new ArrayList<>();
	}
	
	public List<String> getList() {
		return list;
	}
	
	public void putValue(String val)
	{
		list.add(val);
	}
	
	
}
