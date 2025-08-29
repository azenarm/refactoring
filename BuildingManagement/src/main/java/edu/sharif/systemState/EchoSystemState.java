package edu.sharif.systemState;

import edu.sharif.BuildingManager;
import edu.sharif.device.Device;

import java.util.List;

public class EchoSystemState extends SystemState {

    public EchoSystemState(BuildingManager manager) {
        super(manager);
    }

    @Override
    public List<Device> activeDevices() {
        return manager.getDevices().stream()
                .filter(Device::isCritical)
                .toList();
    }

    @Override
    public String getName() {
        return "Echo";
    }
}
