package com.ubaid.jconnect.restapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

    private Long id;
    private Long sessionId;
    private Long messageId;
    private Long receiverId;
    private Long senderId;
    private Boolean isSeen;
}
