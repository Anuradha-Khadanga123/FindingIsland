package com.findingIslands;

public class NumberOfIslandsImpl {

	public int countNumberOfIslands(int mat[][]) {

		int totalIslands = 0;

		int numOfRows = mat.length;

		int numOfCols = mat[0].length;

		boolean visited[][] = new boolean[numOfRows][numOfCols];

		for (int r = 0; r < numOfRows; r++) {// r for rows

			for (int c = 0; c < numOfCols; c++) { // c for columns

				if (mat[r][c] == 1 && !visited[r][c]) {

					DFS(mat, r, c, visited);

					totalIslands++;
				}

			}
		}

		return totalIslands;

	}

	private void DFS(int[][] mat, int row, int col, boolean[][] visited) {

		int connectedRows[] = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
		int connectedCols[] = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };

		visited[row][col] = true;

		for (int n = 0; n < 8; n++) {

			int i = row + connectedRows[n];
			int j = col + connectedCols[n];

			if ((i >= 0) && (i < mat.length) && (j >= 0) && (j < mat[i].length) && (mat[i][j] == 1 && !visited[i][j])) {

				DFS(mat, i, j, visited);
			}
		}

	}

	public static void main(String[] args) {

		int bigMat[][] = { { 1, 1, 0, 1, 0, 1, 1, 1, 1 }, { 0, 1, 0, 1, 0, 1, 0, 0, 0 }, { 1, 0, 0, 0, 1, 1, 0, 1, 1 },
				{ 0, 0, 0, 0, 0, 1, 0, 0, 1 }, { 1, 1, 1, 0, 0, 1, 1, 1, 1 }, { 0, 0, 0, 1, 0, 1, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 1, 1, 1 }, { 0, 1, 0, 1, 0, 1, 1, 0, 1 } };

		int smallMat[][] = { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 },
				{ 1, 0, 1, 0, 1 } };
		
		

		NumberOfIslandsImpl i = new NumberOfIslandsImpl();

		System.out.println("The number of islands present in big map is : " + i.countNumberOfIslands(bigMat));

		System.out.println("The number of islands present in small map is : " + i.countNumberOfIslands(smallMat));

	}

}
