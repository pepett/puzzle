import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Click implements MouseListener{

    private Puzzle p;

    private int cx = 5;
    private int cy = 5;
    private int tSize = 100;

    public Click(Puzzle p){
        this.p = p;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        if(e.getX() < 300 && e.getY() < 335){
            for(int y=0;y<5;y++){
                for(int x=0;x<5;x++){
                    final int tmpX = x * tSize;
                    final int tmpY = y * tSize + 35;
                    if(Math.floor(e.getX()) > tmpX) cx = x;
                    if(Math.floor(e.getY()) > tmpY) cy = y;
                }
            }
            p.setX(cx);
            p.setY(cy);
            p.action();
        }
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
}
