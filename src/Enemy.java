public class Enemy {
    int x;
    int y;
    public Enemy(){
        this.x = 0;
        this.y = 0;
    }

    public Enemy(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean match(int x,int y){
        return this.x == x && this.y == y;
    }

}
