package com.example.demo.service;

import com.example.demo.model.Cell;
import com.example.demo.model.Grid;
import com.example.demo.model.Path;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

@Service(value = "bfsPathServiceImpl")
public class BFSPathServiceImpl implements PathService {
    public Path findShortestPath(int[][] gridParam) {
        Grid grid = new Grid(gridParam);
        int rows = grid.getRows();
        int cols = grid.getCols();
        boolean[][] visited = new boolean[rows][cols];
        Queue<Cell> queue = new LinkedList<>();
        queue.add(new Cell(0, 0));
        visited[0][0] = true;
        Cell parent[][] = new Cell[rows][cols];

        while (!queue.isEmpty()) {
            Cell current = queue.poll();

            // Last cell, The bottom-right corner
            if (current.getRow() == rows - 1 && current.getCol() == cols - 1) {
                // Reconstruct path from parent array
                Path path = new Path();
                path.addPoint(current.getRow(), current.getCol());
                while (current.getRow() > 0 || current.getCol() > 0) {
                    current = parent[current.getRow()][current.getCol()];
                    path.addPoint(current.getRow(), current.getCol());
                }
                Collections.reverse(path.getPath());
                return path;
            }

            // Search cell by 4 directions
            for (int[] direction : DIRECTIONS) {
                int newRow = current.getRow() + direction[0];
                int newCol = current.getCol() + direction[1];
                if (grid.isTraversable(newRow, newCol) && !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    queue.add(new Cell(newRow, newCol));
                    parent[newRow][newCol] = current;
                }
            }
        }

        return new Path(); // No path found
    }
}
