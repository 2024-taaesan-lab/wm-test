package com.example.demo.service;

import com.example.demo.model.Path;
import com.example.demo.model.Cell;
import org.springframework.stereotype.Service;


import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

@Service
public class PathService {
    private static int[][] DIRECTIONS = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public Path findShortestPath(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Queue<Cell> queue = new LinkedList<>();
        queue.add(new Cell(0, 0));
        visited[0][0] = true;
        Cell parent[][] = new Cell[rows][cols];

        while (!queue.isEmpty()) {
            Cell current = queue.poll();
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

            for (int[] direction : DIRECTIONS) {
                int newRow = current.getRow() + direction[0];
                int newCol = current.getCol() + direction[1];
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
                        && !visited[newRow][newCol] && grid[newRow][newCol] == 1) {
                    visited[newRow][newCol] = true;
                    queue.add(new Cell(newRow, newCol));
                    parent[newRow][newCol] = current;
                }
            }
        }

        return new Path(); // No path found
    }
}
