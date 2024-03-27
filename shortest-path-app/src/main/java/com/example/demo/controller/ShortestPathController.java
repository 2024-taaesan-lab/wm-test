package com.example.demo.controller;


import com.example.demo.dto.GridRequest;
import com.example.demo.model.Path;
import com.example.demo.service.PathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ShortestPathController {

    private final PathService pathService;

    @Autowired
    public ShortestPathController(@Qualifier("bfsPathServiceImpl") PathService pathService) {
        this.pathService = pathService;
    }

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
