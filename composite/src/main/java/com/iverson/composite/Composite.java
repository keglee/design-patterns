package com.iverson.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lijie
 * @version 1.0
 * @date 2019/11/21 17:24
 */
public class Composite extends Component {
    private List<Component> childComponents = new ArrayList<>();
    private String name = "";

    public Composite(String name) {
        this.name = name;
    }

    @Override
    public void addChild(Component child) {
        childComponents.add(child);
    }

    @Override
    public void removeChild(Component child) {
        childComponents.remove(child);
    }

    @Override
    public Component getChildren(int index) {
        return childComponents.get(index);
    }

    @Override
    public void printStruct(String preStr) {
        System.out.println(preStr + "-" + name);

        preStr += " ";
        for(Component component : childComponents) {
            component.printStruct(preStr);
        }
    }
}
