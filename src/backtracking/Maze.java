package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Maze {
    public static void main(String[] args) {
//        System.out.println(pathCount(3 ,3 ));
//        path("", 3, 3);
//        System.out.println(pathAll("", 3, 3));
        boolean[][] maze = {
                {true , true, true},
                {true, true, false},
                {true, true, true}
        };
//        pathRestrictions("", maze, 0, 0);
    }


    static int pathCount(int row, int col) {
        if (row == 1 || col == 1) {
            return 1;
        }

        int left = pathCount(row - 1, col);
        int right = pathCount(row, col - 1);

        return left + right;
    }

    static void path(String p, int r, int c) {
        if (r == 1 && c == 1) {
            System.out.println(p);
            return;
        }

        if (r > 1) {
            path(p + "D", r - 1, c);
        }

        if (c > 1) {
            path(p + "R", r, c - 1);
        }
    }

    static List<String> path2(String p, int r, int c) {
        if (r == 1 && c == 1) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        List<String> list = new ArrayList<>();
        if (r > 1) {
            list.addAll(path2(p + "D", r - 1, c));
        }

        if (c > 1) {
            list.addAll(path2(p + "R", r, c - 1));
        }
        return list;
    }

    static List<String> pathDiagonal(String p, int r, int c) {
        if (r == 1 && c == 1) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        List<String> list = new ArrayList<>();

        if (r > 1 && c > 1) {
            list.addAll(pathDiagonal(p+"D" , r- 1 , c- 1 ));
        }

        if (r > 1) {
            list.addAll(pathDiagonal(p + "V", r - 1, c));
        }

        if (c > 1) {
            list.addAll(pathDiagonal(p + "H", r, c - 1));
        }

        return list;
    }

    static void pathRestrictions(String p, boolean[][] maze, int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(p);
            return;
        }

        if ( !maze[r][c]){
            return;
        }

        if (r < maze.length - 1) {
            pathRestrictions(p + "D", maze, r + 1, c);
        }

        if (c < maze[0].length - 1) {
            pathRestrictions(p + "R", maze, r, c + 1);
        }
    }


}
