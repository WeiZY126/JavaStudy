package com.DP03Behavioral.Behavioral10Memento.blackBox;


public class Client {
    public static void main(String[] args) {
        System.out.println("-----战斗前-----");
        //创建游戏角色对象
        GameRole gameRole = new GameRole();
        gameRole.initState();
        gameRole.stateDisplay();

        //将该游戏角色内部状态进行备份
        //创建管理者对象
        RoleStateCaretaker roleStateCaretaker = new RoleStateCaretaker();
        roleStateCaretaker.setMemento(gameRole.saveState());

        System.out.println("-----战斗后-----");
        gameRole.fight();
        gameRole.stateDisplay();

        System.out.println("-----恢复状态-----");
        gameRole.recoverState(roleStateCaretaker.getMemento());

        gameRole.stateDisplay();

    }
}
