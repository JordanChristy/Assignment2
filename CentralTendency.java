import java.util.*;
import java.io.*;
import java.math.*;

public class CentralTendency {
	
	
	// function for sorting the data
	static int[] sort (int[] array) {
		
		for (int i = 0; i < array.length-1; i++) {
			for (int j = 0; j < array.length-i-1; j++) {
				// if current number is greater than next number, switch them
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}

		// return sorted array
		return array;
	}

	// function that finds the mean
	static double findMean(int[] array) {

		// create a sum that will add up all the elements
		double sum = 0.0;

		for (int i = 0; i < array.length; i++) {

			sum += array[i];

		}

		// return the sum divided by the number of elements
		return sum / array.length;
	}

	// function that finds the median
	static double findMedian (int[] array) {

		// create a variable to store the median in
		double median;

		if (array.length % 2 == 0) {

			// if array length is even, get average of middle 2 numbers
			median = (array[array.length/2] + array[array.length/2 + 1]) / 2;

		}
		else {

			// if odd, median is the middle number
			median = array[(array.length + 1) / 2];

		}

		// return median
		return median;
	}

	// function that finds the mode
	static int findMode(int[] array) {

		// create a counter that keeps track of the current max number of repeat numbers
		int maxCount = 1;
		// keeps track of number of repeats of current number
		int count = 1;
		// holds value of the current modes
		int mode = array[0];

		for (int i = 0; i < array.length-1; i++) {
		
			// if the next number is not a repeat, compare count and maxCount
			if (array[i + 1] != array[i]) {

				// if count is larger, update maxCount and change the mode
				if (count >= maxCount) {

					maxCount = count;
					count = 1;
					mode = array[i];
					
				}
				else{
					
					count = 1;
					
				}

			}
			else {

				// if repeat, increase count
				count++;
				if (count >= maxCount) {

					maxCount = count;
					mode = array[i];
					
				}

			}

		}

		// return mode
		return mode;
	}

	static void printData(int[] array) {

		for (int i = 0; i < array.length; i++) {

			if (i == array.length - 1) {

				System.out.print(array[i]+ "\n");

			}
			else {

				System.out.print(array[i] + ", ");

			}
		}

	}
	
public static void main(String[] args) throws FileNotFoundException {
		
		// Scanner to read text file
		Scanner input = new Scanner(new File("C:/Random Survey of 30 Male Heights.txt"));
		System.out.println("got file");
		// variable to count number of elements in the file
		int length = 0;

		while (input.hasNextLine()) {

			length++;
			System.out.println(input.nextLine());

		}
		
		// check length
		System.out.println("Length: " + length + "\n");

		// array of the data collected from the file
		int[] data = new int[length];

		input = new Scanner(new File("C:/Random Survey of 30 Male Heights.txt"));

		for (int i = 0; i < length; i++) {

			String value = input.nextLine();
			data[i] = Integer.parseInt(value);

		}


		input.close();

		// data before sort
		printData(data);

		// sort the array
		data = sort(data);

		// data after sort
		printData(data);

		// get the mean, median, and mode
		double mean = findMean(data);
		double median = findMedian(data);
		int mode = findMode(data);

		// print the mean, median, and mode
		System.out.println("Mean: " + mean);
		System.out.println("Median: " + median);
		System.out.println("Mode: " + mode);

	}

}
