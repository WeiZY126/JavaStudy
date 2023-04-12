package com.study.LeetCode.algorithm10DynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 游戏背包*
 */
public class Apr12GameBackpack {
    public static void main(String[] args) {
        Prop[] props = {new Prop("xxj", 1500, 1), new Prop("xxj2", 2000, 3), new Prop("xxj3", 3000, 4)};
        outBag(props, 4);

    }

    public static void outBag(Prop[] props, int bagSize) {
        PropsList[][] resArray = new PropsList[props.length][bagSize];
        for (int i = 0; i < props.length; i++) {
            Prop prop = props[i];
            for (int j = 0; j < bagSize; j++) {
                int thisBagSize = j+1;
                if (i == 0) {
                    if (prop.cost > j + 1)
                        resArray[i][j] = new PropsList(0);
                    else
                        resArray[i][j] = new PropsList(prop.value).addProps(prop);
                    continue;
                }
                if (prop.cost > thisBagSize)
                    resArray[i][j] = resArray[i - 1][j];
                else {
                    Integer lastValue = resArray[i - 1][j].value;
                    int thisValue;
                    if (prop.cost - thisBagSize <= 0) {
                        thisValue = prop.value;
                    } else
                        thisValue = prop.value + resArray[i][prop.cost - thisBagSize].value;
                    if (thisValue > lastValue) {
                        PropsList propsList = new PropsList(thisValue).addProps(prop);
                        for (Prop prop1 : resArray[i - 1][j].props) {
                            propsList.addProps(prop1);
                        }
                        resArray[i][j] = propsList;
                    } else {
                        resArray[i][j] = resArray[i - 1][j];
                    }
                }
            }
        }
        System.out.println(resArray[props.length - 1][bagSize - 1]);
    }

}

class PropsList {
    public Integer value;
    public Set<Prop> props = new HashSet<>();

    public PropsList(Integer value) {
        this.value = value;
    }

    public PropsList addProps(Prop prop) {
        props.add(prop);
        return this;
    }

    @Override
    public String toString() {
        return "PropsList{" +
                "value=" + value +
                ", props=" + props +
                '}';
    }
}

class Prop {
    public String name;
    public Integer value;
    public Integer cost;

    public Prop(String name, Integer value, Integer cost) {
        this.name = name;
        this.value = value;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Prop{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", cost=" + cost +
                '}';
    }
}
