package com.wavemoney.assessment.controller;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import com.wavemoney.assessment.dto.GridRequest;
import com.wavemoney.assessment.model.Path;
import com.wavemoney.assessment.service.PathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.PresentationDirection;
import java.util.concurrent.TimeUnit;

/**
 * The ShortestPathController class handles requests related to finding the shortest path.
 * It maps HTTP requests to corresponding methods and delegates the processing to the PathService.
 */
@RestController
@RequestMapping
public class ShortestPathController {

    @Autowired
    @Qualifier("bfsPathServiceImpl")
    private PathService pathService; // Service for finding the shortest path

    private MeterRegistry registry;
    @Autowired
    public ShortestPathController(MeterRegistry meterRegistry) {

        this.registry = meterRegistry;

        Timer timer = registry.timer("Time for operation");
        timer.record(() -> {
            int sum = 0;
            for (int i = 0; i <= 1000; i++) {
                sum += i;
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Handles HTTP POST requests to find the shortest path in a given grid.
     *
     * @param gridRequest The request body containing the 2D grid for which the shortest path is to be found.
     * @return A ResponseEntity containing the shortest path if found, or a bad request response if the grid is invalid.
     */
    @PostMapping(value="/shortest-path")
    public ResponseEntity<Path> findShortestPath(@RequestBody GridRequest gridRequest) {
        Timer.Sample sample = Timer.start(registry);

        int[][] grid = gridRequest.getGrid();
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return ResponseEntity.badRequest().build();
        }

        Path path = pathService.findShortestPath(grid);
        sample.stop(registry.timer("my.timer", "response", "OK"));
        return new ResponseEntity<>(path, HttpStatus.OK);
    }
}
