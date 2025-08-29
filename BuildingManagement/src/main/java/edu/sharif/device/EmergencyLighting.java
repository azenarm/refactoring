package edu.sharif.device;

public class EmergencyLighting implements Device {
    @Override
    public int energyConsumption() {
        return 20;
    }

    @Override
    public boolean isCritical() {
        return true;
    }
}
