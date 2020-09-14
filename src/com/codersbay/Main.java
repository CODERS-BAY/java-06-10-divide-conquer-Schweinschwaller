package com.codersbay;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        System.out.println("Divide and conquer");

        Random fortuna = new Random();
        int arraySizeRandom = fortuna.nextInt(40) + 2; // +2 because random can also return 0
        int[] arrayRandom = new int[arraySizeRandom];
        for (int i = 0; i < arrayRandom.length; i++) {
            if (fortuna.nextBoolean()) {
                arrayRandom[i] = fortuna.nextInt(100);
            } else {
                arrayRandom[i] = fortuna.nextInt(100) * -1;
            }
        }

        System.out.println(Arrays.toString(arrayRandom));

        int max = divide(arrayRandom);

    }

    public static int divide(int[] inputArray) {
        if (inputArray.length == 1) {
            return inputArray[1];
        }

        int leftSize = inputArray.length / 2;
        int[] leftArray = new int[leftSize];
        for (int i = 0; i < leftSize; i++) {
            leftArray[i] = inputArray[i];
        }

        int[] rightArray = new int[inputArray.length - leftSize];
        for (int i = leftSize; i < inputArray.length; i++) {
            rightArray[i - leftSize] = inputArray[i];
        }
        return findMax(divide(leftArray), divide(rightArray));
    }

    private static int findMax(int left, int right) {
        if (left > right)
            return left;
        else
            return right;
    }
}