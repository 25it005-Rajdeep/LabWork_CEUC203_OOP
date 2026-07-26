public class Point {
    private int x;
    private int y;
    Point(){
        x=0;
        y=0;
    }
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    int getX(){
        return x;
    }
    int getY(){
        return y;
    }
    int setX(int x){
        this.x = x;
    }
    int setY(int y){
        this.y = y;
    }

    @Override
    public String toString() {
        return "[ x :" + x + ", y : " + y + " ]";
    }

    @Override
    public boolean equals(Object obj) {
        return (this.x == x && this.y ==y );
    }
}
