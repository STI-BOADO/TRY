package ProgressBarColors;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicProgressBarUI;

public class BrownProgressBarUI extends BasicProgressBarUI {
    private final Color BROWN = new Color(205, 133, 63);

    @Override
    protected void paintDeterminate(Graphics g, JComponent c) {
        super.paintDeterminate(g, c);

        int value = progressBar.getValue();
        int max = progressBar.getMaximum();

        double percentage = (double) value / (double) max;

        int width = (int) (percentage * progressBar.getWidth());

        g.setColor(BROWN);
        g.fillRect(0, 0, width, progressBar.getHeight());
    }

    @Override
    protected void paintIndeterminate(Graphics g, JComponent c) {

        super.paintIndeterminate(g, c);

        g.setColor(BROWN);
        g.fillRect(0, 0, progressBar.getWidth(), progressBar.getHeight());
    }
}