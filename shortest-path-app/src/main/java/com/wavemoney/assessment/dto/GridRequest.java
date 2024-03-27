package com.wavemoney.assessment.dto;

/**
 * The GridRequest class represents a request object containing a 2D grid.
 * It provides methods to retrieve and set the grid data.
 */
public class GridRequest {
    private int[][] grid; // 2D array representing the grid

    /**
     * Retrieves the 2D array representing the grid.
     *
     * @return The 2D array representing the grid.
     */
    public int[][] getGrid() {
        return grid;
    }

    /**
     * Sets the 2D array representing the grid.
     *
     * @param grid The 2D array representing the grid to set.
     */
    public void setGrid(int[][] grid) {
        this.grid = grid;
    }
}
