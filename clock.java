import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GraphicalClock extends JPanel implements ActionListener {

    private static final int RADIUS = 100;
    private static final int MARGIN = 20;

    private Timer timer;

    public GraphicalClock() {
        setPreferredSize(new Dimension(2 * RADIUS + 2 * MARGIN, 2 * RADIUS + 2 * MARGIN));
        setBackground(Color.WHITE);

        timer = new Timer(1000, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the clock face
        g.setColor(Color.BLACK);
        g.fillOval(MARGIN, MARGIN, 2 * RADIUS, 2 * RADIUS);

        // Draw the hours and minutes marks
        for (int i = 0; i < 12; i++) {
            double angle = Math.PI * 2 * i / 12;
            int x = (int) (RADIUS * Math.cos(angle)) + RADIUS + MARGIN;
            int y = (int) (RADIUS * Math.sin(angle)) + RADIUS + MARGIN;
            g.drawLine(x, y, x - 10, y);
        }

        for (int i = 0; i < 60; i++) {
            if (i % 5 == 0) continue;
            double angle = Math.PI * 2 * i / 60;
            int x = (int) (RADIUS * Math.cos(angle)) + RADIUS + MARGIN;
            int y = (int) (RADIUS * Math.sin(angle)) + RADIUS + MARGIN;
            g.drawLine(x, y, x - 5, y);
        }

        // Get the current time
        LocalTime time = LocalTime.now();

        // Draw the hour hand
        double hourAngle = Math.PI * 2 * time.getHour() / 12 + Math.PI * 2 * time.getMinute() / 720;
        int hourX = (int) (RADIUS * Math.cos(hourAngle)) + RADIUS + MARGIN;
        int hourY = (int) (RADIUS * Math.sin(hourAngle)) + RADIUS + MARGIN;
        g.setColor(Color.BLACK);
        g.drawLine(RADIUS + MARGIN, RADIUS + MARGIN, hourX, hourY);

        // Draw the minute hand
        double minuteAngle = Math.PI * time.getMinute() / 30;
        int minuteX = (int) (RADIUS * Math.cos(minuteAngle)) + RADIUS + MARGIN;
        int minuteY = (int) (RADIUS * Math.sin(minuteAngle)) + RADIUS + MARGIN;
        g.setColor(Color.RED);
        g.drawLine(RADIUS + MARGIN, RADIUS + MARGIN, minuteX, minuteY);

        // Draw the center dot
        g.setColor(Color.BLACK);
        g.fillOval(RADIUS + MARGIN - 5, RADIUS + MARGIN - 5, 10, 10);

        //
