package com.iversonx.abstract_factory;


import com.iversonx.abstract_factory.factory.KingdomFactory;

/**
 * @author Lijie
 * @version 1.0
 * @date 2019/11/15 17:32
 */
public class Application {

    public static void main(String[] args) {
        System.out.println("Elf Kingdom");
        KingdomFactory kingdomFactory = FactoryMaker.makeFactory(FactoryMaker.KingdomType.ELF);
        System.out.println(kingdomFactory.createArmy().getDescription());
        System.out.println(kingdomFactory.createCastle().getDescription());
        System.out.println(kingdomFactory.createKing().getDescription());

        System.out.println("Orc Kingdom");
        kingdomFactory = FactoryMaker.makeFactory(FactoryMaker.KingdomType.ORC);
        System.out.println(kingdomFactory.createArmy().getDescription());
        System.out.println(kingdomFactory.createCastle().getDescription());
        System.out.println(kingdomFactory.createKing().getDescription());
    }
}
