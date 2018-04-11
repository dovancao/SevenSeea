import java.util.ArrayList;

public class SevenSeea {
    Map map;
    Player player;

    ArrayList<Enemy> enemies;

    boolean gameEnd = false;

    public SevenSeea(){
        this.map = new Map();
        this.player = new Player();
        this.enemies = new ArrayList<>();
        staticEnemies();
    }



    public void staticEnemies(){
        enemies.add(new Enemy(3,0));
        enemies.add(new Enemy(3,3));
    }

    public boolean printEnemy(int x, int y){

        for(Enemy enemy : enemies){
            if(enemy.match(x,y)){
                System.out.print("E ");
                return true;
            }
        }
        return false;
    }

    public boolean printPlayer(int x, int y){
        if(player.match(x,y))
        {
            System.out.print("I ");
            return true;
        }
        return false;
    }

    public void print(){
        for (int y=0; y< map.height(); y++){
            for(int x =0; x<map.width(); x++){
                if(!printPlayer(x,y)){
                    if(!printEnemy(x,y)){
                        System.out.print(map.cellAt(x,y));
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }


    public void runCommand(String aCommand) {
        int dx = 0;
        int dy = 0;
        int nextShotX = 0;
        int nextShotY = 0;

        if (aCommand.equalsIgnoreCase("w")) dy = -1;
        if (aCommand.equalsIgnoreCase("s")) dy = 1;
        if (aCommand.equalsIgnoreCase("a")) dx = -1;
        if (aCommand.equalsIgnoreCase("d")) dx = 1;
        if (aCommand.equalsIgnoreCase("fw")) nextShotY = -2;
        if (aCommand.equalsIgnoreCase("fs")) nextShotY = 2;
        if (aCommand.equalsIgnoreCase("fa")) nextShotX = -2;
        if (aCommand.equalsIgnoreCase("fd")) nextShotX = 2;


        int nextX = player.getX() + dx;
        int nextY = player.getY() + dy;


        int nextEx = player.getX() + nextShotX;
        int nextEy = player.getY() + nextShotY;

        if (!map.isValid(nextX, nextY)) return;
        if (!map.isValid(nextShotX, nextShotY)) return;

        String nextPosition = map.cellAt(nextX, nextY);
        String nextEPosition = map.cellAt(nextEx, nextEy);

        if (nextPosition.equalsIgnoreCase("s") || nextPosition.equalsIgnoreCase("E")) {
            System.out.println("YOU LOST");
            return;
        }



         for(Enemy enemy :enemies){
                if(enemy.match(nextEx,nextEy)){
                    System.out.println("Ban da bat chet Enemy");
                    map.setCellAt(nextEx, nextEy, "-");
                    enemies.remove(enemy);
                }else {
                    int nextEnemyX = enemy.getX() - dx;
                    int nextEnemyY = enemy.getY() - dy;
                    if (!map.isValid(nextEnemyX, nextEnemyY)) return;
                    map.setCellAt(enemy.getX(), enemy.getY(), "-");

                    enemy.setY(nextEnemyX);
                    enemy.setY(nextEnemyY);

                    map.setCellAt(nextEnemyX, nextEnemyY, "E");
                }
            }



        player.setX(nextX);
        player.setY(nextY);


    }

    }

