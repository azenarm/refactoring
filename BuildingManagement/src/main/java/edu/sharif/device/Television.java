package edu.sharif.device;

public class Television implements Device{

    @Override
    public int energyConsumption() {
        return 100;
    }

    @Override
    public boolean isCritical() {
        return false;
    }
}
