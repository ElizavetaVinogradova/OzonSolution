package main.java;

public class Solution {
    public static int[] findUnsortedSubarray(int[] input) {
        if (input.length <= 1) {
            return new int[]{-1, -1};
        }
        return new int[]{findLeftUnsortedBorder(input), findRightUnsortedBorder(input)};
    }

    private static int findLeftUnsortedBorder(int[] input) {
        int leftSortedBorder = 0;

        for (int i = 0; i < input.length - 1; i++) {
            if (input[i + 1] >= input[i]) {
                leftSortedBorder++;
            } else {
                break;
            }
        }

        for (int i = leftSortedBorder + 1; i < input.length; i++) {
            for (int j = leftSortedBorder; j >= 0 && input[i] < input[j]; j--) {
                leftSortedBorder--;
            }
        }
        if (leftSortedBorder == input.length - 1) {
            // array is sorted
            return -1;
        } else {
            return ++leftSortedBorder;
        }
    }

    private static int findRightUnsortedBorder(int[] input) {
        int rightSortedBorder = input.length - 1;
        for (int i = input.length - 1; i > 0; i--) {
            if (input[i - 1] <= input[i]) {
                rightSortedBorder--;
            } else {
                break;
            }
        }

        for (int i = rightSortedBorder - 1; i >= 0; i--) {
            for (int j = rightSortedBorder; j < input.length && input[i] > input[j]; j++) {
                rightSortedBorder++;
            }
        }
        if (rightSortedBorder == 0) {
            // array is sorted
            return -1;
        } else {
            return --rightSortedBorder;
        }
    }
}
