package Game;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.Timer;
import ProgressBarColors.BrownProgressBarUI;
import ProgressBarColors.RedProgressBarUI;
import ProgressBarColors.YellowProgressBarUI;

public class ProgressBars extends JFrame {

    JProgressBar healthBar, hungerBar, energyBar;
    Timer hTimer, eTimer;
    JTextArea hunger, energy, health;
    boolean isDark;

    public ProgressBars(boolean isDark) {
        this.isDark = isDark;

        Color brown = new Color(205, 133, 63);
        Font font = new Font("Arial", Font.BOLD, 15);

        healthBar = new JProgressBar(0, 100);
        healthBar.setValue(50);
        healthBar.setUI(new RedProgressBarUI());
        healthBar.setBounds(1200, 10, 100, 20);

        health = new JTextArea("Health: " + healthBar.getValue());
        health.setBounds(1220, 35, 100, 20);
        health.setBorder(null);
        health.setFont(font);
        health.setForeground(Color.RED);
        health.setEditable(false);
        health.setOpaque(false);

        add(health);
        add(healthBar);

        hTimer = new Timer(5000, e -> {
            int hvalue = hungerBar.getValue();
            hvalue -= 1;
            hungerBar.setValue(hvalue);
            hunger.setText("Hunger: " + hungerBar.getValue());
        });
        hTimer.start();

        hungerBar = new JProgressBar(0, 100);
        hungerBar.setValue(50);
        hungerBar.setUI(new BrownProgressBarUI());
        hungerBar.setBounds(1200, 60, 100, 20);
        add(hungerBar);

        hunger = new JTextArea("Hunger: " + hungerBar.getValue());
        hunger.setBounds(1220, 85, 100, 20);
        hunger.setBorder(null);
        hunger.setFont(font);
        hunger.setForeground(brown);
        hunger.setEditable(false);
        hunger.setOpaque(false);
        add(hunger);

        energyBar = new JProgressBar(0, 100);
        energyBar.setValue(50);
        energyBar.setUI(new YellowProgressBarUI());
        energyBar.setBounds(1200, 110, 100, 20);
        add(energyBar);

        energy = new JTextArea("Energy: " + energyBar.getValue());
        energy.setBounds(1220, 135, 100, 20);
        energy.setBorder(null);
        energy.setEditable(false);
        energy.setFont(font);
        energy.setForeground(Color.YELLOW);
        energy.setOpaque(false);
        add(energy);

        eTimer = new Timer(5000, e -> {
            if (isDark) {
                int evalue = energyBar.getValue();
                evalue += 5;
                energyBar.setValue(evalue);
                energy.setText("Energy: " + energyBar.getValue());
            }
        });
        eTimer.start();
    }

    // Getters and setters for the progress bars' values

    public int getHealthValue() {
        return healthBar.getValue();
    }

    public void setHealthValue(int value) {
        healthBar.setValue(value);
        health.setText("Health: " + value);
    }

    public int getHungerValue() {
        return hungerBar.getValue();
    }

    public void setHungerValue(int value) {
        hungerBar.setValue(value);
        hunger.setText("Hunger: " + value);
    }

    public int getEnergyValue() {
        return energyBar.getValue();
    }

    public void setEnergyValue(int value) {
        energyBar.setValue(value);
        energy.setText("Energy: " + value);
    }

    // Getters and setters for the isDark property

    public boolean isDark() {
        return isDark;
    }

    public void setDark(boolean isDark) {
        this.isDark = isDark;
    }
}
