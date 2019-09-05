#include <cstdlib>
#include <iostream>
#include <iomanip>
#include <fstream>

using namespace std;

// function for sorting the data
int[] sort (int[] array) {
	
	for (int i = 0; i < array.length-1; i++) {
		for (int j = 1; j < array.length-i-1; j++) {
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
float findMean(int[] array) {

	// create a sum that will add up all the elements
	float sum = 0.0;

	for (int i = 0; i < array.length; i++) {

		sum += array[i];

	}

	// return the sum divided by the number of elements
	return sum / array.length;
}

// function that finds the median
float findMedian (int[] array) {

	// create a variable to store the median in
	float median;

	if (array.length % 2 == 0) {

		// if array length is even, get average of middle 2 numbers
		median = (array[array.length/2] + array[array.length/2 + 1]) / 2

	}
	else {

		// if odd, median is the middle number
		median = array[(array.length + 1) / 2];

	}

	// return median
	return median;
}

// function that finds the mode
int findMode(int[] array) {

	// create a counter that keeps track of the current max number of repeat numbers
	int maxCount = 1;
	// keeps track of number of repeats of current number
	int count = 1;
	// holds value of the current modes
	int mode = array[0];

	for (int i = 0; i < array.length; i++) {
	
		// if the next number is not a repeat, compare count and maxCount
		if (array[i + 1] != array[i]) {

			// if count is larger, update maxCount and change the mode
			if (count >= maxCount) {

				maxCount = count;
				mode = array[i];

			}

		}
		else {

			// if repeat, increase count
			count++;

		}

	}

	// return mode
	return mode;
}

void printData(int[] array) {

	for (int i = 0; i < array.length; i++) {

		if (i == array.length - 1) {

			cout << array[i];

		}
		else {

			cout << array[i] << ", ";

		}
	}

}

int main() {

	// ifstream to read from text file
	ifstream input;
	// variable to count number of elements in the file
	int length = 0;

	input.open("Random Survey of 30 Male Heights.txt");

	while (input.getline) {

		length++;

	}

	input.close();

	// variable to hold the number taken from file
	int x;
	// array of the data collected from the file
	int data [length];

	input.open("Random Survey of 30 Male Heights.txt");

	while (input >> x) {

		for (int i = 0; i < length; i++) {

			data[i] = x;

		}

	}

	input.close();

	// data before sort
	printData(data);

	// sort the array
	data = sort(data);

	// data after sort
	printData(data);

	// get the mean, median, and mode
	float mean = findMean(data);
	float median = findMedian(data);
	int mode = findMode(data);

	// print the mean, median, and mode
	cout << "Mean: " << mean << endl;
	cout << "Median: " << median << endl;
	cout << "Mode: " << mode << endl;
}