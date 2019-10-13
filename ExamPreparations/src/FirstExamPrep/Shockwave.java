package FirstExamPrep;

import java.util.Arrays;
import java.util.Scanner;

/*
Doctor T. decided to experiment with shockwaves. He performs his studies in a rectangular room of size N * M. However
what is interesting is that the shockwaves are also rectangular, through some unknown properties of matter. There are
pressure plates which indicate each time a shockwave hits a certain area in the room.
You will be given N and M – integers indicating the size of the room – in rows and columns. There is a plate in each
column. In the beginning the plates have value – 0, because no shockwaves have been executed.
After that you will begin receiving lines of exactly 4 integers, separated by a single space – X1, Y1, X2, Y2. These are
coordinates of the points which are the upper-left and the bottom-right corners of the rectangular shockwave. You must
increase the value of each plate in the area the rectangular shockwave affects, by 1. You must perform this for every
shockwave input.
When you receive the command “Here We Go”, that means Doctor T. is ready to check the results of the shockwaves. You
must print all the plates on rows, each plate’s value separated by a space.

Input
On the first line of input you will receive N and M – separated by a space.
On the next several lines you will receive the 4 integers – separated by a space, until you receive the command
“Here We Go”.

Output
Print all of the rows of the room, each on a new line, with all columns separated by a single space.

Constrains
The dimensions of the room - N and M, will be valid integers in range [1, 25].
Each of the given integers – X1, Y1, X2, Y2, will be inside the valid room indexes.
X2 will always be greater than or equal to X1, and Y2 will always be greater than or equal to Y1.
 */
public class Shockwave {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] start = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = start[0];
        int cols = start[1];

        int[][] matrix = new int[rows][cols];

        for (int fillRows = 0; fillRows < matrix.length; fillRows++) {
            for (int fillCols = 0; fillCols < matrix[fillRows].length; fillCols++) {
                matrix[fillRows][fillCols] = 0;
            }
        }

        System.out.println();
        String input = scanner.nextLine();

        while (!input.equals("Here We Go")) {
            int[] tokens = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
            int x1 = tokens[0];
            int y1 = tokens[1];
            int x2 = tokens[2];
            int y2 = tokens[3];

            updateMatrix(matrix, x1, y1, x2, y2);

            input = scanner.nextLine();
        }

        for (int fillRows = 0; fillRows < matrix.length; fillRows++) {
            for (int fillCols = 0; fillCols < matrix[fillRows].length; fillCols++) {
                System.out.print(matrix[fillRows][fillCols] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] updateMatrix(int[][] matrix, int x1, int y1, int x2, int y2) {

        for (int row = x1; row <= x2; row++) {
            for (int col = y1; col <= y2; col++) {
                matrix[row][col] += 1;
            }
        }
        return matrix;
    }
}
