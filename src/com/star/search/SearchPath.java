package com.star.search;

public class SearchPath {

    public static final char[][] SWAMP = {
            {'*', '*', '.', '*', '.', '*', '.', '.', '.', '.', '*'},
            {'.', '.', '*', '.', '*', '.', '.', '.', '*', '*', '.'},
            {'*', '.', '.', '.', '*', '.', '*', '.', '.', '.', '.'},
            {'.', '*', '.', '*', '.', '*', '.', '*', '.', '*', '.'},
            {'.', '.', '*', '.', '*', '.', '.', '.', '*', '.', '*'},
    };

    public static final int ROW = SWAMP.length;
    public static final int COLUMN = SWAMP[0].length;

    public static final String PATH = "Path:";
    public static final String NO_PATH_EXISTS = "no path exists";

    public static void main(String[] args){
        for (int i = 0; i < ROW; i++) {
            System.out.println("Start at Row " + i + " ");
            if (SWAMP[i][0] != '*' || !searchPath(i, 0, " " + i)) {
                System.out.println(NO_PATH_EXISTS);
            }
        }
    }

    public static boolean searchPath(int currentRow, int currentColumn, String path) {

        boolean findPath = false;

        if (currentColumn == COLUMN - 1) {
            System.out.println(PATH + path);
            return true;
        }

        for (int i = currentRow - 1; i <= currentRow + 1; i++) {
            if ((i >= 0) && (i < ROW) && SWAMP[i][currentColumn + 1] == '*') {
                if (searchPath(i, currentColumn + 1, path + " " + i)) {
                    findPath = true;
                }
            }
        }

        return findPath;
    }
}
