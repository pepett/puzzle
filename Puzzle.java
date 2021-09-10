import java.awt.Graphics;
import java.util.Collections;
import java.util.ArrayList;

public class Puzzle {

    private Window w;
    private int tileSize = 100;
    private Graphics g;
    private int puzzle[][];
    private ArrayList<Integer> randomP = new ArrayList<>();
    private int cx;
    private int cy;


    public Puzzle(Window w){
        this.w = w;

        g = w.getGraphics();
        puzzle = new int[3][3];
        for(int y=0;y<3;y++){
            for(int x=0;x<3;x++){
                puzzle[y][x] = 0;
            }
        }
        shffle();
        draw();
    }

    private void shffle(){
        for(int i = 0;i<9;i ++){
            randomP.add(i);
        }

        Collections.shuffle(randomP);

        for(int y=0;y<3;y++){
            int tmp = y * 3;
            for(int x=0;x<3;x++){
                puzzle[y][x] = randomP.get(x + tmp);
            }
        }

    }

    private void draw(){

        g.clearRect(0, 0, 500, 500);


        String str;

        for(int y=0;y<3;y++){
            for(int x=0;x<3;x++){
                int num = puzzle[y][x];
                Integer i = Integer.valueOf(num);
                str = i.toString();
                g.drawString(str, x * tileSize + 45, y * tileSize + 90);
            }
        }

        
        for(int y=0;y<4;y++){
            for(int x=0;x<4;x++){
                g.drawLine(0, y * tileSize + 35, 300, y * tileSize + 35);
                g.drawLine(x * tileSize, 35, x * tileSize, 300 +35);
            }
        }

    }

    public void setX(int cx){
        this.cx = cx;
    }

    public void setY(int cy){
        this.cy = cy;
    }

    public void action(){
        System.out.println(cx);
        System.out.println(cy);
        if(cy > 0){
            if(puzzle[cy - 1][cx] == 0){
                puzzle[cy - 1][cx] = puzzle[cy][cx];
                puzzle[cy][cx] = 0;
            }
        }
        if(cy < 2){
            if(puzzle[cy + 1][cx] == 0){
                puzzle[cy + 1][cx] = puzzle[cy][cx];
                puzzle[cy][cx] = 0;
            }
        }
        if(cx > 0){
            if(puzzle[cy][cx - 1] == 0){
                puzzle[cy][cx - 1] = puzzle[cy][cx];
                puzzle[cy][cx] = 0;
            }
        }
        if(cx < 2){
            if(puzzle[cy][cx + 1] == 0){
                puzzle[cy][cx + 1] = puzzle[cy][cx];
                puzzle[cy][cx] = 0;
            }
        }
        draw();
    }
}
