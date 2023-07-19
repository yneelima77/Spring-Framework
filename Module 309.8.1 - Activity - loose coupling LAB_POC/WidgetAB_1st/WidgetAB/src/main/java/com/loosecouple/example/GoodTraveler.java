package com.loosecouple.example;


class GoodTraveler {
    private Vehicle v;

    public Vehicle getV() {
        return v;
    }

    public void setV(Vehicle v) {
        this.v = v;
    }

    public void startJourney() {

        v.move();
    }
}