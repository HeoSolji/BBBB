import javax.swing.*;
import javax.swing.text.ChangedCharSetException;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Layer extends JPanel implements ActionListener, MouseMotionListener, MouseListener {
	private Point mousePos= new Point(0.0, 0.0);
	public boolean p=false;
    private static List<ClassTable> tables = new ArrayList<>();
    Timer t = new Timer(1, this);
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.LIGHT_GRAY);
        tables.forEach(table -> table.drawRect(g));

        t.start();
    }
    public void addTable(ClassTable table) {
        tables.add(table);
    }
    public void actionPerformed (ActionEvent e) {
    	repaint();
    }
    public void mouseClicked (MouseEvent e) {
    	
    }
    public void mousePressed (MouseEvent e) {
    	mousePos.setX(e.getX());
    	mousePos.setY(e.getY());
    }
    public void mouseReleased (MouseEvent e) {
    	mousePos.setX(0);
    	mousePos.setY(0);
    }
    public void mouseEntered (MouseEvent e) {}
    public void mouseExited (MouseEvent e) {}
    public void mouseDragged (MouseEvent e) {
    	for(int i=0;i<tables.size();i++){
            if(tables.get(i).containsMouse(e)){
                tables.get(i).Move((int)(e.getX() - mousePos.getX()),(int)( e.getY() - mousePos.getY()));
                mousePos.setX(e.getX());
                mousePos.setY(e.getY());
               // break;
            }
        }
    	System.out.print("A");
    }
    public void mouseMoved (MouseEvent e) {}
}
