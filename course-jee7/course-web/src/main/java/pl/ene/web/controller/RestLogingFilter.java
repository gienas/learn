package pl.ene.web.controller;

import javax.ws.rs.ext.Provider;

import pl.ene.common.rest.RestCommonServerLoggingFilter;
import pl.ene.common.rest.ServerLogged;

/**
 * 
 * @author eneugebauer
 *
 */
@Provider
@ServerLogged
public class RestLogingFilter extends RestCommonServerLoggingFilter {

}
