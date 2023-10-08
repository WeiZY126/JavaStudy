package com.DP03Behavioral.Behavioral04ChainOfResponsibility;

/**
 * 部门经理类
 */
public class Manager extends Handler {

    public Manager() {
        super(Handler.NUM_ONE, Handler.NUM_THREE);
    }

    @Override
    protected void handleLevel(LeaveRequest leaveRequest) {
        System.out.println(leaveRequest.getName() + "请假" + leaveRequest.getNum() + "天" + leaveRequest.getContent());
        System.out.println("部门经理审批:同意");
    }
}
