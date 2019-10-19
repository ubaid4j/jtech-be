package com.ubaid.jtech.chatClientService.feignProxy;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ubaid.jtech.chatClientService.model.Message;

@FeignClient(contextId = "message-client", name = "api-gateway-server")
@RibbonClient(name = "message-service") 
public interface MessageProxy {
	
	@GetMapping("message-service/jtech/messages/by/session/{id}")
	public List<Message> getConversationBySessionId(@PathVariable("id") Long sessionId);
	
	@PostMapping("message-service/jtech/messages/by/session/")
	public Message saveMessage(@RequestBody Message message);
	
	@GetMapping("message-service/jtech/messages/by/session/{sessionId}/user/{userId}")
	public List<Message> getAllReceivedMessage(@PathVariable("sessionId") Long sessionId,
			@PathVariable("userId") Long userId);
}
