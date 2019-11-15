package com.iversonx.abstract_factory.factory;

import com.iversonx.abstract_factory.army.Army;
import com.iversonx.abstract_factory.castle.Castle;
import com.iversonx.abstract_factory.king.King;

/**
 * @author Lijie
 * @version 1.0
 * @date 2019/11/15 18:36
 */
public interface KingdomFactory {
    Castle createCastle();
    King createKing();
    Army createArmy();
}
