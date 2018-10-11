import java.awt.event.MouseEvent;

import acm.graphics.GLine;
import acm.program.GraphicsProgram;

public class LineWithMouse extends GraphicsProgram
{
	GLine line;
	
	int xValue =0;
	int yValue =0;
	public void run()
	{
		
		addMouseListeners();
	}
	public void mousePressed(MouseEvent e)	
	{
		xValue = e.getX();
		yValue = e.getY();
		
		line = new GLine(xValue, yValue, xValue, yValue);
		add(line);
	}


	public void mouseDragged(MouseEvent e)	
	{
		line.setEndPoint(e.getX(), e.getY());
	}
}