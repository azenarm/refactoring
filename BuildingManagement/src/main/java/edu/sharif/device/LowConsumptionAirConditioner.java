package edu.sharif.device;

public class LowConsumptionAirConditioner implements Device {

    @Override
    public int energyConsumption() {
        return 50;
    }

    @Override
    public boolean isCritical() {
        return true;
    }
}
