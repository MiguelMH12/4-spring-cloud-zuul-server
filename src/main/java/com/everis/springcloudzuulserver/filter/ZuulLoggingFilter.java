package com.everis.springcloudzuulserver.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter  extends ZuulFilter{
	
	//slf4j framework que permite almacenar logs
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	//Si deseas que el filtro sea ejecutado o no
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	//Instrucciones que ejecutará el filtro
	@Override
	public Object run() throws ZuulException {
		//Atrapamos la peticion que hace el usuario
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		//Mensaje
		//debug (desarrollo) en vez de System.out
		//warn (warning)
		//error (ya valio)
		//fatal (ya valio mas feo)
		logger.info("Peticion -> {} URL -> {}", request, request.getRequestURL());
		return null;
	}

	//Indicamos en que momento queremos que el filtro se ejecute
	//pre, post, error
	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre"; //Antes de que ejecte el servicio
	}

	//Orden en que se va a ejecutar el filtro
	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
