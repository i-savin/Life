package ru.isavin.life.txt;

import ru.isavin.life.model.Population;
import ru.isavin.life.model.World;

import java.io.IOException;
import java.util.Scanner;

import static ru.isavin.life.model.Population.Random;
import static ru.isavin.life.model.Population.values;

/**
 * @author ilasavin
 * @since 03.02.15
 */
public class Life {

    public static final int INTERVAL = 1000 / 20;

    public static void main(String[] args) throws IOException {
        clearScreen();
        World world = new World();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter world size: ");
        System.out.print("length: ");
        int length = in.nextInt();
        System.out.print("height: ");
        int height = in.nextInt();
        world.createColony(length, height);
        clearScreen();
//        System.out.println("Choose:");
        int choice = 0;
        while (choice != values().length + 1) {
            clearScreen();
            for (int i = 0; i < values().length; i++) {
                System.out.println(i + 1 + ". " + values()[i].getName());
            }
            System.out.println(values().length + 1 + ". Start!");
            System.out.print("Choose:");
            choice = in.nextInt();
            if (choice != values().length + 1) {
                createFigure(world, Population.values()[choice - 1]);
            }
        }
//        world.populateColony();
//        world.createGlider(22, 152);
//        world.createGliderGun(15, 130);
//        world.createDiehard(43, 152);
//        world.createAcorn(43, 152);
//        world.createLineColony(20,140);
        world.printColony();
        clearScreen();

        while (world.colonyIsAlive()) {
            world.changeGeneration();
            world.printColony();
            try {
                Thread.sleep(INTERVAL);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clearScreen();
        }
    }

    private static void createFigure(World world, Population type) {
        clearScreen();
        if (type == Random) {
            world.populateColony();
            return;
        }
        int x, y;
        System.out.println("Enter top left coordinates of figure:");
        Scanner in = new Scanner((System.in));
        System.out.print("x: ");
        x = in.nextInt();
        System.out.print("y: ");
        y = in.nextInt();
        switch (type) {
            case Acorn:
                world.createAcorn(x, y);
                break;
            case DieHard:
                world.createDiehard(x, y);
                break;
            case Glider:
                world.createGlider(x, y);
                break;
            case GliderGun:
                world.createGliderGun(x, y);
                break;
            case LineColony:
                world.createLineColony(x, y);
                break;
        }


    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
    }

}
