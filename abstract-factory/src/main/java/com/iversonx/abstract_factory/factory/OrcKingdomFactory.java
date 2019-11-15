package com.iversonx.abstract_factory.factory;

import com.iversonx.abstract_factory.army.Army;
import com.iversonx.abstract_factory.army.OrcishArmy;
import com.iversonx.abstract_factory.castle.Castle;
import com.iversonx.abstract_factory.castle.OrcishCastle;
import com.iversonx.abstract_factory.king.King;
import com.iversonx.abstract_factory.king.OrcishKing;

/**
 * @author Lijie
 * @version 1.0
 * @date 2019/11/15 18:38
 */
public class OrcKingdomFactory implements KingdomFactory {
    @Override
    public Castle createCastle() {
        return new OrcishCastle();
    }

    @Override
    public King createKing() {
        return new OrcishKing();
    }

    @Override
    public Army createArmy() {
        return new OrcishArmy();
    }
}
