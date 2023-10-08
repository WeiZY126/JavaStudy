package com.DP03Behavioral.Behavioral04ChainOfResponsibility;

/**
 * 小组长类
 */
public class GroupLeader extends Handler {

    public GroupLeader() {
        super(0, Handler.NUM_ONE);
    }

    @Override
    protected void handleLevel(LeaveRequest leaveRequest) {
        System.out.println(leaveRequest.getName() + "请假" + leaveRequest.getNum() + "天" + leaveRequest.getContent());
        System.out.println("小组长审批:同意");
    }
}
