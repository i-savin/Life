package ru.isavin.life.txt;

import ru.isavin.life.txt.ru.isavin.life.model.World;

import java.io.IOException;

/**
 * @author ilasavin
 * @since 03.02.15
 */
public class Life {

    public static void main(String[] args) throws IOException {
        World world = new World();
        world.createColony(50, 20);
//        world.populateColony();
        world.createGlider();
        world.printColony();


        System.out.println();

        for (int i = 0; i < 100; i++) {
            world.changeGeneration();
            world.printColony();
//            System.out.println("-----------------------");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
