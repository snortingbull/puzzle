package myproject.shiva.sudoku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SudokuPuzzle {
	private final int GRID_SIZE= 3;
	private int[][] game = new int[GRID_SIZE][GRID_SIZE];
	
	public static void main(String arg[]) {
		SudokuPuzzle ss = new SudokuPuzzle();
		printGame(ss.generateNewGame(0));
	}

	public static void printGame(int[][] game) {
		for(int i=0;i<game.length;i++) {
    		for(int j=0;j<game.length;j++) {
    			System.out.print(game[i][j]);
    			System.out.print(" ");
    		}
    		System.out.println();
    	}
		
	}

	public int[][] generateNewGame(int index) {
		
		if(index > ((GRID_SIZE * GRID_SIZE) -1)) {
			return game;
		}
		int x = index / GRID_SIZE;
		int y = index % GRID_SIZE;
		
		List<Integer> numbers = new ArrayList<Integer>();
		
		for(int i=1;i<=GRID_SIZE * GRID_SIZE ; i++) {
			numbers.add(i);
		}
		Collections.shuffle(numbers);
		getPossibleNumber(x,y,numbers);
		
		generateNewGame(index+1);
		return game;
	}

	private void getPossibleNumber(int x, int y,List<Integer> numbers) {
		
		int number = numbers.remove(0);
		if(!isNumberExistsInRowX(number,x) && !isNumberExistsInColY(number,y)  && !isNumberInGrid(x,y,number)) {
			game[x][y] = number;
		}else {
			getPossibleNumber(x, y, numbers);
		}
		
	}


	private boolean isNumberInGrid(int x, int y, int number) { 
		 for (int row = (x / 3) * 3; row < (x / 3) * 3 + 3; row++)
		      for (int col = (y / 3) * 3; col < (y / 3) * 3 + 3; col++)
		        if (row != y && col != y && game[row][col] == game[x][y])
		          return false;

		    return true; 
	}

	private boolean isNumberExistsInRowX(int number,int x) {
		for(int y=0;y<game.length;y++) {
			if(game[x][y]==number)
				return true;
		}
		return false;
	}

	private boolean isNumberExistsInColY(int number,int y) {
		for(int x=0;x<game.length;x++) {
			if(game[x][y]==number)
				return true;
		}
		return false;
	}

}
