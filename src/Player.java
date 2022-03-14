import java.util.*;

public class Player {
    Cell initPlayer;

    Scanner input = new Scanner(System.in);

    public Player(Cell player) {

        initPlayer = player;
        InitialBlocks();
    }

    void InitialBlocks() {
        Game.grid.SetCell(this.initPlayer.x, this.initPlayer.y, "❤");
        Game.grid.SetCell(1, 1, "\uD83D\uDD25");
        Game.grid.SetCell(0, 3, "\uD83D\uDD25");
        Game.grid.SetCell(1, 3, "\uD83D\uDD25");
        Game.grid.SetCell(2, 1, "\uD83D\uDD25");
        Game.grid.SetCell(3, 1, "\uD83D\uDD25");
        Game.grid.SetCell(4, 4, "\uD83D\uDD25");

    }

    boolean NextMove(int x, int y) {

        if (x >= 0 && y >= 0) {
            return y < Game.grid.Column && x < Game.grid.Row && (Game.grid.GetCell(x, y).equals(" ") || Game.grid.GetCell(x, y).equals("❤") || Game.grid.GetCell(x, y).equals("⚡"));
        }

        return false;
    }

    void PlayerMovement() {
        int x = this.initPlayer.getX();
        int y = this.initPlayer.getY();
        Game.grid.SetCell(x, y, "❤");
        System.out.println();
        System.out.println("Enter the direction of Player :");
        String Direction = input.next();
        switch (Direction) {
            case "R": {

                while (this.NextMove(x, ++y)) {
                    initPlayer.setY(y);
//
                    Game.grid.SetCell(initPlayer.getX(), initPlayer.getY(), "❤");
                }

            }
            break;
            case "L": {

                while (this.NextMove(x, --y)) {
                    initPlayer.setY(y);
//
                    Game.grid.SetCell(initPlayer.getX(), initPlayer.getY(), "❤");
                }

            }
            break;
            case "T": {

                while (this.NextMove(--x, y)) {
                    initPlayer.setX(x);
//
                    Game.grid.SetCell(initPlayer.getX(), initPlayer.getY(), "❤");
                }

            }
            break;
            case "B": {
                while (this.NextMove(++x, y)) {
                    initPlayer.setX(x);
//
                    Game.grid.SetCell(initPlayer.getX(), initPlayer.getY(), "❤");
                }

            }
            break;

            default:
                break;

        }
        Game.grid.SetCell(initPlayer.getX(), initPlayer.getY(), "⚡");

    }
}
