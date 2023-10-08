package com.DP03Behavioral.Behavioral04ChainOfResponsibility;

/**
 * 总经理类
 */
public class GeneralManager extends Handler {

    public GeneralManager() {
        super(Handler.NUM_THREE, Handler.NUM_SEVEN);
    }

    @Override
    protected void handleLevel(LeaveRequest leaveRequest) {
        System.out.println(leaveRequest.getName() + "请假" + leaveRequest.getNum() + "天" + leaveRequest.getContent());
        System.out.println("总经理审批:同意");
    }
}
