package com.iversonx.state;

/**
 * 正常投票
 */
public class NormalVoteState implements VoteState {
    @Override
    public void processVote(String user, String voteItem, VoteManager voteManager) {
        voteManager.getMapVote().put(user, voteItem);
        System.out.println("投票成功");
    }
}
