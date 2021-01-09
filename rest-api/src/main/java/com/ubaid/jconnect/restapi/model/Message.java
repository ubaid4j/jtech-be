package com.ubaid.jconnect.restapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private Long id;
    private Long sessionId;
    private String text;
    private Timestamp sentTime;
    private Timestamp receivedTime;
    private Timestamp seenTime;
    private Long ownerId;
    private Integer port;
}
