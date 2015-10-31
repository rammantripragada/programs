import java.util.HashSet;
import java.util.Set;

public class FindRegions {

	private Set<String> visitedCells = new HashSet<String>();

	String getCellString(int i, int j) {
		return new String(Integer.toString(i) + Integer.toString(j));
	}

	boolean alreadyVisitedCell(int i, int j) {
		return getVisitedCells().contains(getCellString(i, j));
	}

	public Set<String> getVisitedCells() {
		return visitedCells;
	}

	public void setVisitedCells(Set<String> visitedCells) {
		this.visitedCells = visitedCells;
	}

	public int getTotalRegions(int array[][], int m, int n) {
		int numberOfRegions = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!alreadyVisitedCell(i, j)) {
					numberOfRegions++;

					processCell(array, m, n, i, j);
				}
			}
		}

		return numberOfRegions;

	}

	private void processCell(int[][] array, int m, int n, int i, int j) {

		getVisitedCells().add(getCellString(i, j));

		checkAndProcessUpCell(array, m, n, i, j);
		checkAndProcessDownCell(array, m, n, i, j);
		checkAndProcessLeftCell(array, m, n, i, j);
		checkAndProcessRightCell(array, m, n, i, j);

	}

	private void checkAndProcessRightCell(int[][] array, int m, int n, int i, int j) {
		if (j == n - 1 || alreadyVisitedCell(i, j + 1)) {
			return;
		}

		if (array[i][j] == array[i][j + 1]) {
			processCell(array, m, n, i, j + 1);
		}

	}

	private void checkAndProcessLeftCell(int[][] array, int m, int n, int i, int j) {
		if (j == 0 || alreadyVisitedCell(i, j - 1)) {
			return;
		}

		if (array[i][j] == array[i][j - 1]) {
			processCell(array, m, n, i, j - 1);
		}
	}

	private void checkAndProcessDownCell(int[][] array, int m, int n, int i, int j) {
		if (i == m - 1 || alreadyVisitedCell(i + 1, j)) {
			return;
		}

		if (array[i][j] == array[i + 1][j]) {
			processCell(array, m, n, i + 1, j);
		}

	}

	private void checkAndProcessUpCell(int[][] array, int m, int n, int i, int j) {

		if (i == 0 || alreadyVisitedCell(i - 1, j)) {
			return;
		}

		if (array[i][j] == array[i - 1][j]) {
			processCell(array, m, n, i - 1, j);
		}

	}

}
