package com.DP03Behavioral.Behavioral10Memento.whiteBox;

/**
 * 备忘录管理对象
 */
public class RoleStateCaretaker {
    //声明RoleStateMemento类型变量
    private RoleStateMemento roleStateMemento;

    public RoleStateMemento getRoleStateMemento() {
        return roleStateMemento;
    }

    public void setRoleStateMemento(RoleStateMemento roleStateMemento) {
        this.roleStateMemento = roleStateMemento;
    }
}
