package com.iversonx.state;

import java.util.HashMap;
import java.util.Map;

/**
 * 投票管理
 */
public class VoteManager {
    private VoteState state = null;

    private Map<String, String> mapVote = new HashMap<>();

    private Map<String, Integer> mapVoteCount = new HashMap<>();

    public Map<String, String> getMapVote() {
        return mapVote;
    }

    public void vote(String user, String voteItem) {
        Integer oldVoteCount = mapVoteCount.get(user);
        if(oldVoteCount == null) {
            oldVoteCount = 0;
        }

        oldVoteCount = oldVoteCount + 1;
        mapVoteCount.put(user, oldVoteCount);

        if(oldVoteCount == 1) {
            state = new NormalVoteState();
        } else if (oldVoteCount > 1 && oldVoteCount < 5) {
            state = new RepeatVoteState();
        } else if (oldVoteCount >= 5 && oldVoteCount < 8) {
            state = new SpiteVoteState();
        } else {
            state = new BlackVoteState();
        }

        state.processVote(user, voteItem, this);
    }
}
