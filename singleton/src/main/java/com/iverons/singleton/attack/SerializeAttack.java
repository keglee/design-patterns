package com.iverons.singleton.attack;

import com.iverons.singleton.static_inner.Singleton;

import java.io.*;

/**
 * @author Lijie
 * @version 1.0
 * @date 2019/11/18 20:29
 */
public class SerializeAttack {
    public static void main(String[] args) throws Exception{
        Singleton instance = Singleton.getInstance();
        // Write Obj to file
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tempFile"));
        oos.writeObject(instance);
        // Read Obj from file
        File file = new File("tempFile");
        ObjectInputStream ois =  new ObjectInputStream(new FileInputStream(file));
        Singleton newInstance = (Singleton) ois.readObject();

        // 判断是否是同一个对象
        System.out.println(instance);
        System.out.println(newInstance);
    }
}
