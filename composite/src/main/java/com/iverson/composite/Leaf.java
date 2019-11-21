package com.iverson.composite;

/**
 * @author Lijie
 * @version 1.0
 * @date 2019/11/21 17:22
 */
public class Leaf extends Component {
    private String name = "";
    @Override
    public void printStruct(String preStr) {
        System.out.println(preStr + "-" + name);
    }

    public Leaf(String name) {
        this.name = name;
    }
}
