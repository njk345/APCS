import java.util.*;
public class CharMatrix {
  private char[][] grid;

  //simple constructor for empty grid
  public CharMatrix(int rows, int cols) {
  	 grid = new char[rows][cols];
  }

  //constructor for grid filled with fillChar
  public CharMatrix(int rows, int cols, char fillChar)
  {
    grid = new char[rows][cols];
	for (char[] row : grid) {
		Arrays.fill(row, fillChar); //gotta use those built-in methods
	}
  }

  
  public int numRows()
  {
    return grid.length;
  }

  /**
   * Returns the number of columns in grid
   */
  public int numCols()
  {
    return grid[0].length;
  }

  /**
   * Returns the character at row, col location
   */
  public char charAt(int row, int col)
  {
   	return grid[row][col];
  }

  /**
   * Sets the character at row, col location to ch
   */
  public void setCharAt(int row, int col, char ch)
  {
    grid[row][col] = ch;
  }

  /**
   * Returns true if the character at row, col is a SPACE,
   * false otherwise
   */
  public boolean isEmpty(int row, int col)
  {
  	return grid[row][col] == ' ';
  }

  //Fills given rectangle that is subset of grid with char value fill
  public void fillRect(int row1, int col1, int row2 , int col2, char fill)
  {
	for (int row = row1; row <= row2; row++) {
		for (int col = col1; col <= col2; col++) {
			grid[row][col] = fill;
		}
	}	
  }

  //Clears Rectangle
  public void clearRect(int row1, int col1, int row2, int col2)
  {
    fillRect(row1, col1, row2, col2, ' ');
  }

  /**
   * Returns the count of all non-SPACE characters in row.
   */
  public int countInRow(int row)
  {
  	int notSpaces = 0;
	for (char c : grid[row]) {
		if (c != ' ') notSpaces++;
	}
	return notSpaces;
  }

  /**
   * Returns the count of all non-SPACE characters in col.
   */
  public int countInCol(int col)
  {
    int notSpaces = 0;
	for (char[] row : grid) {
		if (row[col] != ' ') notSpaces++;
	}
	return notSpaces++;
  }
}
