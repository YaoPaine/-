package com.yao.data.structure;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		int[] arr1 = new int[arr.length];
		// sort1(arr, 0, arr.length - 1, arr1);
		sort2(arr);
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * 归并排序的递归实现
	 * 
	 * @param array
	 * @param start
	 * @param end
	 * @param arr1
	 */
	private static void sort1(int[] array, int start, int end, int[] arr1) {
		if (start >= end)
			return;
		int middle = (start + end) / 2;
		sort1(array, start, middle, arr1);
		sort1(array, middle + 1, end, arr1);
		merge(array, start, middle, end, arr1);
	}

	private static void merge(int[] array, int start, int middle, int end, int[] arr1) {

		int index = 0;
		int left = start, right = middle + 1;

		while ((left <= middle) && (right <= end)) {
			if (array[left] < array[right]) {
				arr1[index++] = array[left++];
			} else {
				arr1[index++] = array[right++];
			}
		}

		while (left <= middle) {
			arr1[index++] = array[left++];
		}

		while (right <= end) {
			arr1[index++] = array[right++];
		}

		for (int i = 0; i < index; i++)
			array[start + i] = arr1[i];
	}

	/**
	 * 归并排序的非递归排序
	 */
	private static void sort2(int[] array) {
		int len = array.length;
		int k = 1;
		while (k < len) {
			sortMerge2(array, k, len);
			k *= 2;
		}
	}

	private static void sortMerge2(int[] array, int k, int len) {
		int i = 0;
		System.out.println("k: " + k + "\tlen: " + len + "\n" + Arrays.toString(array));
		while (i < len - 2 * k + 1) {
			merge(array, i, i + k - 1, i + 2 * k - 1);
			i += 2 * k;
		}
		if (i < len - k) {
			merge(array, i, i + k - 1, len - 1);
		}
	}

	private static void merge(int[] arr, int low, int mid, int high) {
		System.out.println("low: " + low + "\tmid: " + mid + "\thigh: " + high + "\n" + Arrays.toString(arr));
		// temp数组用于暂存合并的结果
		int[] temp = new int[high - low + 1];
		// 左半边的指针
		int i = low;
		// 右半边的指针
		int j = mid + 1;
		// 合并后数组的指针
		int k = 0;

		// 将记录由小到大地放进temp数组
		for (; i <= mid && j <= high; k++) {
			if (arr[i] < arr[j])
				temp[k] = arr[i++];
			else
				temp[k] = arr[j++];
		}

		// 接下来两个while循环是为了将剩余的（比另一边多出来的个数）放到temp数组中
		while (i <= mid)
			temp[k++] = arr[i++];

		while (j <= high)
			temp[k++] = arr[j++];

		// 将temp数组中的元素写入到待排数组中
		for (int l = 0; l < temp.length; l++)
			arr[low + l] = temp[l];
	}
}
