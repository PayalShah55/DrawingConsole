package Darwing.DrawingConsole.draw;

import java.util.List;

import Drawing.DrawingConsole.exception.InvalidInputException;

public abstract class AbstractCommand implements Command{

	int width;
	int height;
	char shape[][];
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public char[][] getShape() {
		return shape;
	}

	public void setShape(char[][] shape) {
		this.shape = shape;
	}

	public abstract void execute(List<String> params) throws InvalidInputException;
	
	private static final String OS = System.getProperty("os.name");
	private static final String LINE_SEPERATOR = System
			.getProperty("line.separator");

	
	public void draw(int x1,int y1,int x2,int y2,char drawChar)
	{
		//vertical lines
		if(x1==x2)
		{
			for(int i=y1;i<=y2;i++)
				shape[i][x1]=drawChar;
		}
		else if(y1==y2)
		{
			for(int i=x1;i<=x2;i++)
				shape[y1][i]=drawChar;
		}
		else
		{
			double slope=(double)(y2-y1)/(double)(x2-x1);
			for(int i=y1;i<=y2;i++)
			{
				shape[i][(int)Math.ceil(x1+(i/slope))]=drawChar;
			}
		}
	}
	
	public String getshapeAsString()
	{
		StringBuilder results = new StringBuilder();
		for(int i=0;i<shape.length;i++)
		{
			for(int j=0;j<shape[i].length;j++)
			{
				results.append(shape[i][j]==0 ? " ":shape[i][j]);
			}
			
			results.append(LINE_SEPERATOR);
		}
		
		return results.toString();
	}
	
	
	public void validate(int x1,int y1,int x2,int y2) throws InvalidInputException
	{
		if(x1>0 && x1<width && y1>0 && y1<height && x2>0 && x2<width && y2>0 && y2<height && (x1<=x2) && (y1<=y2))
			return ;
		
		throw new InvalidInputException("Co-ordinatees are not within the canvas");
	}
	
	
	public void clearConsole()
	{
		try {
			if(OS.contains("Windows"))
			{
				new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
			}
			else
			{
				System.out.print("\033\143");
			}
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
			System.exit(0);

		}
	}

}
