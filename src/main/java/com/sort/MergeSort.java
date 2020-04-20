package com.sort;

/**
 * @Author: wangzongyu
 * @Date: 2020/4/19 01:01
 */
public class MergeSort {

	public void mergeSort(int[] nums, int l, int r) {
		if (l >= r) {
			return;
		}
		int mid = l + (r - l) / 2;
		mergeSort(nums, l, mid);
		mergeSort(nums, mid + 1, r);
		int tp[] = new int[r - l];
		int k = l;
		int p = l;
		int q = mid;
		while (p < mid || q < r) {
			if (q >= r || (p < mid && nums[p] <= nums[q])) {
				tp[k] = nums[p];
				k++;
				p++;
			} else {
				tp[k] = nums[q];
				k++;
				q++;
			}
		}
		for (int i = l; i < r; i++) {
			nums[i] = tp[i];
		}
	}
}
