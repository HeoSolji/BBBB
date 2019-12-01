import java.util.*;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Home {
	public static List<Classs> listClasses= new ArrayList<Classs>();
	public static List<ClassObj> classObjs= new ArrayList<ClassObj>();
	private static Point random() {
		Point point = new Point(0, 0);
		Random random= new Random();
		point.setX(random.nextInt(600));
		point.setY(random.nextInt(500));
		return point;
		
	}
	
	public static void main(String[] args) throws IOException {
		
		ReadFile a= new ReadFile();
		listClasses= a.getListClass();
		a.getNameClass();
		a.Show();
		Home home= new Home();
		Layer layer= new Layer();
		JFrame frame = new JFrame("JAVA_PROGRAM");
		
		for(Classs e: listClasses) {
			ClassObj co= new ClassObj(e.getName(), e.getStringFields(), e.getStringMethods(),e.getName_Class_extend());
			classObjs.add(co);
			System.out.println(e.getName_Class_extend());
		}
		for(ClassObj c: classObjs) {
			ClassTable table1= new ClassTable(random(), c);
			layer.addTable(table1);
		}
        frame.add(layer);
        frame.addMouseListener(layer);
        frame.addMouseMotionListener(layer);

        frame.setSize(1000, 1000);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
