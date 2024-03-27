package com.wavemoney.assessment.model;


import java.util.ArrayList;
import java.util.List;
/**
 * The Path class represents a path composed of cells in a grid or a map.
 * It provides methods to add points (cells) to the path and retrieve the entire path.
 */
public class Path {
    private List<Cell> path;

    /**
     * Constructs an empty path.
     */
    public Path() {
        path = new ArrayList<>();
    }

    /**
     * Adds a new point (cell) to the path with the given row and column indices.
     *
     * @param row The row index of the cell to be added to the path.
     * @param col The column index of the cell to be added to the path.
     */
    public void addPoint(int row, int col) {
        path.add(new Cell(row, col));
    }

    /**
     * Retrieves the entire path as a list of Cell objects.
     *
     * @return The list of Cell objects representing the path.
     */
    public List<Cell> getPath() {
        return path;
    }
}

