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
			unsortiert[i] = rn.nextInt(); 
	       System.out.println(unsortiert[i]);
	    }	
		
		System.out.println(" ");
		System.out.println("Sortiert nach Bubblesort: ");
		int[] sortiert = bubblesort(unsortiert);
		
		System.out.println(" ");
		System.out.println("Sortiert nach Insertionsort: ");
		int[] sortiert1 = insertionSort(unsortiert);
		
		System.out.println(" ");
		System.out.println("Sortiert nach Selectionsort: ");
		int[] sortiert2 = selectionsort(unsortiert);

		
		for (int i = 0; i < sortiert.length; i++) {
			System.out.print(sortiert[i] + ", ");
		}
		
		for (int i = 0; i < sortiert1.length; i++) {
			System.out.print(sortiert1[i] + ", ");
		}
		
		for (int i = 0; i < sortiert2.length; i++) {
			System.out.print(sortiert2[i] + ", ");
		}
	}	
		public static int[] bubblesort(int[] sortieren) {
			int temp;
			final long TIMESTART = System.nanoTime();
			for(int i=1; i<sortieren.length; i++) {
				for(int j=0; j<sortieren.length-i; j++) {
					if(sortieren[j]>sortieren[j+1]) {
						temp=sortieren[j];
						sortieren[j]=sortieren[j+1];
						sortieren[j+1]=temp;
					}
				}
			}
			final long timeEnd = System.nanoTime();
			System.out.println("Verlaufszeit der Schleife: " + (timeEnd - TIMESTART) + " ns");
			return sortieren;
		}
		
		public static int[] insertionSort(int[] sortieren) {
			int temp;
			final long timeStart = System.nanoTime();
			for (int i = 1; i < sortieren.length; i++) {
				temp = sortieren[i];
				int j = i;
				while (j > 0 && sortieren[j - 1] > temp) {
					sortieren[j] = sortieren[j - 1];
					j--;
				}
				sortieren[j] = temp;
			}
			final long timeEnd = System.nanoTime();
			System.out.println("Verlaufszeit der Schleife: " + (timeEnd - timeStart) + " ns");
			return sortieren;
		}
		
		public static int[] selectionsort(int[] sortieren) {
			final long timeStart = System.nanoTime();
			for (int i = 0; i < sortieren.length - 1; i++) {
				for (int j = i + 1; j < sortieren.length; j++) {
					if (sortieren[i] > sortieren[j]) {
						int temp = sortieren[i];
						sortieren[i] = sortieren[j];
						sortieren[j] = temp;
					}
				}
			}
			final long timeEnd = System.nanoTime();
			System.out.println("Verlaufszeit der Schleife: " + (timeEnd - timeStart) + " ns");
			return sortieren;
		}
	
}
