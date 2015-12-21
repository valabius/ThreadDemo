package com.disser.factories;

public class FactoryProducer {

    public static DissertationsFactory getFactory(String choice){

        if(choice.equalsIgnoreCase("AllDissertationsFactory")){
            return new AllDissertationsFactory();

        }else if(choice.equalsIgnoreCase("SelectedDissertationsFactory")){
            return new SelectedDissertationsFactory();
        }

        return null;
    }
}
