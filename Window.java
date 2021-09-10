import java.awt.Frame;
import java.awt.Color;

public class Window extends Frame{
    public Window(){
        this.setSize(500,500);
        this.setBackground(Color.GREEN);
        this.setResizable(false);
        this.setTitle("9面パズル");
        this.setVisible(true);
    }

}
