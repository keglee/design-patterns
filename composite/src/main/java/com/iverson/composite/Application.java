package com.iverson.composite;

/**
 * @author Lijie
 * @version 1.0
 * @date 2019/11/21 17:41
 */
public class Application {
    public static void main(String[] args) {
        Component root = new Composite("服装");
        Component nan = new Composite("男装");
        Component nv = new Composite("女装");

        Component chen = new Leaf("衬衣");
        Component jia = new Leaf("夹克");
        Component qun = new Leaf("裙子");
        Component tao = new Leaf("套装");

        root.addChild(nan);
        root.addChild(nv);

        nan.addChild(chen);
        nan.addChild(jia);
        nv.addChild(qun);
        nv.addChild(tao);

        root.printStruct("");
    }
}
