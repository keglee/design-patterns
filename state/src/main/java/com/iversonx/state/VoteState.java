package com.iversonx.state;

/**
 * 封装投票状态相关的行为
 */
public interface VoteState {
    void processVote(String user, String voteItem, VoteManager voteManager);
}
