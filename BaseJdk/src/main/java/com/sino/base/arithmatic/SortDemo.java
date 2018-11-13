package com.sino.base.arithmatic;

import java.util.Arrays;

/**
 * 排序
 *
 *
 *
 * 
 */
public class SortDemo {

	static int[] code = { 9, 8, 7, 6, 5, 4, 3, 4, 5, 6, 7, 8, 9, 0, 23, 432, 0, 0 };

	public static void main(String[] args) {

		// outputArr(code);
		// int[] ints = new SortDemo().bubbleSort(code);
		// int[] ints2 = new SortDemo().bubbleSortOpt(code);
		int[] ints2 = new SortDemo().selectSort(code);

		outputArr(ints2);
	}

	/**
	 * 冒泡排序
	 *
	 * @param arr
	 * @return
	 */
	private int[] bubbleSort(int[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {

			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
				}

			}

		}

		return arr;
	}

	/**
	 * 冒泡排序-优化
	 *
	 * @param arr
	 * @return
	 */
	private int[] bubbleSortOpt(int[] arr) {
		boolean flag = false;

		for (int i = 0; i < arr.length - 1; i++) {

			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
					flag = true;
				}

			}

			if (!flag) {
				break;
			}

		}

		return arr;

	}

	/**
	 * 选择排序
	 * 
	 * @param arr
	 * @return
	 */
	public int[] selectSort(int[] arr) {
		int len = arr.length;
		int minIndex, temp;
		for (int i = 0; i < len - 1; i++) {
			minIndex = i;
			for (int j = i + 1; j < len; j++) {
				if (arr[j] < arr[minIndex]) { // 寻找最小的数
					minIndex = j; // 将最小数的索引保存
				}
			}
			arr[i] ^= arr[minIndex];
			arr[minIndex] ^= arr[i];
			arr[i] ^= arr[minIndex];

		}
		return arr;

	}

	private static void outputArr(int[] arr) {
		String s = Arrays.toString(arr);
		System.out.println(s);
	}

}
