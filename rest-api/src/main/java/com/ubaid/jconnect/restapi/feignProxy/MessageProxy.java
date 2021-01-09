package com.ubaid.jconnect.restapi.feignProxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ubaid.jconnect.restapi.model.Message;

@FeignClient(contextId = "message-client", name = "api-gateway")
public interface MessageProxy {

    @GetMapping("jtech/messages/by/session/{id}")
    List<Message> getConversationBySessionId(@PathVariable("id") Long sessionId);

    @PostMapping("jtech/messages/by/session")
    Message saveMessage(@RequestBody Message message);

    @GetMapping("jtech/messages/by/session/{sessionId}/user/{userId}")
    List<Message> getAllReceivedMessage(@PathVariable("sessionId") Long sessionId,
                                        @PathVariable("userId") Long userId);

    @PutMapping("jtech/messages/by/session")
    List<Message> updateReceivedMessages(@RequestBody List<Message> messages);
}
