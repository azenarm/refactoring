package edu.sharif;

import edu.sharif.device.EmergencyLighting;
import edu.sharif.device.LowConsumptionAirConditioner;
import edu.sharif.device.Television;
import edu.sharif.pricePolicy.GreenPricePolicy;
import edu.sharif.pricePolicy.PeakPricePolicy;
import edu.sharif.pricePolicy.StandardPricePolicy;
import edu.sharif.systemState.ActiveSystemState;
import edu.sharif.systemState.EchoSystemState;
import edu.sharif.systemState.ShutdownSystemState;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final BuildingManager buildingManager = new BuildingManager(List.of(
            new Television(),
            new LowConsumptionAirConditioner(),
            new EmergencyLighting()));

    public static void main(String[] args) {
        runApp();
    }

    private static void runApp() {
        while (true) {
            System.out.println("Enter your role.\n1) manager\n2) user\n3) exit");
            int role = scanner.nextInt();
            switch (role) {
                case 1:
                    managerMode();
                    break;
                case 2:
                    userMode();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid input.");
            }
        }
    }

    private static void managerMode() {
        while (true) {
            System.out.println("Enter command:\n1) change price policy\n2) change system state\n3) exit");
            int command = scanner.nextInt();
            switch (command) {
                case 1:
                    changePricePolicy();
                    break;
                case 2:
                    changeSystemState();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid input.");
            }
        }
    }

    private static void changePricePolicy() {
        System.out.println("Enter policy:\n1) Standard\n2) Peak Hours\n3) Green Mode");
        int policy = scanner.nextInt();
        switch (policy) {
            case 1:
                buildingManager.setPricePolicy(StandardPricePolicy.INSTANCE);
                break;
            case 2:
                buildingManager.setPricePolicy(PeakPricePolicy.INSTANCE);
                break;
            case 3:
                buildingManager.setPricePolicy(GreenPricePolicy.INSTANCE);
                break;
            default:
                System.out.println("Invalid input.");
        }
    }

    private static void changeSystemState() {
        System.out.println("Enter systemState:\n1) Active\n2) Echo Mode\n3) Shutdown");
        int state = scanner.nextInt();
        switch (state) {
            case 1:
                buildingManager.setSystemState(new ActiveSystemState(buildingManager));
                break;
            case 2:
                buildingManager.setSystemState(new EchoSystemState(buildingManager));
                break;
            case 3:
                buildingManager.setSystemState(new ShutdownSystemState(buildingManager));
                break;
            default:
                System.out.println("Invalid input.");
        }
    }

    private static void userMode() {
        while (true) {
            System.out.println("Enter command:\n1) show current system state\n2) total price\n3) simulate usage\n4) exit");
            int command = scanner.nextInt();
            switch (command) {
                case 1:
                    showCurrentState();
                    break;
                case 2:
                    totalPrice();
                    break;
                case 3:
                    simulateUsage();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid input.");
            }
        }
    }

    private static void showCurrentState() {
        System.out.println("Current system state: " + buildingManager.getSystemState().getName());
    }

    private static void totalPrice() {
        System.out.println("Total price: " + buildingManager.totalPrice());
    }

    private static void simulateUsage() {
        System.out.println("Enter energy");
        int energy = scanner.nextInt();
        System.out.println("Price: " + buildingManager.simulate(energy));
    }
}