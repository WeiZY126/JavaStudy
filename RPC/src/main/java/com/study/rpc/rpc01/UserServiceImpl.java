package com.study.rpc.rpc01;

import com.study.rpc.common.IUserService;
import com.study.rpc.common.User;

public class UserServiceImpl implements IUserService {
    @Override
    public User findUserById(Integer id) {
        return new User(id, "Alice");
    }
}
