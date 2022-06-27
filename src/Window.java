import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window implements Runnable{

    JFrame frame;
    Box[][] boxes;

    @Override
    public void run() {
        initFrame();
        initBox();
        initTimer();
    }

    void initFrame() {
        frame = new JFrame();
        frame.getContentPane().setLayout(null);
        frame.setSize(Configuration.SIZE * Configuration.WIDTH - 20, Configuration.SIZE * Configuration.HEIGHT - 25);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("Life game");
    }

    void initBox() {
        boxes = new Box[Configuration.WIDTH][Configuration.HEIGHT];
        for (int x = 0; x < Configuration.WIDTH; x++) {
            for (int y = 0; y < Configuration.HEIGHT; y++) {
                boxes[x][y] = new Box(x, y);
                frame.add(boxes[x][y]);
            }
        }

        for (int x = 0; x < Configuration.WIDTH; x++) {
            for (int y = 0; y < Configuration.HEIGHT; y++) {
                for (int sx = -1; sx <= 1; sx++) {
                    for (int sy = -1; sy <= 1; sy++) {
                        if (!(sx == 0 && sy == 0))
                            boxes[x][y].cell.addNear(boxes
                                    [(x + sx + Configuration.WIDTH) % Configuration.WIDTH]
                                    [(y + sy + Configuration.HEIGHT) % Configuration.HEIGHT].cell);
                    }
                }
            }
        }
    }

    private void initTimer() {
        TimerListener t1 = new TimerListener();
        Timer timer = new Timer(Configuration.SLEEP_MS, t1);
        timer.start();
    }

    private class TimerListener implements ActionListener {
        boolean flop = false;   // hz

        @Override
        public void actionPerformed(ActionEvent e) {
            flop = !flop;   // hz
            for (int x = 0; x < Configuration.WIDTH; x++)
                for (int y = 0; y < Configuration.HEIGHT; y++) {
                    if (flop)   // hz
                        boxes[x][y].stepOne();
                    else        // hz
                        boxes[x][y].stepTwo();
                }
        }
    }
}
