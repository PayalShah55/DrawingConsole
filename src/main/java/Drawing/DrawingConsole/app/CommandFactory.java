package Drawing.DrawingConsole.app;

import Darwing.DrawingConsole.draw.AbstractCommand;
import Darwing.DrawingConsole.draw.Canvas;
import Darwing.DrawingConsole.draw.Fill;
import Darwing.DrawingConsole.draw.Line;
import Darwing.DrawingConsole.draw.Quit;
import Darwing.DrawingConsole.draw.Rectangle;
import Drawing.DrawingConsole.exception.InvalidInputException;
import Drawing.DrawingConsole.model.CommandInput;

public class CommandFactory {
	
	public final AbstractCommand getCommand(CommandInput commandInput) throws InvalidInputException
	{
		switch(commandInput.getCommandType())
		{
			case CANVAS:
					return new Canvas();
			case LINE:
					return new Line();
			case RECTANGLE:
					return new Rectangle();
			case FILL:
					return new Fill();
			case QUIT:
					return new Quit();
			default:
				throw new InvalidInputException("Invalid command!");
		}
	}

}
