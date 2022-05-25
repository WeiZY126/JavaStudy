package com.study.rpc.rpc06;

import com.study.rpc.common.IUserService;
import com.study.rpc.common.User;
import com.study.rpc.rpc01.UserServiceImpl;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

public class Stub {

    public static Object getStub(Class clazz){
        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket s = new Socket("localhost",8888);
                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());

                String clazzName = clazz.getName();
                String methodName = method.getName();
                System.out.println(methodName);

                Class<?>[] parameterTypes = method.getParameterTypes();

                oos.writeUTF(clazzName);
                oos.writeUTF(methodName);
                oos.writeObject(parameterTypes);
                oos.writeObject(args);
                oos.flush();


                ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                Object o = ois.readObject();

                oos.close();
                s.close();
                return o;
            }
        };
        Object o = Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, h);
        return o;
    }
}
