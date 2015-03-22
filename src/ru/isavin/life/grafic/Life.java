package ru.isavin.life.grafic;

import ru.isavin.life.model.Cell;
import ru.isavin.life.model.World;

import java.awt.*;

/**
 * @author ilasavin
 * @since 22.03.15
 */
public class Life {

    public static final int FIELD_WIDTH = 1200;
    public static final int FIELD_HEIGHT = 600;

    private static LifeFrame mainFrame;
    private static Graphics g;

    public static void main(String[] args) {
        mainFrame = new LifeFrame(FIELD_WIDTH, FIELD_HEIGHT, "Conway's game of life");
        mainFrame.setLocationRelativeTo(null);
        World world = new World();

        int factor = LifePanel.FACTOR;

        world.createColony(FIELD_HEIGHT / factor, FIELD_WIDTH / factor);
//        world.populateColony();
//        world.createGlider(22, 152);
        world.createGliderGun(15, 130);
//        world.createDiehard(43, 152);
//        world.createAcorn(43, 152);
//        world.createLineColony(20,140);
        mainFrame.setVisible(true);

        while (world.colonyIsAlive()) {
            Cell[][] cells = world.getColony().getCells();
            for (int i = 0; i < cells.length; i++) {
                for (int j = 0; j < cells[i].length; j++) {
                    if (cells[i][j].isAlive()) {
                        mainFrame.canvas.addCell(new CellImage(j * factor, i * factor));
                    }
                }
            }
            mainFrame.canvas.repaint();

            world.changeGeneration();

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
