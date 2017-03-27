package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Canvas {
    private int[][] matrix = new int[4][4];
    private int amount = 0;

    private List<Cell> field = new ArrayList<>();

    private void initField() {
        IntStream.range(0, 16).forEach(i -> field.add(new Cell()));
    }

    //Конструктор проводит инициализацию и заполняет две клеточки
    public Canvas() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = 0;
            }
        }
        setRandomPoint();
        setRandomPoint();
    }


    public void setPoint(int x, int y, int value) {
        matrix[y][x] = value;
        amount++;
    }


    public boolean isPointNew(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public int getPoint(int x, int y) {
        return matrix[y][x];
    }


    //Генерирует случайные координаты до тех пор, пока не попадёт в пустую клетку, дальше ставит там 2.

    public void setRandomPoint() {
        int x, y;
        do {
            x = (int) (Math.random() * 4);
            y = (int) (Math.random() * 4);
        } while (getPoint(x, y) != 0);
        setPoint(x, y, 2);
    }


    public int[] getRow(int index) {
        int[] result = new int[4];
        for (int i = 0; i < 4; i++) {
            result[i] = matrix[index][i];
        }
        return result;
    }


    public void setRow(int[] row, int index) {
        for (int i = 0; i < 4; i++) {
            matrix[index][i] = row[i];
        }
    }


    public int[] getColumn(int index) {
        int[] result = new int[4];
        for (int i = 0; i < 4; i++) {
            result[i] = matrix[i][index];
        }
        return result;
    }


    public void setColumn(int[] column, int index) {
        for (int i = 0; i < 4; i++) {
            matrix[i][index] = column[i];
        }
    }


    public int getAmount() {
        return amount;
    }


    public void decreaseAmount() {
        amount--;
    }


}
