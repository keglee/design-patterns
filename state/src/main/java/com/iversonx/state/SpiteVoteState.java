package com.iversonx.state;

/**
 * 恶意投票
 */
public class SpiteVoteState implements VoteState {
    @Override
    public void processVote(String user, String voteItem, VoteManager voteManager) {
        String s = voteManager.getMapVote().get(user);
        if(s != null) {
            voteManager.getMapVote().remove(user);
        }
        System.out.println("恶意刷票，取消投票记录");
    }
}
