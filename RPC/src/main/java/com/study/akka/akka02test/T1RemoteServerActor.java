package com.study.akka.akka02test;

import akka.actor.AbstractActor;

public class T1RemoteServerActor extends AbstractActor {
    @Override
    public Receive createReceive() {
        //TODO 接收到String消息，打印到控制台
        return receiveBuilder()
                .match(String.class,message->{
                    System.out.println(message);
                })
                .build();
    }
}
