package Darwing.DrawingConsole.draw;

import java.util.List;

import Drawing.DrawingConsole.exception.InvalidInputException;

public interface Command {
	
	public void execute(List<String> params) throws InvalidInputException;

}
