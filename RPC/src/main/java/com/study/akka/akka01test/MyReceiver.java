package com.study.akka.akka01test;

import akka.actor.UntypedAbstractActor;

public class MyReceiver extends UntypedAbstractActor {
    public static enum Msg{
        HELLO,DONE;
    }
    @Override
    public void onReceive(Object message) throws Throwable, Throwable {
        if (message.equals(Msg.HELLO)){
            System.out.println("hello world");
            getSender().tell(Msg.DONE,getSelf());
        }else{
            unhandled(message);
        }
    }
}
