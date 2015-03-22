package ru.isavin.life.grafic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ilasavin
 * @since 22.03.15
 */
public class LifeFrame extends JFrame {

    LifePanel canvas;

    public LifeFrame(int width, int height, String name) {
        super(name);
        setSize(width, height);
        setResizable(false);
        Container contentPane = getContentPane();
        canvas = new LifePanel();
        canvas.setDoubleBuffered(true);
        contentPane.add(canvas, "Center");

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

}

class LifePanel extends JPanel {
    public final static int FACTOR = 10;

    private Image dbImage;
    private Graphics dbg;
    private List<CellImage> cellImages = new ArrayList<CellImage>();

    public void addCell(CellImage cellImage) {
        cellImages.add(cellImage);
    }

    public void paint(Graphics g) {
        dbImage = createImage(getWidth(), getHeight());
        dbg = dbImage.getGraphics();
        paintComponent(dbg);
        g.drawImage(dbImage, 0, 0, this);
        for (int i = 0; i < cellImages.size(); i++) {
            CellImage cellImage = cellImages.get(i);
            g.setColor(Color.BLUE);
//            g.drawRect(cellImage.getX(), cellImage.getY(), 1, 1);
            g.fillRect(cellImage.getX(), cellImage.getY(), FACTOR, FACTOR);
        }
        cellImages.clear();
    }
}
