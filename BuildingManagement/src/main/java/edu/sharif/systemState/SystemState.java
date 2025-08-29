package edu.sharif.systemState;

import edu.sharif.BuildingManager;
import edu.sharif.device.Device;

import java.util.List;

public abstract class SystemState {

    protected BuildingManager manager;

    public SystemState(BuildingManager manager) {
        this.manager = manager;
    }

    public abstract List<Device> activeDevices();

    public abstract String getName();
}
