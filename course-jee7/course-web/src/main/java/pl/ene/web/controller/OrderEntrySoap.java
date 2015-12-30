package pl.ene.web.controller;

import javax.jws.WebService;

import pl.ene.model.rest.Orders;

@WebService
public interface OrderEntrySoap {
	
	public Orders getOrders( int size);
	
}
