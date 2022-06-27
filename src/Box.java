import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Box extends JPanel {

    Cell cell;

    public Box(int x, int y) {
        super();
        cell = new Cell();
        setBounds(x * Configuration.SIZE, y * Configuration.SIZE, Configuration.SIZE, Configuration.SIZE);
        setBackground(Configuration.getColor(Status.NONE));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                cell.turn();
            }
        });
    }

    /*public void initCell(int x, int y) {
    }*/

    public void setColor() {
        setBackground(Configuration.getColor(cell.status));
    }

    void stepOne()  {
        cell.stepOne();
        setColor();
    }

    void stepTwo() {
        cell.stepTwo();
        setColor();
    }
}
