package Menu;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;
import net.miginfocom.swing.MigLayout;

public class MenuAnimation {
    public static void showMenu(Component component, MenuItem item, MigLayout layout, boolean show) {
        int height = component.getPreferredSize().height;

        int duration = 300; // Animation duration in milliseconds
        int steps = 50; // Number of animation steps

        int initialHeight = show ? 0 : height; // Initial height based on show parameter
        int finalHeight = show ? height : 0;   // Final height based on show parameter

        Timer timer = new Timer(duration / steps, new ActionListener() {
            private int step = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                step++;
                float fraction = (float) step / steps;
                int currentHeight = (int) (initialHeight + fraction * (finalHeight - initialHeight));

                // Set the component's bounds with the changing height
                component.setBounds(component.getX(), component.getY(), component.getWidth(), currentHeight);

                // Revalidate and repaint the component to reflect changes
                component.revalidate();
                component.repaint();

                // Stop the timer when the animation is complete
                if (step >= steps) {
                    ((Timer) e.getSource()).stop();
                }
            }
        });

        // Start the timer
        timer.start();
    }
}
