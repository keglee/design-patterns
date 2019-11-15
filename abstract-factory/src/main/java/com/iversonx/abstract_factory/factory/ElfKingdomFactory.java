package com.iversonx.abstract_factory.factory;

import com.iversonx.abstract_factory.army.Army;
import com.iversonx.abstract_factory.army.ElfArmy;
import com.iversonx.abstract_factory.castle.Castle;
import com.iversonx.abstract_factory.castle.ElfCastle;
import com.iversonx.abstract_factory.king.ElfKing;
import com.iversonx.abstract_factory.king.King;

/**
 * @author Lijie
 * @version 1.0
 * @date 2019/11/15 18:39
 */
public class ElfKingdomFactory implements KingdomFactory {
    @Override
    public Castle createCastle() {
        return new ElfCastle();
    }

    @Override
    public King createKing() {
        return new ElfKing();
    }

    @Override
    public Army createArmy() {
        return new ElfArmy();
    }
}
