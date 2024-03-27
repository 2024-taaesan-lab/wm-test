package com.wavemoney.assessment.service;

import com.wavemoney.assessment.model.Path;
import org.springframework.stereotype.Service;

/**
 * The PathService interface defines methods for finding the shortest path in a 2D grid.
 */
@Service
public interface PathService {

    /**
     * Array representing directions: right, down, left, up.
     * Each direction is represented by a pair of integers: [deltaRow, deltaCol].
     */
    public static int[][] DIRECTIONS = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    /**
     * Finds the shortest path from the top-left corner to the bottom-right corner of the 2D grid.
     *
     * @param grid The 2D grid represented as an array of integers.
     *             0 represents an obstacle that cannot be crossed,
     *             and 1 represents a cell that can be traversed.
     * @return A Path object representing the shortest path found in the grid.
     */
    public Path findShortestPath(int[][] grid);
}
