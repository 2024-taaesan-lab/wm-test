package com.example.demo.controller;


import com.example.demo.service.PathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PathController {

    @Autowired
    private PathService bfsPathService;

    @GetMapping("/shortest-path")
    public int findShortestPath(@RequestParam int[][] grid) {
        return 0;//bfsPathService.shortestPath(grid);
    }
}
