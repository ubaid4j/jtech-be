package com.ubaid.jconnect.restapi.feignProxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ubaid.jconnect.restapi.model.Session;

@FeignClient(contextId = "session-client", name = "api-gateway")
public interface SessionProxy {
    @GetMapping("jtech/sessions/{senderId}")
    List<Session> getSessionsBySenderId(@PathVariable("senderId") Long senderId);

    @GetMapping("jtech/sessions/{sessionId}/user/{userId}/active/{active}")
    Session setUserActive(@PathVariable("sessionId") Long sessionId,
                          @PathVariable("userId") Long userId, @PathVariable("active") Boolean active);

    @GetMapping("jtech/sessions/by/session/{sessionId}")
    Session getSessionById(@PathVariable("sessionId") Long sessionId);

    @PostMapping("jtech/sessions")
    Session createSession(@RequestBody Session session);
}
