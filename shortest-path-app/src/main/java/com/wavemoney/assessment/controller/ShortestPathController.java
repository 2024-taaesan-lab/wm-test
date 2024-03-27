package com.wavemoney.assessment.controller;


import com.wavemoney.assessment.dto.GridRequest;
import com.wavemoney.assessment.model.Path;
import com.wavemoney.assessment.service.PathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The ShortestPathController class handles requests related to finding the shortest path.
 * It maps HTTP requests to corresponding methods and delegates the processing to the PathService.
 */
@RestController
@RequestMapping("/api")
public class ShortestPathController {

    private final PathService pathService; // Service for finding the shortest path

    /**
     * Constructs a ShortestPathController with the specified PathService implementation.
     *
     * @param pathService The PathService implementation used for finding the shortest path.
     */
    @Autowired
    public ShortestPathController(@Qualifier("bfsPathServiceImpl") PathService pathService) {
        this.pathService = pathService;
    }

    /**
     * Handles HTTP POST requests to find the shortest path in a given grid.
     *
     * @param gridRequest The request body containing the 2D grid for which the shortest path is to be found.
     * @return A ResponseEntity containing the shortest path if found, or a bad request response if the grid is invalid.
     */
    @PostMapping(value="/shortest-path")
    public ResponseEntity<Path> findShortestPath(@RequestBody GridRequest gridRequest) {
        int[][] grid = gridRequest.getGrid();
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return ResponseEntity.badRequest().build();
        }

        Path path = pathService.findShortestPath(grid);
        return new ResponseEntity<>(path, HttpStatus.OK);
    }
}
