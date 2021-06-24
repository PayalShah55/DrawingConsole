package Darwing.DrawingConsole.draw;

import java.util.ArrayList;
import java.util.List;
import Drawing.DrawingConsole.exception.InvalidInputException;


public class Fill extends AbstractCommand{

	@Override
	public void execute(List<String> params) throws InvalidInputException {
		// TODO Auto-generated method stub
		if(params.size()<3 && !valid(params))
			throw new InvalidInputException("cordinates not entered correctly");
		
		int x=Integer.parseInt(params.get(0));
		int y=Integer.parseInt(params.get(1));
		char f=params.get(2).charAt(0);
		
		String fill=getFill(x,y,f);
		
		System.out.println(fill);
		
	}

	private String getFill(int x, int y, char f) {
		// TODO Auto-generated method stub
		if(shape[y][x]!=0)
			return "";
		
		if(x>0 && x<width && y>0 && y<height)
		{
			shape[y][x]=f;
			getFill(x-1,y,f);
			getFill(x+1,y,f);
			getFill(x,y-1,f);
			getFill(x,y+1,f);
		}
		
		return getshapeAsString();
	}

	private boolean valid(List<String> params) {
		// TODO Auto-generated method stub
		String pattern="\\d+";
		
		if(params.get(0).matches(pattern) && params.get(1).matches(pattern) && params.get(3).length()==1)
			return true;
		
		return false;
	}
	
	public static void main(String args[]) throws InvalidInputException
	{
		Canvas canvas = new Canvas();
		List<String> params = new ArrayList<String>();
		params.add("20");
		params.add("5");

		canvas.execute(params);

		Line line = new Line();
		params = new ArrayList<String>();

		params.add("1");
		params.add("2");
		params.add("6");
		params.add("2");

		line.setHeight(canvas.height);
		line.setWidth(canvas.width);

		line.shape = canvas.shape;

		line.execute(params);
		params.clear();
		params.add("6");
		params.add("3");
		params.add("6");
		params.add("4");

		line.execute(params);

		params.clear();

		Rectangle rect = new Rectangle();
		params = new ArrayList<String>();

		params.add("14");
		params.add("1");
		params.add("18");
		params.add("3");

		rect.setHeight(canvas.height);
		rect.setWidth(canvas.width);

		rect.shape = canvas.shape;

		rect.execute(params);

		Fill fill = new Fill();
		params.clear();
		params.add("10");
		params.add("3");
		params.add("o");

		fill.setHeight(canvas.height);
		fill.setWidth(canvas.width);
		fill.shape = canvas.shape;

		fill.execute(params);
	}
}
