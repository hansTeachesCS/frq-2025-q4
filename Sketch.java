import processing.core.PApplet;

public class Sketch extends PApplet {
    Cell[][] grid;
    int numRows = 10;
    int numCols = 10;

    public void settings() {
        size(650, 650);
    }

    public void setup() {
        background(210);
        grid = new Cell[10][10];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                grid[row][col] = new Cell();
            }
        }
        for (Cell[] row : grid) {
            for (Cell c : row) {
                System.out.print(c + ", ");
            }
            System.out.println();
        }
    }

    public void draw() {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                fill(grid[row][col].getFill());
                if (grid[row][col].getValue() == 0) {
                    fill(255);
                } else if (grid[row][col].getValue() == -1) {
                    fill(255, 0, 0);
                }
                rect(col*60, row*60, 60, 60);
                fill(255);
                if (grid[row][col].getValue() != -1) {
                    textSize(30);
                    text(grid[row][col].getValue(), col*60+25, row*60+40);
                } else {
                    textSize(20);
                    text("GAME", col*60+7, row*60+23);
                    text("OVER", col*60+8, row*60+48);
                }
            }
        }
    }

    public void updateBoard(int x, int y, boolean match) {
        if (match) {
            grid[x][y].setValue(0);
        } else {
            grid[x][y].setValue(-1);
        }
        

    }

    public boolean findPair(int x, int y) {
        for (int row = x; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (row != x || col != y) {
                    System.out.println(row + " " + col + ": " + grid[row][col].getValue());
                    if (grid[x][y].getValue() == grid[row][col].getValue() || grid[x][y].getValue() + grid[row][col].getValue() == 10) {
                        updateBoard(row, col, true);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void mouseClicked() {
        if (findPair((int)(mouseY/60), (int)(mouseX/60))) {
            updateBoard((int)(mouseY/60), (int)(mouseX/60), true);
        } else {
            updateBoard((int)(mouseY/60), (int)(mouseX/60), false);
        }
        
        
        // System.out.println(mouseX + " " + mouseY);
        // System.out.println(mouseX/120 + " " + mouseY/120);
    }
}
