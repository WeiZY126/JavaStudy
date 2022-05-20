package com.study.rpc.rpc03;

import com.study.rpc.common.User;
import com.study.rpc.rpc02.Stub;

public class Client {
    public static void main(String[] args) throws Exception {
        User user = new Stub().findUserById(123);
        System.out.println(user);
    }
}
