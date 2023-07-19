package com.loosecouple.example;

//
// https://www.javaguides.net/2018/08/coupling-in-java-with-example.html
//

public class LooseCoupling {

    public static void main(String[] args) {
        // Example of tight coupling - To change journey from Car to Bike, it requires
        // changes in BadTraveler class
        BadTraveler bt = new BadTraveler();
        bt.startJourney();
        // Example of loose coupling - To change journey from Car to Bike, it
        // is possible without changing GoodTraveler class
        GoodTraveler gt = new GoodTraveler();

        // Inject Car dependency
        gt.setV(new Car());

        // start journey by Car
        gt.startJourney();

        // Inject Bike dependency
        gt.setV(new Bike());

        //Start journey by Bike
        gt.startJourney();
    }
}