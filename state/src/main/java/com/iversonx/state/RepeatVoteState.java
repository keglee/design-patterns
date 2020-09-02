package com.iversonx.state;

/**
 * 重复投票
 */
public class RepeatVoteState implements VoteState {

    @Override
    public void processVote(String user, String voteItem, VoteManager voteManager) {
        System.out.println("请不要重复投票");
    }
}
