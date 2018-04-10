public class Player {
    int x =1;
    int y =2;

    public Player(){
        this.x = 1;
        this.y = 2;
    }

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean match(int x,int y){
        return this.x == x && this.y == y;
    }
}
