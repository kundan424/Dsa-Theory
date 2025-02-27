package backtracking;

public class AllPath {

    public static void main(String[] args) {
        boolean[][] maze = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        pathAll("", maze, 0, 0);
    }

    static void pathAll(String p, boolean[][] maze, int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(p);
            return;
        }

        if (maze[r][c] && r < maze.length - 1) {
            pathAll(p + "D", maze, r + 1, c);
            maze[r][c] = false;
        }

        if ( maze[r][c] && c < maze[0].length - 1) {
            pathAll(p + "R", maze, r, c + 1);
            maze[r][c] = false;
        }
        if (maze[r][c] && r > 0) {
            pathAll(p + "U", maze, r - 1, c);
            maze[r][c] = false;
        }
        if (maze[r][c] && c > 0) {
            pathAll(p + "L", maze, r, c - 1);
            maze[r][c] = false;
        }
    }

}
