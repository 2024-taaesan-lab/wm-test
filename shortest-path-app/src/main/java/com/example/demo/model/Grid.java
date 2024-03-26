package com.example.demo.model;

public class Grid {
    private int[][] grid;
    private int rows;
    private int cols;

    public Grid(int[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
    }

    public boolean isTraversable(int row, int col) {
        return 0 <= row && row < rows && 0 <= col && col < cols && grid[row][col] == 1;
    }
}
