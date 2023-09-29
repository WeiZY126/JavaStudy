package com.DP03Behavioral.Behavioral03Command;

import java.util.ArrayList;
import java.util.List;

/**
 * 调用者
 * 服务员类
 */
public class Waitor {
    //持有多个命令对象
    private List<Command> commands = new ArrayList<>();

    public void setCommand(Command cmd) {
        //将CMD存储到List
        commands.add(cmd);
    }

    //发起命令
    public void orderUp() {
        System.out.println("服务员：订单来了");
        for (Command command : commands) {
            if (command != null)
                command.execute();
        }
    }
}
