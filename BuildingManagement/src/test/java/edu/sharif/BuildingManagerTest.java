package edu.sharif;

import edu.sharif.device.Device;
import edu.sharif.pricePolicy.GreenPricePolicy;
import edu.sharif.pricePolicy.PeakPricePolicy;
import edu.sharif.pricePolicy.StandardPricePolicy;
import edu.sharif.systemState.ActiveSystemState;
import edu.sharif.systemState.EchoSystemState;
import edu.sharif.systemState.ShutdownSystemState;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BuildingManagerTest {

    BuildingManager buildingManager = new BuildingManager(List.of(new Device1(), new Device2()));

    @Test
    void initialManager() {
        assertEquals(15 * 500, buildingManager.totalPrice());
        assertEquals(500, buildingManager.simulate(1));
    }

    @Test
    void standardPolicy() {
        buildingManager.setPricePolicy(StandardPricePolicy.INSTANCE);

        assertEquals(15 * 500, buildingManager.totalPrice());
        assertEquals(500, buildingManager.simulate(1));
    }

    @Test
    void peakHourPolicy() {
        buildingManager.setPricePolicy(PeakPricePolicy.INSTANCE);

        assertEquals(15 * 1000, buildingManager.totalPrice());
        assertEquals(1000, buildingManager.simulate(1));
    }

    @Test
    void greenPolicy() {
        buildingManager.setPricePolicy(GreenPricePolicy.INSTANCE);

        assertEquals(15 * 300, buildingManager.totalPrice());
        assertEquals(300, buildingManager.simulate(1));
    }

    @Test
    void activeState() {
        buildingManager.setSystemState(new ActiveSystemState(buildingManager));

        assertEquals(15 * 500, buildingManager.totalPrice());
        assertEquals(500, buildingManager.simulate(1));
    }

    @Test
    void echoState() {
        buildingManager.setSystemState(new EchoSystemState(buildingManager));

        assertEquals(5 * 500, buildingManager.totalPrice());
        assertEquals(500, buildingManager.simulate(1));
    }

    @Test
    void shutdownState() {
        buildingManager.setSystemState(new ShutdownSystemState(buildingManager));

        assertEquals(0, buildingManager.totalPrice());
        assertEquals(500, buildingManager.simulate(1));
    }
}

class Device1 implements Device {

    @Override
    public int energyConsumption() {
        return 10;
    }

    @Override
    public boolean isCritical() {
        return false;
    }
}

class Device2 implements Device {

    @Override
    public int energyConsumption() {
        return 5;
    }

    @Override
    public boolean isCritical() {
        return true;
    }
}