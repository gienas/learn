package pl.ene.web.controller;

import javax.ws.rs.ext.Provider;

import pl.ene.common.rest.RestCommonReadInterceptor;
import pl.ene.common.rest.ServerLogged;

@Provider
@ServerLogged
public class RestLoggingInterceptor extends RestCommonReadInterceptor{

}
