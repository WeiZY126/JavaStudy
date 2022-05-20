package com.study.rpc.rpc02;

import com.study.rpc.common.User;

public class Client {
    public static void main(String[] args) throws Exception {
        User user = new Stub().findUserById(123);
        System.out.println(user);
    }
}
