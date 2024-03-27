package com.wavemoney.assessment.model;

import java.util.Objects;

/**
 * The Cell class represents a single cell in a grid or a map.
 * It stores information about the cell's position, scores, and parent cell for pathfinding algorithms.
 */
public class Cell {
    private final int row; // Row index of the cell
    private final int col; // Column index of the cell
    private int gScore; // Distance from start
    private int hScore; // Heuristic estimate of distance to goal
    private int fScore; // gScore + hScore
    private Cell parent; // Parent cell

    /**
     * Constructs a Cell object with the specified row and column indices.
     *
     * @param row The row index of the cell.
     * @param col The column index of the cell.
     */
    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * Retrieves the row index of the cell.
     *
     * @return The row index of the cell.
     */
    public int getRow() {
        return row;
    }

    /**
     * Retrieves the column index of the cell.
     *
     * @return The column index of the cell.
     */
    public int getCol() {
        return col;
    }

    /**
     * Retrieves the gScore of the cell.
     *
     * @return The gScore of the cell.
     */
    public int getGScore() {
        return gScore;
    }

    /**
     * Sets the gScore of the cell.
     *
     * @param gScore The gScore to set.
     */
    public void setGScore(int gScore) {
        this.gScore = gScore;
    }

    /**
     * Retrieves the hScore of the cell.
     *
     * @return The hScore of the cell.
     */
    public int getHScore() {
        return hScore;
    }

    /**
     * Sets the hScore of the cell.
     *
     * @param hScore The hScore to set.
     */
    public void setHScore(int hScore) {
        this.hScore = hScore;
    }

    /**
     * Retrieves the fScore of the cell.
     *
     * @return The fScore of the cell.
     */
    public int getFScore() {
        return fScore;
    }

    /**
     * Sets the fScore of the cell.
     *
     * @param fScore The fScore to set.
     */
    public void setFScore(int fScore) {
        this.fScore = fScore;
    }

    /**
     * Retrieves the parent cell of the current cell.
     *
     * @return The parent cell of the current cell.
     */
    public Cell getParent() {
        return parent;
    }

    /**
     * Sets the parent cell of the current cell.
     *
     * @param parent The parent cell to set.
     */
    public void setParent(Cell parent) {
        this.parent = parent;
    }

    /**
     * Overrides the equals method for efficient comparison in priority queue.
     *
     * @param o The object to compare.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return row == cell.row && col == cell.col;
    }

    /**
     * Overrides the hashCode method for consistent hashing with equals.
     *
     * @return The hash code of the cell.
     */
    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}
