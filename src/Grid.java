import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Grid {
    String[][] Maze;
    int Row;
    int Column;

    public Grid(int Row, int Column) {
        this.Row = Row;
        this.Column = Column;
        this.Maze = new String[Row][Column];
        for (int i = 0; i < Row; i++) {
            Arrays.fill(this.Maze[i], " ");
        }

    }


    public void SetCell(int x, int y, String str) {

        this.Maze[x][y] = str;
    }

    public String GetCell(int x, int y) {
        return this.Maze[x][y];
    }

    public void PrintGrid() {
        System.out.print(" __ __ __ __ __ __ __ __ __ __ _ ");
        for (int i = 0; i < Row; i++) {
            System.out.println();
            for (int j = 0; j < Column; j++) {
                if (j == 0) {
                    System.out.print("|__" + GetCell(i, j) + " _|__");
                } else if (j == Column - 1)
                    System.out.print(GetCell(i, j) + "__|");
                else
                    System.out.print(GetCell(i, j) + "__|__");
            }
        }
        System.out.println();
    }


}

