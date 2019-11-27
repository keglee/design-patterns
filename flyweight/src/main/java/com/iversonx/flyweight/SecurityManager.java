package com.iversonx.flyweight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SecurityManager {
    private static SecurityManager securityManager = new SecurityManager();
    private SecurityManager() {}

    public static SecurityManager getSecurityManager() {
        return securityManager;
    }

    /**
     * 在运行期间，用来存放登录人员对应的权限
     * 在Web应用中，这些数据通常存放到session
     */
    private Map<String, List<Flyweight>> session = new HashMap<>();

    public void login(String user) {
        List<Flyweight> list = queryByUser(user);
        session.put(user, list);
    }

    public boolean hasPermit(String user, SecurityEntity entity, Permit permit) {
        List<Flyweight> list = session.get(user);
        if(list == null || list.isEmpty()) {
            System.out.println(user + "没有登录或没有分配权限");
            return false;
        }

        for(Flyweight f : list) {
            System.out.println("fm=" + f);
            if(f.match(entity, permit)) {
                return true;
            }
        }
        return false;
    }

    private List<Flyweight> queryByUser(String user) {
        List<Flyweight> list = new ArrayList<>();
        for(String s : TestDB.data) {
            String ss[] = s.split(",");
            if(ss[0].equals(user)) {
                Flyweight f = FlyweightFactory.getFactory().getFlyweight(ss[1] + "," + ss[2]);
                list.add(f);
            }
        }
        return list;
    }
}
