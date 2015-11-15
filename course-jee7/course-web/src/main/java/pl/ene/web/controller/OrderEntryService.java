package pl.ene.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.ene.common.rest.EntityNotFoundException;
import pl.ene.common.rest.ServerLogged;
import pl.ene.model.rest.Order;
import pl.ene.model.rest.Orders;

@Path("/orders")

public class OrderEntryService {
	
	private Logger LOG = LoggerFactory.getLogger(OrderEntryService.class);
	
	//
	static private List<Order> LIST = new ArrayList<>();
	static {
		for (int i = 0; i < 10; i++) {
			Order order = new Order();
			order.setCustomerId(i);
			order.setId(i);
			LIST.add(order);
		}
	}

	/**
	 * 
	 * @param size
	 * @return
	 */
	
	@GET
	@Path("/xml")
	@Produces("application/xml")
	public Orders getOrders(@QueryParam("size") @DefaultValue("50") int size) {
		LOG.info("Get orders {}", size );
		Orders orders = new Orders();
		orders.setOrders(LIST);
		return orders;
	}


	@ServerLogged
	@GET
	@Path("/json")
	@Produces("application/json")
	public Orders getMyOrders(@QueryParam("size") @DefaultValue("50") int size) {
		Orders orders = new Orders();
		orders.setOrders(LIST);
		return orders;
	}
	
	/**
	 * 
	 * @param orderId
	 * @return
	 */
	@GET
	@Path("{id}")
	@Produces("application/xml")
	public Order getOrder(@PathParam("id") int orderId) {
		for ( Order o: LIST)
		{
			if (o.getId() == orderId ) return o;
		}
		throw new EntityNotFoundException("Order id = " + orderId + " not found");
	}

	@ServerLogged
	@POST
	@Path("create")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces("application/xml")
	public Order createOrder(@FormParam("id") int id, @FormParam("name") String name)
	{
		Order o = new Order();
		o.setId(id);
		o.setName(name);
		LIST.add(o);
		return o;
	}
	
	
	@POST
	public void setOrder(Order order) {

	}

}
