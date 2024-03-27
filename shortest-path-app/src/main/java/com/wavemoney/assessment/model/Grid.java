package com.wavemoney.assessment.model;

/**
 * The Grid class represents a 2D grid consisting of cells that can be traversed.
 * It provides methods to access grid properties and check if a cell is traversable.
 */
public class Grid {
    private int[][] grid; // 2D array representing the grid
    private int rows; // Number of rows in the grid
    private int cols; // Number of columns in the grid

    /**
     * Constructs a Grid object with the specified 2D array representing the grid.
     * Initializes rows and cols based on the dimensions of the grid array.
     *
     * @param grid The 2D array representing the grid.
     */
    public Grid(int[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
    }

    /**
     * Checks if a cell at the specified row and column indices is traversable.
     * A cell is traversable if it falls within the grid boundaries and has a value of 1.
     *
     * @param row The row index of the cell to check.
     * @param col The column index of the cell to check.
     * @return True if the cell is traversable, false otherwise.
     */
    public boolean isTraversable(int row, int col) {
        return 0 <= row && row < rows && 0 <= col && col < cols && grid[row][col] == 1;
    }

    /**
     * Retrieves the number of rows in the grid.
     *
     * @return The number of rows in the grid.
     */
    public int getRows() {
        return rows;
    }

    /**
     * Sets the number of rows in the grid.
     *
     * @param rows The number of rows to set.
     */
    public void setRows(int rows) {
        this.rows = rows;
    }

    /**
     * Retrieves the number of columns in the grid.
     *
     * @return The number of columns in the grid.
     */
    public int getCols() {
        return cols;
    }

    /**
     * Sets the number of columns in the grid.
     *
     * @param cols The number of columns to set.
     */
    public void setCols(int cols) {
        this.cols = cols;
    }
}

