import javax.swing.JFrame;


public class GUI {

    public static void main(String[] args) {
        
        new GUI();
    }

    public GUI()
    {
        JFrame guiFrame = new JFrame();
        
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setTitle("GUI");
        guiFrame.setSize(300,300);
      
        //This will center the JFrame in the middle of the screen
        guiFrame.setLocationRelativeTo(null);
        
        guiFrame.setVisible(true);
    }
    
}