public class GameManager {
    Map map;

    public void RunGame(boolean spaceship) {
        int width  = Input.ReadPositiveInt("Szerokość: ", 20);
        int height  = Input.ReadPositiveInt("Wysokość: ", 20);
        int roundN  = Input.ReadPositiveInt("Liczba rund: ", 5000);

        map = new Map(height, width);
        if(spaceship)
            map.makeSpaceship();
        else
            map.fillRandom();
        map.draw();

        for (int i = 0; i < roundN - 1; i++) {
            Step();
            map.draw();
            if(map.isEmpty()) {
                System.out.println("Koniec gry, mapa jest pusta");
                return;
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) { // That's why we hate java
                e.printStackTrace();
            }
        }
    }

    private void Step() {
        Map futureMap = new Map(map.height, map.width);

        for (int x = 0; x < map.width; x++) {
            for (int y = 0; y < map.height; y++) {
                int neighbourNum = map.getNumberOfNeighbors(x, y);

                if(neighbourNum == 3)
                    futureMap.setCell(x, y, true);

                if(map.getCell(x, y) == true && neighbourNum == 2)
                    futureMap.setCell(x, y, true);
            }
        }
        map = futureMap;
    }
}
