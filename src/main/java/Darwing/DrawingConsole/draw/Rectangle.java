package Darwing.DrawingConsole.draw;

import java.util.ArrayList;
import java.util.List;

import Drawing.DrawingConsole.exception.InvalidInputException;

public class Rectangle extends AbstractCommand{

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
		
		String rectangle=getRectangle(x1, y1, x2, y2);
		
		System.out.println(rectangle);
		
		
	}

	private String getRectangle(int x1, int y1, int x2, int y2) {
		// TODO Auto-generated method stub
	
		//bottom line
		draw(x1,y1,x2,y1,'x');
		//left side
		draw(x1,y1,x1,y2,'x');
		
		//right side
		draw(x2,y1,x2,y2,'x');
		
		//upper
		draw(x1,y2,x2,y2,'x');
		
		return getshapeAsString();
		
	}
	
	
	public static void main(String args[]) throws InvalidInputException
	{
		Canvas canvas = new Canvas();

		List<String> params = new ArrayList<String>();
		params.add("20");
		params.add("20");

		canvas.execute(params);
		
		Rectangle r=new Rectangle();
		List<String> params1=new ArrayList<String>();
		
		params1.add("3");
		params1.add("3");
		params1.add("7");
		params1.add("5");
		
		r.setHeight(20);
		r.setWidth(20);

		r.shape = canvas.shape;
		
		r.execute(params1);
		
		
	}

}
