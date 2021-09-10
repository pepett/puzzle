public class Game {

    private Window w;
    private Click c;
    private Puzzle p;
    
    public Game(){
        w = new Window();
        p = new Puzzle(w);
        c = new Click(p);
        w.addMouseListener(c);
    }



}
