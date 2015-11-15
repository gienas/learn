package pl.ene.web.controller;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import pl.ene.common.rest.RestCommonServerLoggingFilter;

/**
 * Without not work
 * 
 * @author eneugebauer
 *
 */

@ApplicationPath("/rest")
public class ApplicationConfig extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		// TODO Auto-generated method stub
		Set<Class<?>> res = super.getClasses();
		if (res == null) {

			res = new HashSet<>();
		}
		addFilters(res);
		System.out.println("--------------------" + res);
		return res;
	}

	private void addFilters(Set<Class<?>> set) {
	//	set.add(RestServerLoggingFilter.class);
	}

}
