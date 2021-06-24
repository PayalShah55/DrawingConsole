package Darwing.DrawingConsole.draw;

import java.util.ArrayList;
import java.util.List;
import Drawing.DrawingConsole.exception.InvalidInputException;

public class Canvas extends AbstractCommand{

	@Override
	public void execute(List<String> params) throws InvalidInputException {
		// TODO Auto-generated method stub
		
		if(params.size()<2)
		{
			throw new InvalidInputException("Parameters are less than the required parameters");
		}
		
		int w=Integer.parseInt(params.get(0));
		int h=Integer.parseInt(params.get(1));
		
		setHeight(h);
		setWidth(w);
		
		String canvas=getCanvas();
		
		clearConsole();
		
		System.out.println(canvas);
		
	}

	private String getCanvas() {
		// TODO Auto-generated method stub
		shape=new char[height+2][width];
		// bottom
		draw(0,0,width-1,0,'-');
		//upper left
		draw(0,1,0,height+1,'|');
		//upper right
		draw(width-1,1,width-1,height+1,'|');
		//upper
		draw(0,height+1,width-1,height+1,'-');
		
		return getshapeAsString();
		
	}

	public static void main(String[] args) throws InvalidInputException {
		Canvas canvas = new Canvas();

		List<String> params = new ArrayList<String>();
		params.add("20");
		params.add("5");

		canvas.execute(params);
	}
	
	
	

}
