package com.DP03Behavioral.Behavioral04ChainOfResponsibility;

public class Client {
    public static void main(String[] args) {
        //创建一个请假条对象
        LeaveRequest leaveRequest = new LeaveRequest("张三", 5, "生病");

        //创建各级领导对象
        GroupLeader groupLeader = new GroupLeader();
        Manager manager = new Manager();
        GeneralManager generalManager = new GeneralManager();

        //设置处理者链
        groupLeader.setNextHandler(manager);
        manager.setNextHandler(generalManager);

        //小明提交请假申请
        groupLeader.submit(leaveRequest);
    }
}
