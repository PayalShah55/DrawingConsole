package Drawing.DrawingConsole.app;

import java.util.List;

import Darwing.DrawingConsole.draw.AbstractCommand;
import Drawing.DrawingConsole.exception.InvalidInputException;
import Drawing.DrawingConsole.model.CommandInput;


public class CommandContext {
	
	AbstractCommand abstractCommand;
	private final CommandFactory factory = new CommandFactory();
	
	public void setCommand(CommandInput commandInput) throws InvalidInputException {
		
		AbstractCommand newCommand = factory.getCommand(commandInput);
		if(abstractCommand!=null)
		{
			newCommand.setHeight(abstractCommand.getHeight());
			newCommand.setWidth(abstractCommand.getWidth());
			newCommand.setShape(abstractCommand.getShape());
		}
		
		abstractCommand=newCommand;
		
	}
	
	public void executeCommand(List<String> params) throws InvalidInputException
	{
		abstractCommand.execute(params);
	}

}
