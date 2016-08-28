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
            if (SWAMP[i][0] == '*') {
                System.out.println("Start at Row " + i + " " + searchPath(i, 0, " " + i));
            } else {
                System.out.println("Start at Row " + i + " " + NO_PATH_EXISTS);
            }
        }
    }

    public static String searchPath(int currentRow, int currentColumn, String path) {

        if (currentColumn == COLUMN - 1) {
            return PATH + path;
        }

        for (int i = currentRow - 1; i <= currentRow + 1; i++) {
            if ((i >= 0) && (i < ROW) && SWAMP[i][currentColumn + 1] == '*') {
                String pathResult = searchPath(i, currentColumn + 1, path + " " + i);
                if (!pathResult.equals(NO_PATH_EXISTS)) {
                    return pathResult;
                }
            }
        }

        return NO_PATH_EXISTS;
    }
}
