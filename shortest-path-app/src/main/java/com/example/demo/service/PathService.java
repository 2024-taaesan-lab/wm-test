package com.example.demo.service;

import com.example.demo.model.Path;
import com.example.demo.model.Cell;
import org.springframework.stereotype.Service;


import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This interface defines the contract for handling paths in the application.
 * Implementations of this interface should provide functionality related to path management.
 * <p>
 * Example usage:
 * <pre>{@code
 *     // Inject PathService into your components using @Autowired
 *     @Autowired
 *     private PathService pathService;
 * }</pre>
 * <p>
 * Note: Implementations of this interface should be annotated with \@Service.
 */
@Service
public interface PathService {
    public static int[][] DIRECTIONS = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public Path findShortestPath(int[][] grid);
}
