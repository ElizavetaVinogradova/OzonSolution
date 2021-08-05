package main.java;

public class Solution {

    private static int[] findUnsortedSubarray(int[] input) {
        if (input.length <= 1) {
            return new int[]{-1, -1};
        }
        return new int[]{findLeftBorder(input), findRightBorder(input)};
    }

    private static int findLeftBorder(int[] input) {
        int left = 0;

        for (int i = 0; i < input.length - 1; i++) {
            if (input[i + 1] >= input[i]) {
                left++;
            } else {
                break;
            }
        }

        for (int i = left + 1; i < input.length; i++) {
            for (int j = left; j >= 0 && input[i] < input[j]; j--) {
                left--;
            }
        }
        if (left == input.length - 1) {
            // array is sorted
            return -1;
        } else {
            return ++left;
        }
    }

    private static int findRightBorder(int[] input) {
        int right = input.length - 1;
        for (int i = input.length - 1; i > 0; i--) {
            if (input[i - 1] <= input[i]) {
                right--;
            } else {
                break;
            }
        }

        for (int i = right - 1; i >= 0; i--) {
            for (int j = right; j < input.length && input[i] > input[j]; j++) {
                right++;
            }
        }
        if (right == 0) {
            // array is sorted
            return -1;
        } else {
            return --right;
        }
    }
}
