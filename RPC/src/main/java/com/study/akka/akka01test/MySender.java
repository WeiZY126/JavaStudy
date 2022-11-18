package com.study.akka.akka01test;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedAbstractActor;

public class MySender extends UntypedAbstractActor {
    ActorRef actor;
    @Override
    public void preStart(){
        actor = getContext().actorOf(Props.create(MyReceiver.class),"myReceiver");
        System.out.println("MyReceiver path:"+actor.path());
        actor.tell(MyReceiver.Msg.HELLO,getSelf());
    }
    @Override
    public void onReceive(Object message) throws Throwable, Throwable {
        if (message.equals(MyReceiver.Msg.DONE)){
            actor.tell(MyReceiver.Msg.HELLO,self());//向receiver发送消息
            getContext().stop(getSelf());//停止
        }else {
            unhandled(message);
        }
    }

    public static void main(String[] args) {
        ActorSystem actorSystem = ActorSystem.create("test");
        ActorRef mySender = actorSystem.actorOf(Props.create(MySender.class), "mySender");
        System.out.println("MySender path:"+mySender.path());
    }
}
