package com.study.akka.akka02test;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class T2RemoteServerActorLauncher {
    public static void main(String[] args) {
        //TODO 通过加载remote.conf的配置创建名为remote支持远程通信的ActorSystem
        Config config = ConfigFactory.load("remote.conf");
        ActorSystem actorSystem = ActorSystem.create("remote",config);
        //TODO 调用actorOf创建并启动名为T1RemoteServerActor的Actor实例
        // 并返回Actor地址(ActorRef)
        ActorRef actor = actorSystem.actorOf(Props.create(T1RemoteServerActor.class), "T1RemoteServerActor");
        //TODO 调用tell方法向T1RemoteServerActor发送消息
        actor.tell("hello!",ActorRef.noSender());

    }
}
