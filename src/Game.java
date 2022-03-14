import java.util.Arrays;

public class Game {
    public static Grid grid;
    static Player player;
    static GameState state;
    boolean[][] visited;

    public Game() {
        grid = new Grid(5, 5);
        player = new Player(new Cell(0, 0));

        state = GameState.Player_Running;
        this.visited = new boolean[grid.Row][grid.Column];
        for (int i = 0; i < grid.Row; i++) {
            Arrays.fill(this.visited[i], false);
        }

    }

    public void StartGame() {
        grid.PrintGrid();
        while (EndGame() == GameState.Player_Running) {
            System.out.println();
            System.out.println();
            System.out.println("Press T to Top   : ");
            System.out.println("Press D to Down  : ");
            System.out.println("Press R to Right : ");
            System.out.println("Press L to Left  : ");

            player.PlayerMovement();
            grid.PrintGrid();


        }
        grid.PrintGrid();
        System.out.println();
        System.out.println("End Game, YOU are Win ◕_◕ ◕_◕");
    }


    public static GameState EndGame() {
        for (int i = 0; i < Game.grid.Row; i++)
            for (int j = 0; j < Game.grid.Column; j++) {
                if (Game.grid.GetCell(i, j).equals(" ")) {
                    return GameState.Player_Running;
                }
            }
        return GameState.Player_is_Winner;


    }

}
