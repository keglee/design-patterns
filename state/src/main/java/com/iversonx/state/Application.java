package com.iversonx.state;

/**
 * @author Lijie
 * @version 1.0
 * @date 2019/12/5 17:39
 */
public class Application {
    public static void main(String[] args) {
        VoteManager vm = new VoteManager();
        for(int i = 0; i < 8; i++) {
            vm.vote("u1", "A");
        }
    }
}
