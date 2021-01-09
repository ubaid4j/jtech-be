package com.ubaid.jconnect.restapi.model;

import java.sql.Timestamp;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Session {
    private Long id;
    private Long senderId;
    private Long receiverId;
    private Boolean isActive;
    private Boolean isReceiverActive;
    private Boolean isSenderActive;
    private Timestamp lastTimeActive;
    private Timestamp initiateTime;
    private Integer port;
    private User sender;
    private User receiver;

    /*--------------------------------Don't Alter------------------------------------------------------------*/
    public void setSender(List<User> senders) {
        if (senders == null) return;
        this.sender = senders.parallelStream().filter(p -> p.getId() == getSenderId()).findAny().orElse(null);
    }

    public void setReceiver(List<User> receivers) {
        if (receivers == null) return;
        this.receiver = receivers.parallelStream().filter(p -> p.getId() == getReceiverId()).findAny().orElse(null);
    }
    /*--------------------------------------------------------------------------------------------------------*/
}
