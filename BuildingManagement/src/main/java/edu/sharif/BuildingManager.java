package edu.sharif;

import edu.sharif.device.Device;
import edu.sharif.pricePolicy.PricePolicy;
import edu.sharif.pricePolicy.StandardPricePolicy;
import edu.sharif.systemState.ActiveSystemState;
import edu.sharif.systemState.SystemState;

import java.util.List;

public class BuildingManager {

    private SystemState systemState;
    private PricePolicy pricePolicy;
    private final List<Device> devices;

    public BuildingManager(List<Device> devices) {
        this.devices = List.copyOf(devices);
        systemState = new ActiveSystemState(this);
        pricePolicy = StandardPricePolicy.INSTANCE;
    }

    public void setPricePolicy(PricePolicy pricePolicy) {
        this.pricePolicy = pricePolicy;
    }

    public void setSystemState(SystemState systemState) {
        this.systemState = systemState;
    }

    public SystemState getSystemState() {
        return this.systemState;
    }

    public int totalPrice() {
        var activeDevice = systemState.activeDevices();
        int energy = activeDevice.stream().mapToInt(Device::energyConsumption).sum();
        return pricePolicy.price(energy);
    }

    public int simulate(int energy) {
        return pricePolicy.price(energy);
    }

    public List<Device> getDevices() {
        return devices;
    }
}
