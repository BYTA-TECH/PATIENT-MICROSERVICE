package com.bytatech.ayoos.client.custom_dms_core;

import org.springframework.context.annotation.Bean;import java.util.Base64;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//import com.bytatech.ayoos.client.dms_core.ApiKeyRequestInterceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.Util;
import java.util.*; 
@Component
public class ApiKeyRequestInterceptor implements RequestInterceptor {
 
	private String ticket;

  public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		String encodeBytes = Base64.getEncoder().encodeToString((ticket).getBytes());
		this.ticket = encodeBytes;
	}

@Override
  public void apply(RequestTemplate requestTemplate) {
  
		 requestTemplate.header("Authorization", "Basic "+getTicket());
			
  }
  
  
  
  
  
  

}
