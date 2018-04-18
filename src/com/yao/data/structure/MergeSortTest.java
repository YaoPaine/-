package com.yao.demo.sort;

import java.util.Arrays;

public class MergeSortTest {

	public static void main(String[] args) {
		int[] arr = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		sort1(arr);
		System.out.println("排序后\n" + Arrays.toString(arr));
	}

	private static void sort1(int[] array) {
		mergeSort(array, 0, array.length - 1);
	}

	private static void mergeSort(int[] array, int start, int end) {
		if (start < end) {
			int middle = (start + end) / 2;
			mergeSort(array, start, middle);
			mergeSort(array, middle + 1, end);
			merge(array, start, middle, end);
		}
	}

	private static void merge(int[] array, int start, int middle, int end) {
		System.out
				.println("第start: " + start + "\tmiddle: " + middle + "\tend: " + end + "\n" + Arrays.toString(array));
		int[] newArray = new int[array.length];
		// 左半边指针
		int left = start;
		// 右半边指针
		int right = middle + 1;
		// 合并后数组的指针
		int index = 0;

		while (left <= middle && right <= end) {
			if (array[left] > (array[right])) {
				newArray[index++] = array[right++];
			} else {
				newArray[index++] = array[left++];
			}
		}

		while (left <= middle) {
			newArray[index++] = array[left++];
		}

		while (right <= end) {
			newArray[index++] = array[right++];
		}

		for (int i = 0; i < index; i++) {
			array[start + i] = newArray[i];
		}
		System.out.println(Arrays.toString(array));
	}

}
