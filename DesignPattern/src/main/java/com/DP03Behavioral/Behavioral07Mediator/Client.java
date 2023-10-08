package com.DP03Behavioral.Behavioral07Mediator;

public class Client {
    public static void main(String[] args) {
        //创建中介者对象
        MediatorStructure mediatorStructure = new MediatorStructure();

        //创建房主
        HouseOwner houseOwner = new HouseOwner("张三", mediatorStructure);
        //创建租房者对象
        Tenant tenant = new Tenant("李四", mediatorStructure);

        //中介要知道具体的房主和租客
        mediatorStructure.setTenant(tenant);
        mediatorStructure.setHouseOwner(houseOwner);

        tenant.constact("我要租房");
        houseOwner.constact("我这里有");
    }
}
