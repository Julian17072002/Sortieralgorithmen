import java.util.Random;
import java.util.Scanner;

public class Sortieralgorithmen {
	
	static Random rn = new Random();

	
	public static void main(String[] args) {
		
		System.out.println("Sortieralgorithmen");
		System.out.println("==================");
		Scanner sc = new Scanner(System.in);
		System.out.println("Geben sie eine Natürliche Zahl für die Anzahl an Stellen in einem Array an: ");
		int x = sc.nextInt();
		int[] unsortiert = new int[x]; 
		sc.close();
		
		for (int i = 0; i < unsortiert.length; i++) {
			unsortiert[i] = rn.nextInt(500); 
	       System.out.print(unsortiert[i] +", ");
	    }	
		
		System.out.println(" ");
		System.out.println("Sortiert nach Bubblesort: ");
		final long timeStart = System.nanoTime();	
		int[] sortiert = bubblesort(unsortiert);
		final long timeEnd = System.nanoTime();
		System.out.println("Verlaufszeit der Schleife: " + (timeEnd - timeStart) + " ns");
		
		System.out.println(" ");
		System.out.println("Sortiert nach Insertionsort: ");
		final long timeStart1 = System.nanoTime();	
		int[] sortiert1 = insertionSort(unsortiert);
		final long timeEnd1 = System.nanoTime();
		System.out.println("Verlaufszeit der Schleife: " + (timeEnd1 - timeStart1) + " ns");
		
		System.out.println(" ");
		System.out.println("Sortiert nach Selectionsort: ");
		final long timeStart2 = System.nanoTime();
		int[] sortiert2 = selectionsort(unsortiert);
		final long timeEnd2 = System.nanoTime();
		System.out.println("Verlaufszeit der Schleife: " + (timeEnd2 - timeStart2) + " ns");
		
		System.out.println(" ");
		System.out.println("Sortiert nach Quicksort: ");
		final long timeStart3 = System.nanoTime();
		int[] sortiert3 = quicksort(unsortiert);
		final long timeEnd3 = System.nanoTime();
		System.out.println("Verlaufszeit der Schleife: " + (timeEnd3 - timeStart3) + " ns");
		System.out.println(" ");
		
		for (int i = 0; i < sortiert.length; i++) {

		}
		
		for (int i = 0; i < sortiert1.length; i++) {

		}
		
		for (int i = 0; i < sortiert2.length; i++) {

		}
		
		for (int i = 0; i < sortiert3.length; i++) {
		
			System.out.print(sortiert3[i] + ", ");
		}
	}	
		public static int[] bubblesort(int[] sortieren) {
			int temp;
			for(int i=1; i<sortieren.length; i++) {
				for(int j=0; j<sortieren.length-i; j++) {
					if(sortieren[j] > sortieren[j+1]) {
						temp=sortieren[j];
						sortieren[j]=sortieren[j+1];
						sortieren[j+1]=temp;
					}
				}
			}
			return sortieren;
		}
		
		public static int[] insertionSort(int[] sortieren) {
			int temp;
			for (int i = 1; i < sortieren.length; i++) {
				temp = sortieren[i];
				int j = i;
				while (j > 0 && sortieren[j - 1] > temp) {
					sortieren[j] = sortieren[j - 1];
					j--;
				}
				sortieren[j] = temp;
			}
			return sortieren;
		}
		
		public static int[] selectionsort(int[] sortieren) {
			for (int i = 0; i < sortieren.length - 1; i++) {
				for (int j = i + 1; j < sortieren.length; j++) {
					if (sortieren[i] > sortieren[j]) {
						int temp = sortieren[i];
						sortieren[i] = sortieren[j];
						sortieren[j] = temp;
					}
				}
			}
			return sortieren;
		}
		
		public static int[] quicksort(int[] sortieren) {
			_quicksort(0, sortieren.length - 1, sortieren);
			return sortieren;
		}
		
		private static void _quicksort(int leftIndex, int rightIndex, int[] sortieren) {
			if(leftIndex >= rightIndex) {
				return;
			}
			
			int i = leftIndex;
			int k = rightIndex;
			int pivot = sortieren[rightIndex];
			
			do {
				while(sortieren[i] <= pivot && i < rightIndex) {
					i++;
				}
				while(sortieren[k] >= pivot && k > leftIndex) {
					k--;
				}
				if(i < k) {
					int temp = sortieren[i];
					sortieren[i] = sortieren[k];
					sortieren[k] = temp;
				}
			} while(i < k);
			
			if(sortieren[i] > pivot) {
				int temp = sortieren[i];
				sortieren[i] = sortieren[rightIndex];
				sortieren[rightIndex] = temp;
			}
			
			_quicksort(leftIndex, i - 1, sortieren);
			_quicksort( i + 1, rightIndex, sortieren);
		}
}
