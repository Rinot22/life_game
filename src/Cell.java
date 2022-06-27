import java.util.ArrayList;

public class Cell {

    ArrayList<Cell> near;
    Status status;

    public Cell() {
        status = Status.NONE;
        near = new ArrayList<>();
    }

    void addNear(Cell cell) {
        near.add(cell);
    }

    void stepOne() {
        int around = countNearCells();
        status = status.stepOne(around);
    }

    void stepTwo() {
        status = status.stepTwo();
    }

    int countNearCells() {
        int count = 0;
        for (Cell cell : near)
            if (cell.status.isCell())
                count++;
            return count;
    }

    void turn() {
        for (Cell cell : near) {
            cell.status = cell.status.isCell() ? Status.NONE : Status.LIVE;
        }
    }
}
