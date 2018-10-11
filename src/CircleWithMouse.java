import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GLine;
import acm.graphics.GOval;
import acm.program.GraphicsProgram;

public class CircleWithMouse extends GraphicsProgram
{
	GOval circle;
	
	int xValue = 0;
	int yValue = 0 ;
	int x1Value = 0;
	int y2Value = 0 ;
	public void run()
	{
		addMouseListeners();
	}
	public void mousePressed(MouseEvent e)	
	{
		xValue = e.getX();
		yValue = e.getY();
		
		circle = new GOval(xValue, yValue, 0 , 0);
		circle.setFilled(true);
		circle.setColor(Color.pink);
		add(circle);
	}


	public void mouseDragged(MouseEvent e)	
	{
		int x1Value = e.getX();
		int y2Value = e.getY();
		double widthOfCircle;
		double heightOfCircle;
		
			widthOfCircle = x1Value - xValue;
			heightOfCircle = y2Value - yValue;
			if( widthOfCircle < 0)   
			{
				widthOfCircle = -widthOfCircle;
			}
			if( heightOfCircle < 0)   
			{
				heightOfCircle = -heightOfCircle;
			}
			
			circle.setBounds(Math.min(e.getX() , xValue) ,Math.min(e.getY(), yValue), widthOfCircle, heightOfCircle);
		
	}
	
}
