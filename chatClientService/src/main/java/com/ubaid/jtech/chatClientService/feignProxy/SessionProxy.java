package com.ubaid.jtech.chatClientService.feignProxy;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ubaid.jtech.chatClientService.model.Session;

@FeignClient(contextId = "session-client", name = "api-gateway-server")
@RibbonClient(name = "session-service") 
public interface SessionProxy
{
	@GetMapping("session-service/jtech/sessions/{senderId}")
	public List<Session> getSessionsBySenderId(@PathVariable("senderId") Long senderId);
}
