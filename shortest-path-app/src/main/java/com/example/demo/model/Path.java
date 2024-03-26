package com.example.demo.model;


import java.util.ArrayList;
import java.util.List;

public class Path {
    private List<Cell> path;

    public Path() {
        path = new ArrayList<>();
    }

    public void addPoint(int row, int col) {
        path.add(new Cell(row, col));
    }

    public List<Cell> getPath() {
        return path;
    }
}

