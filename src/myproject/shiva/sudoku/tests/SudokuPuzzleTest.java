package myproject.shiva.sudoku.tests;

import junit.framework.Assert;
import myproject.shiva.sudoku.SudokuPuzzle;

import org.junit.Test;

public class SudokuPuzzleTest {

	@Test
	public void testGenerateNewGame() {
		SudokuPuzzle ss = new SudokuPuzzle();
		int[][] game = ss.generateNewGame(0);
		ss.printGame(game);
		Assert.assertEquals(3, game.length);
	}
	
	@Test
	public void testUniqueness() {
		boolean isUnique=true;
		SudokuPuzzle ss = new SudokuPuzzle();
		int[][] game = ss.generateNewGame(0); 
		for(int i=0;i<game.length;i++) {
			for(int j=0;j<game.length;j++) {
				if(isNumberExistsInRowX(game[i][j],i,j,game) && isNumberExistsInColY(game[i][j],i,j,game)) {
					isUnique = false;
					break;
				}
				if(!isUnique) break;
			}
		}
		Assert.assertEquals(true, isUnique);
	}

	
	private boolean isNumberExistsInRowX(int number,int x,int y,int[][] game) {
		for(int j=0;j<game.length;j++) {
			if(j==y) continue;
			if(game[x][j]==number)
				return true;
		}
		return false;
	}

	private boolean isNumberExistsInColY(int number,int x, int y,int[][] game) {
		for(int i=0;i<game.length;i++) {
			if(y==i) continue;
			if(game[i][y]==number)
				return true;
		}
		return false;
	}
	

}
