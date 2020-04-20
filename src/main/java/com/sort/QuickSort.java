package com.sort;

/**
 * @Author: wangzongyu
 * @Date: 2020/4/19 00:44
 */
public class QuickSort {

	void quickSort(int[] nums, int low, int high){
		if (low >= high){
			return;
		}
		int key = nums[low];
		int i=low;
		int j=high;
		while (i < j){

			while (nums[j] >= key && j>i){
				j--;
			}
			nums[i] = nums[j];
			while (i< j && nums[i] <= key){
				i++;
			}
			nums[j] = nums[i];
		}
		quickSort(nums, low, i-1);
		quickSort(nums, i+1, high);
	}
}
