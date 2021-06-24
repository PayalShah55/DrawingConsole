package Darwing.DrawingConsole.draw;
import java.util.List;

import Darwing.DrawingConsole.draw.AbstractCommand;
import Drawing.DrawingConsole.exception.InvalidInputException;

public class Quit extends AbstractCommand{

	@Override
	public void execute(List<String> params) throws InvalidInputException {
		// TODO Auto-generated method stub
		System.exit(0);
		
	}
	
	
	

}
