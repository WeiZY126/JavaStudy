package com.study.rpc.rpc04;

import com.study.rpc.common.IUserService;
import com.study.rpc.common.User;

public class Client {
    public static void main(String[] args) throws Exception {
        IUserService stub = Stub.getStub();
        User user = stub.findUserById(123);
        System.out.println(user);
    }
}
