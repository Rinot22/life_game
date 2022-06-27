import java.awt.*;

public class Configuration {
    public static final int SIZE = 10;
    public static final int WIDTH = 80;
    public static final int HEIGHT = 60;
    public static final int SLEEP_MS = 100;

    public static Color getColor(Status status) {
        switch (status) {
            case NONE:
                return Color.BLACK;
            case BORN:
                return Color.GREEN;
            case LIVE:
                return Color.YELLOW;
            case DEAD:
                return Color.PINK;
            default:
                return Color.CYAN;
        }
    }
}
