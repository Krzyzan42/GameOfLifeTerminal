import java.util.Random;

public class Map {
    private boolean[][] cells;
    public final int width, height;

    Map(int height, int width) {
        this.width = width;
        this.height = height;
        
        cells = new boolean[width][height];
        emptyMap();
    }

    public void emptyMap() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells[x][y] = false;
            }
        }
    }

    // Must be at least 5x5 big
    public void makeSpaceship() {
        emptyMap();
        
        cells[1][0] = true;
        cells[2][1] = true;
        cells[0][2] = true;
        cells[1][2] = true;
        cells[2][2] = true;
    }

    public void fillRandom() {
        Random r = new Random();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells[x][y] = r.nextBoolean();
            }
        }
    }

    public boolean isEmpty() {
        for (int x = 0; x < width; x++) 
            for (int y = 0; y < height; y++) 
                if(cells[x][y] == true) return false;
        return true;
    }

    public void draw() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if(cells[x][y] == true) {
                    System.out.print("O ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println("");
        }
        System.out.println("");
        System.out.println("");
    }

    public void debugDrawNeighbours() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print(getNumberOfNeighbors(x, y) + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    int getNumberOfNeighbors(int x, int y) {
        int[][] n = {
            {x-1, y-1},
            {x-1, y},
            {x-1, y+1},
            {x, y-1},
            {x, y+1},
            {x+1, y-1},
            {x+1, y},
            {x+1, y+1},
        };

        int neighbourNum = 0;
        for (int i = 0; i < 8; i++) {
            int nX = n[i][0];
            int nY = n[i][1];
            if(getCellLooped(nX, nY)) neighbourNum++;
        }
        return neighbourNum;
    }

    public void setCell(int x, int y, boolean alive) {
        cells[x][y] = alive;
    }

    public boolean getCellLooped(int x, int y) {
        x = x % width;
        if(x < 0) x += width;
        y = y % height;
        if(y < 0) y += height;

        return cells[x][y];
    }

    public boolean getCell(int x, int y) {
        return cells[x][y];
    }

}
