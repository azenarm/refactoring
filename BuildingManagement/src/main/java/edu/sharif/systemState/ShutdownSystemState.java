package edu.sharif.systemState;

import edu.sharif.BuildingManager;
import edu.sharif.device.Device;

import java.util.List;

public class ShutdownSystemState extends SystemState {

    public ShutdownSystemState(BuildingManager manager) {
        super(manager);
    }

    @Override
    public List<Device> activeDevices() {
        return List.of();
    }

    @Override
    public String getName() {
        return "Shutdown";
    }
}
