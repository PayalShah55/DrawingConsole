package Darwing.DrawingConsole.draw;

import java.util.ArrayList;
import java.util.List;

import Drawing.DrawingConsole.exception.InvalidInputException;


public class Line extends AbstractCommand{

	@Override
	public void execute(List<String> params) throws InvalidInputException {
		// TODO Auto-generated method stub
		if(params.size()<4)
			throw new InvalidInputException("Parameters are less then requested params");
		
		int x1=Integer.parseInt(params.get(0));
		int y1=Integer.parseInt(params.get(1));
		int x2=Integer.parseInt(params.get(2));
		int y2=Integer.parseInt(params.get(3));
		
		validate(x1, y1, x2, y2);
		
		String line=getLine(x1, y1, x2, y2);
		
		System.out.println(line);
	}

	private String getLine(int x1, int y1, int x2, int y2) {
		// TODO Auto-generated method stub
		draw(x1,y1,x2,y2,'x');
		
		return getshapeAsString();
	}

	public static void main(String args[]) throws InvalidInputException
	{
		 Canvas c=new Canvas();
		 List<String> params = new ArrayList<String>();
			params.add("20");
			params.add("20");

		 c.execute(params);
		 
		Line line = new Line();
		params = new ArrayList<String>();

		params.add("5");
		params.add("2");
		params.add("15");
		params.add("2");

		line.setHeight(20);
		line.setWidth(20);

		line.shape = c.shape;

		line.execute(params);
		
	}
	
	

}
