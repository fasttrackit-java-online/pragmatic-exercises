package org.fasttrackit;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class ArrayValidator {

    public static String validateArray(int[] numbers) {
        for (int k = 0; k < numbers.length; k++) {
            for (int x = k + 1; x < numbers.length; x++) {
                if (numbers[k] < numbers[x]) {
                    for (int y = x + 1; y < numbers.length; y++) {
                        if (numbers[k] > numbers[y]) {
                            return "INVALID";
                        }
                    }
                }
            }
        }

        return "VALID";
    }

    // preorder traversals in BST (binary search tree)
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(
                Paths.get("src/main/java/org/fasttrackit/exercise 2 - input.txt"));

        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter("src/main/java/org/fasttrackit/exercise 2 - output.txt"));

        // value of T
        int testCasesCount = scanner.nextInt();

        if (testCasesCount < 1 || testCasesCount > 10) {
            throw new RuntimeException("Invalid test cases number received.");
        }

        // processing each test case
        for (int i = 1; i <= testCasesCount; i++) {
            // value of N
            int arrayLength = scanner.nextInt();

            if (arrayLength < 1) {
                throw new RuntimeException("Invalid array length received.");
            }

            // array A
            int[] numbers = new int[arrayLength];

            // reading numbers for one test case
            for (int j = 0; j < numbers.length; j++) {
                int number = scanner.nextInt();

                if (number < 1 || number > 100) {
                    throw new RuntimeException("Invalid array number received.");
                }

                numbers[j] = number;
            }

            String result = validateArray(numbers);

            String outputLine = "CASE #" + i + ": " + result;

            bufferedWriter.write(outputLine);
            bufferedWriter.newLine();
        }

        scanner.close();
        bufferedWriter.close();
    }
}
