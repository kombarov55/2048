/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.command;

import model.Canvas;

public abstract class AbstractCommand implements CommandI {
    protected Canvas canvas;
    public boolean wasActionPreformed = false;

    AbstractCommand(Canvas canvas) {
        this.canvas = canvas;
    }

    protected void shift(int[] line) {
        for (int j = 0; j <= 2; j++) {
            int jj = j + 1;
            while (jj < 4) {
                if (line[jj] != 0)
                    break;
                jj++;
            }
            if (jj == 4 || line[jj] == 0)
                continue;


            if (line[j] == 0) {
                line[j] = line[jj];
                line[jj] = 0;
                j--;
                wasActionPreformed = true;
                continue;
            } else if (line[j] == line[jj]) {
                line[j] *= 2;
                line[jj] = 0;
                canvas.decreaseAmount();
                wasActionPreformed = true;

            }
        }
    }

    protected int[] reverseLine(int[] line) {
        int[] result = new int[line.length];
        for (int i = 0; i < line.length; i++) {
            result[line.length - 1 - i] = line[i];
        }
        return result;
    }
}
