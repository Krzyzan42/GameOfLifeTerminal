public class App {
    public static void main(String[] args) throws Exception {
        GameManager game = new GameManager();
        game.RunGame(false); // False to generate map randomly, true to make a spaceship
    }
}
