
public class UtilityTester {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int array[][] = { { 1, 1, 1, 1, 1 }, 
						  { 2, 3, 3, 1, 1 }, 
				          { 2, 1, 4, 4, 1 } };
		FindRegions regionFinder = new FindRegions();

		System.out.println("Total number of regions in array " + regionFinder.getTotalRegions(array, 3, 5));

	}

}
