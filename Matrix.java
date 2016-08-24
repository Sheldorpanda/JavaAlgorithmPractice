package algorithmPractice;

// Integer matrix class
public class Matrix {
	
	private int row;
	private int col;
	private int[][] matrix = new int[col][row];
	
	// Accessors and mutators
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	
	public int[][] getMatrix() {
		return matrix;
	}
	
	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}
	
	// Constructor
	public Matrix (int _col, int _row){
		this.col = _col;
		this.row = _row;
		this.matrix = new int[_col][_row];
	}
	
	public Matrix (int[][] _matrix) {
		this.matrix = _matrix;
		this.row = _matrix.length;
		this.col = _matrix[0].length;
	}
	
	// Get/set element
	public int getElement(int r, int c) {
		return this.matrix[c][r];
	}
	
	public void setElement(int r, int c, int e) {
		this.matrix[c][r] = e;
	}
	
	// To String
	@Override
	public String toString() {
		String retVal = "";
		for(int i = 0; i < this.col; i++) {
			for(int j = 0; j < this.row; j++) {
				retVal += this.getElement(j, i) + ", ";
			}
			retVal += '\n';
		}
		return retVal;
	}
}