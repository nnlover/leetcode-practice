package com.sort;

import java.util.List;

/**
 * @Author: wangzongyu
 * @Date: 2020/4/19 00:44
 */
public class InsertionSort {

	/**
	 * [1,7,8,13] 现在需要插入 6
	 * [1,7,8, ,13]
	 * [1,7, ,8,13]
	 * [1, ,7,8,13]
	 * [1,6,7,8,13]
	 *
	 * @param nums
	 */
	public void sort(int[] nums){

		for (int i =1; i<nums.length; i++){
			int val = nums[i];
			int j = i-1;
			while (j>=0){
				if(nums[j] > val){
					nums[j+1] = nums[i];
				}
				j--;
			}
			nums[j+1] = val;
		}
	}
}
