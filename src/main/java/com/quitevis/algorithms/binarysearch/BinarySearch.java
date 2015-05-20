package com.quitevis.algorithms.binarysearch;

/**
 * Created by lordbritishix on 13/05/15.
 */
public class BinarySearch {
    public int getMinFromRotatedSortedArray(int[] input) {
        int left = 0;
        int right = input.length - 1;
        int mid = -1;

        while (left <= right) {
            mid = left + ((right - left) / 2);

            //If the left subarray is not sorted, it means the pivot is
            //on the left subarray
            if (input[left] > input[mid]) {
                right = mid;
            }
            //If the right subarray is not sorted, it means the pivot is
            //on the right subarray
            else if (input[left] < input[mid]) {
                left = mid;
            }
            //If we reach this point, this means that the
            //subarray size is down to 2 elements.
            else {
                //If left is greater than right, we found our
                //pivot point on the right side
                if (input[left] > input[right]) {
                    return input[right];
                }
                //If we reach this, that means array is not rotated
                //so the smallest is the 1st element
                else {
                    return input[0];
                }
            }
        }

        return input[mid];
    }

    public int search(int[] input, int value) {
        int left = 0;
        int right = input.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = input[mid];

            if (value < midValue) {
                right = mid - 1;
            }
            else if (value > midValue) {
                left = mid + 1;
            }
            else {
                return mid;
            }
        }

        return -1;

    }

}
