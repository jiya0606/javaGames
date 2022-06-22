public class pieces
{
  private int xCor;
  private int yCor;
  private boolean king;
  private int player;
  
  
  public pieces() {
    xCor = 0;
    yCor = 0;
    king = false;
    player = 0;
  }
  
  public pieces( int x, int y, boolean b, int p) {
    xCor = x;
    yCor = y;
    king = b;
    player = p;
  }
  
  public int getX() {
    return xCor;
  }
  
  public int getY() {
    return yCor;
  }
  
  public boolean kingStatus() {
    return king;
  }
  
  public int getPlayer() {
    return player;
  }
  
  
  public void setX(int x) {
    xCor = x;
  }
  
  public void setY(int y) {
    yCor = y;
  }
  
  public void makeKing(boolean mk) {
    king = mk;
  }
  
  public void setPlayer(int p) {
    player = p;
  }
  
}