package com.study.rpc.rpc04;

import com.study.rpc.common.IUserService;
import com.study.rpc.common.User;
import com.study.rpc.rpc01.UserServiceImpl;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

public class Stub {

    public static IUserService getStub(){
        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket s = new Socket("localhost",8888);
                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                String methodName = method.getName();
                Class<?>[] parameterTypes = method.getParameterTypes();
                oos.writeUTF(methodName);
                oos.writeObject(parameterTypes);
                oos.writeObject(args);
                oos.flush();


                DataInputStream dis = new DataInputStream(s.getInputStream());
                int receivedId = dis.readInt();
                String name = dis.readUTF();
                User user = new User(receivedId, name);

                System.out.println(user);

                oos.close();
                s.close();
                return user;
            }
        };
        Object o = Proxy.newProxyInstance(IUserService.class.getClassLoader(), UserServiceImpl.class.getInterfaces(), h);
        System.out.println(o.getClass().getName());
        return (IUserService)o;
    }
}
