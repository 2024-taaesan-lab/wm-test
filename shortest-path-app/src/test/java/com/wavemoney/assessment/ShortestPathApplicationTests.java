package com.wavemoney.assessment;

import com.wavemoney.assessment.model.Path;
import com.wavemoney.assessment.service.PathService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ShortestPathApplicationTests {

//	@Qualifier("bfsPathServiceImpl")
//  @Qualifier("aStarPathServiceImpl")
	@Autowired
	@Qualifier("bfsPathServiceImpl")
	private PathService pathService;

	@Test
	public void testPathNotFound() {

		int[][] grid = {
				{1, 0, 1},
				{1, 0, 1},
				{1, 0, 1}
		};

		Path path = pathService.findShortestPath(grid);
		System.out.println(path.getPath().size());
		assertEquals(0, path.getPath().size());
	}

	@Test
	public void testSGrid(){
		int[][] grid = {
				{1, 0, 1, 1, 1},
				{1, 1, 1, 0, 1},
				{0, 0, 1, 1, 1},
				{1, 1, 1, 0, 1},
				{1, 1, 1, 1, 1}
		};
		Path path = pathService.findShortestPath(grid);
		System.out.println(path.getPath().size());
		assertEquals(9, path.getPath().size());
//		for(Cell point: path.getPath()){
//			System.out.println(point.getRow() +" "+ point.getCol());
//		}
	}

	@Test
	public void testLGrid_1000x1000(){
		int[][] grid = new int[1000][1000];
		Arrays.setAll(grid, i -> {
			int[] row = new int[1000];
			Arrays.fill(row, 1);
			return row;
		});

		Path path = pathService.findShortestPath(grid);
		System.out.println(path.getPath().size());
		assertEquals(1999, path.getPath().size());

//		for(Cell point: path.getPath()){
//			System.out.println(point.getRow() +" "+ point.getCol());
//		}
	}

	@Test
	public void testXLGrid_5000x5000(){
		int[][] grid = new int[5000][5000];
		Arrays.setAll(grid, i -> {
			int[] row = new int[5000];
			Arrays.fill(row, 1);
			return row;
		});

		Path path = pathService.findShortestPath(grid);
		System.out.println(path.getPath().size());
		assertEquals(9999, path.getPath().size());

//		for(Cell point: path.getPath()){
//			System.out.println(point.getRow() +" "+ point.getCol());
//		}
	}



}
