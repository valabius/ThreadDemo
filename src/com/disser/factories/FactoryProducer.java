package com.disser.factories;

public class FactoryProducer {

    public static DissertationsFactory getFactory(String choice) {

        if (choice.equalsIgnoreCase("RuDissertationsFactory")) {
            return new RuDissertationsFactory();

        } else if (choice.equalsIgnoreCase("RuDissertationsFactory5")) {
            return new RuDissertationsFactory5();

        } else if (choice.equalsIgnoreCase("UaDissertationsFactory")) {
            return new UaDissertationsFactory();

        } else if (choice.equalsIgnoreCase("UaDissertationsFactory5")) {
            return new UaDissertationsFactory5();
        }

        return null;
    }
}
