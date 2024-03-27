package com.wavemoney.assessment.service;

import com.wavemoney.assessment.model.Grid;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import com.wavemoney.assessment.model.Cell;
import com.wavemoney.assessment.model.Path;
import org.springframework.stereotype.Service;

@Service(value = "aStarPathServiceImpl")
public class AStarPathServiceImpl implements PathService {
    private final PriorityQueue<Cell> openList = new PriorityQueue<>(Comparator.comparingInt(Cell::getFScore));

    @Override
    public Path findShortestPath(int[][] gridParam) {
        Grid grid = new Grid(gridParam);
        int rows = grid.getRows();
        int cols = grid.getCols();
        boolean[][] closedList = new boolean[rows][cols];
        Cell[][] parent = new Cell[rows][cols];

        Cell start = new Cell(0, 0);
        start.setGScore(0);
        start.setHScore(getHeuristic(start, rows - 1, cols - 1)); // Heuristic to the goal
        start.setFScore(start.getGScore() + start.getHScore());

        openList.add(start);

        while (!openList.isEmpty()) {
            Cell current = openList.poll();

            if (current.getRow() == rows - 1 && current.getCol() == cols - 1) {
                return reconstructPath(current, parent);
            }

            closedList[current.getRow()][current.getCol()] = true;

            for (int[] direction : DIRECTIONS) {
                int newRow = current.getRow() + direction[0];
                int newCol = current.getCol() + direction[1];

                if (grid.isTraversable(newRow, newCol) && !closedList[newRow][newCol]) {
                    Cell neighbor = new Cell(newRow, newCol);
                    int tentativeGScore = current.getGScore() + 1; // Assuming a uniform cost of 1

                    // Check if this path is better than previously found paths
                    if (!openList.contains(neighbor) || tentativeGScore < neighbor.getGScore()) {
                        parent[newRow][newCol] = current;
                        neighbor.setGScore(tentativeGScore);
                        neighbor.setHScore(getHeuristic(neighbor, rows - 1, cols - 1));
                        neighbor.setFScore(neighbor.getGScore() + neighbor.getHScore());

                        if (!openList.contains(neighbor)) {
                            openList.add(neighbor);
                        }
                    }
                }
            }
        }

        return new Path(); // No path found
    }

    private int getHeuristic(Cell cell, int goalRow, int goalCol) {
        // Manhattan distance heuristic
        return Math.abs(cell.getRow() - goalRow) + Math.abs(cell.getCol() - goalCol);
    }

    private Path reconstructPath(Cell current, Cell[][] parent) {
        Path path = new Path();
        path.addPoint(current.getRow(), current.getCol());
        while (parent[current.getRow()][current.getCol()] != null) {
            current = parent[current.getRow()][current.getCol()];
            path.addPoint(current.getRow(), current.getCol());
        }
        Collections.reverse(path.getPath());
        return path;
    }
}
