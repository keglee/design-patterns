package com.iversonx.state;

/**
 * @author Lijie
 * @version 1.0
 * @date 2019/12/5 17:27
 */
public class BlackVoteState implements VoteState {
    @Override
    public void processVote(String user, String voteItem, VoteManager voteManager) {
        System.out.println("加入黑名单");
    }
}
