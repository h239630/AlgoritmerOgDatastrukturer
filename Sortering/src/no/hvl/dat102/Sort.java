package no.hvl.dat102;

import no.hvl.dat102.Koe.*;

public class Sort {

	// Sortering ved innsetting
	public static void byInsertion(Integer[] data) {
		for (int i = 1; i < data.length; i++) {
			int key = data[i];
			int pos = i;

			while (pos > 0 && data[pos - 1].compareTo(key) > 0) {
				data[pos] = data[pos - 1];
				pos--;
			}
			data[pos] = key;
		}

	}

	// Sortering ved utvalg
	public static void bySelection(Integer[] data) {
		int min;

		for (int index = 0; index < data.length - 1; index++) {
			min = index;
			for (int scan = index + 1; scan < data.length; scan++) {
				if (data[scan].compareTo(data[min]) < 0) {
					min = scan;
				}
			}
			swap(data, min, index);
		}
	}

	// Boblesortering
	public static void byBubble(Integer[] data) {
		for (int position = data.length - 1; position >= 0; position--) {
			for (int scan = 0; scan <= position - 1; scan++) {
				if (data[scan].compareTo(data[scan + 1]) > 0) {
					swap(data, scan, scan + 1);
				}
			}
		}
	}

	// Kvikksortering
	public static void byQuick(Integer[] data) {
		quickSort(data, 0, data.length - 1);
	}

	private static void quickSort(Integer[] data, int min, int max) {
		if (min < max) {
			int indexOfPartition = partition(data, min, max);
			quickSort(data, min, indexOfPartition - 1);
			quickSort(data, indexOfPartition + 1, max);
		}
	}

	private static int partition(Integer[] data, int min, int max) {
		Integer partitionElement;
		int left, right;
		int middle = (min + max) / 2;

		partitionElement = data[middle];

		swap(data, middle, min);
		left = min;
		right = max;

		while (left < right) {
			while (left < right && data[left].compareTo(partitionElement) <= 0) {
				left++;
			}
			while (data[right].compareTo(partitionElement) > 0) {
				right--;
			}
			if (left < right) {
				swap(data, left, right);
			}
		}
		swap(data, min, right);
		return right;

	}

	// Flettesortering
	public static void byMerge(Integer[] data) {
		mergeSort(data, 0, data.length - 1);
	}

	private static void mergeSort(Integer[] data, int min, int max) {
		if (min < max) {
			int middle = (min + max) / 2;
			mergeSort(data, min, middle);
			mergeSort(data, middle + 1, max);
			merge(data, min, middle, max);
		}
	}

	private static void merge(Integer[] data, int first, int middle, int last) {
		Integer[] temp = new Integer[data.length];

		int first1 = first;
		int last1 = middle;
		int first2 = middle + 1;
		int last2 = last;
		int index = first1;

		while (first1 <= last1 && first2 <= last2) {
			if (data[first1].compareTo(data[first2]) < 0) {
				temp[index] = data[first1];
				first1++;
			} else {
				temp[index] = data[first2];
				first2++;
			}
			index++;
		}
		while (first1 <= last1) {
			temp[index] = data[first1];
			first1++;
			index++;
		}
		while (first2 <= last2) {
			temp[index] = data[first2];
			first2++;
			index++;
		}
		for (index = first; index <= last; index++) {
			data[index] = temp[index];
		}

	}

	// Radix sortering
	public static void byRadix(Integer[] data) {
		Integer numObj;
		int digit, num;
		String temp;
		
		@SuppressWarnings("unchecked")
		KoeADT<Integer>[] digitQueues = (TabellKoe<Integer>[])(new TabellKoe[10]);
		for (int digitVal = 0; digitVal <= 9; digitVal++) {
			digitQueues[digitVal] = (KoeADT<Integer>) (new TabellKoe<Integer>());
		}
		
		for (int position = 0; position < 3; position++) {
			for (int scan = 0; scan < data.length; scan++) {
				temp = String.valueOf(data[scan]);
				digit = Character.digit(temp.charAt(2-position), 10);
				digitQueues[digit].innKoe(data[scan]);
			}
			num = 0; 
			for (int digitVal = 0; digitVal <= 9; digitVal++) {
				while (!(digitQueues[digitVal].erTom())) {
					numObj = digitQueues[digitVal].utKoe();
					data[num] = numObj.intValue();
					num++;
				}
			}
		}
	}

	// Helping methods
	private static void swap(Integer[] data, int index1, int index2) {
		int temp = data[index1];
		data[index1] = data[index2];
		data[index2] = temp;
	}

}
