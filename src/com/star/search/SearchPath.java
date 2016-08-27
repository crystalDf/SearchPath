package com.star.search;

public class SearchPath {

    public static final int ROW = 5;
    public static final int COLUMN = 11;

    public static final String NO_PATH_EXISTS = "no path exists";
    public static final String PATH = "Path:";

    public static final char[][] SWAMP = {
            {'*', '*', '.', '*', '.', '*', '.', '.', '.', '.', '*'},
            {'.', '.', '*', '.', '*', '.', '.', '.', '*', '*', '.'},
            {'*', '.', '.', '.', '*', '.', '*', '.', '.', '.', '.'},
            {'.', '*', '.', '*', '.', '*', '.', '*', '.', '*', '.'},
            {'.', '.', '*', '.', '*', '.', '.', '.', '*', '.', '*'},
    };

    public static void main(String[] args){
        for (int i = 0; i < ROW; i++) {
            if (SWAMP[i][0] == '*') {
                System.out.println(i + " " + searchPath(i, 0, " " + i));
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
                if (pathResult.contains(PATH)) {
                    return pathResult;
                }
            }
        }

        return NO_PATH_EXISTS;
    }
}
