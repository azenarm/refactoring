package edu.sharif.systemState;

import edu.sharif.BuildingManager;
import edu.sharif.device.Device;

import java.util.List;

public class ActiveSystemState extends SystemState {

    public ActiveSystemState(BuildingManager manager) {
        super(manager);
    }

    @Override
    public List<Device> activeDevices() {
        return manager.getDevices();
    }

    @Override
    public String getName() {
        return "Active";
    }
}
