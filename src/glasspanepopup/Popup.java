package glasspanepopup;

import java.awt.AlphaComposite;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import net.miginfocom.swing.MigLayout;
import javax.swing.Timer;



public class Popup extends JComponent {

    private final GlassPanePopup parent;
    private final Component component;
    private final Option option;
    private Timer timer;
    private MigLayout layout;
    private float animate;
    private boolean show;
    private boolean mouseHover;

    public Popup(GlassPanePopup parent, Component component, Option option) {
        this.parent = parent;
        this.component = component;
        this.option = option;
        init();
        initAnimator();
    }

    private void init() {
        layout = new MigLayout();
        initOption();
        setLayout(layout);
        add(component, option.getLayout(parent.getLayerPane(), 0));
    }

    private void initOption() {
        if (option.closeWhenClickOutside()) {
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    mouseHover = true;
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    mouseHover = false;
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    if (mouseHover && SwingUtilities.isLeftMouseButton(e)) {
                        setShowPopup(false);
                    }
                }
            });
        } else if (option.blockBackground()) {
            addMouseListener(new MouseAdapter() {
            });
        }
        if (option.closeWhenPressedEsc()) {
            registerKeyboardAction(e -> setShowPopup(false), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
        }
    }

    private void initAnimator() {
        timer = new Timer(0, e -> {
            if (show) {
                animate += 0.1f;
            } else {
                animate -= 0.1f;
            }
            if (animate < 0) {
                animate = 0;
                timer.stop();
                // Perform end actions
                if (!show) {
                    parent.removePopup(Popup.this);
                }
                if (option.useSnapshot()) {
                    parent.contentPane.setVisible(true);
                    parent.windowSnapshots.removeSnapshot();
                }
            } else if (animate > 1) {
                animate = 1;
                timer.stop();
                // Perform end actions
            } else {
                float f = format(animate);
                option.setAnimate(f);
                String lc = option.getLayout(parent.getLayerPane(), f);
                if (lc != null) {
                    layout.setComponentConstraints(component, lc);
                }
                repaint();
                revalidate();
            }
        });
        timer.setDelay(option.duration() / 100);
    }

    public void setShowPopup(boolean show) {
        if (this.show != show) {
            if (timer.isRunning()) {
                timer.stop();
            }
            this.show = show;
            timer.start();
            if (!show) {
                uninstallOption();
            }
        }
    }

    private void uninstallOption() {
        if (getMouseListeners().length != 0) {
            removeMouseListener(getMouseListeners()[0]);
        }
        if (option.closeWhenPressedEsc()) {
            unregisterKeyboardAction(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setComposite(AlphaComposite.SrcOver.derive(animate * option.opacity()));
        g2.setColor(option.background());
        g2.fill(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
        g2.setComposite(AlphaComposite.SrcOver.derive(animate));
        super.paintComponent(g);
    }

    private float format(float v) {
        int a = Math.round(v * 100);
        return a / 100f;
    }
}
