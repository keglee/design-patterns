package com.iversonx.abstract_factory;

import com.iversonx.abstract_factory.factory.ElfKingdomFactory;
import com.iversonx.abstract_factory.factory.KingdomFactory;
import com.iversonx.abstract_factory.factory.OrcKingdomFactory;

import java.util.Map;

/**
 * @author Lijie
 * @version 1.0
 * @date 2019/11/15 18:42
 */
public class FactoryMaker {
    public enum KingdomType {
        ELF, ORC
    }

    public static KingdomFactory makeFactory(KingdomType type) {
        switch (type) {
            case ELF:
                return new ElfKingdomFactory();
            case ORC:
                return new OrcKingdomFactory();
            default:
                throw new IllegalArgumentException("KingdomType not supported.");
        }
    }
}
