package com.study.akka.akka02test;

import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.actor.ActorSystem;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class T3LocalClient {
    public static void main(String[] args) {
        Config config = ConfigFactory.load("client.conf");
        //TODO 根据加载的配置创建local的ActorSystem
        ActorSystem actorSystem = ActorSystem.create("local", config);

        //TODO 调用actorSelection方法得到远程Actor的地址
        // 最后获取远程Actor地址并发送消息
        ActorSelection toFind = actorSystem.actorSelection("akka.tcp://remote@127.0.0.1:50010/user/t1RemoteServerActor");
        toFind.tell("I am from local", ActorRef.noSender());
    }
}
