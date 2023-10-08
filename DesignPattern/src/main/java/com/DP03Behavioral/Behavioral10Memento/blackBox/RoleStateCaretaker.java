package com.DP03Behavioral.Behavioral10Memento.blackBox;

/**
 * 备忘录管理对象
 */
public class RoleStateCaretaker {
    //声明Memento类型变量
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
