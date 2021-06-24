package Drawing.DrawingConsole.app;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Drawing.DrawingConsole.exception.InvalidInputException;
import Drawing.DrawingConsole.model.CommandInput;
import Drawing.DrawingConsole.model.CommandType;



/**
 * Hello world!
 *
 */
public class App 
{
	private CommandContext commandContext;
	
	public final Pattern pattern=Pattern.compile("[a-zA-Z]{1}(\\s\\d+)*(\\s[a-zA-z]{1})?");
	
	public static void main( String[] args )
    {
        App app=new App();
        try(Scanner sc=new Scanner(System.in))
        {
        	while(true)
        	{
        		try {
        		System.out.println("Enter Command");
        		app.executeCommand(sc.nextLine());
        		}
        		catch(InvalidInputException in)
        		{
        			System.out.println(in.getMessage());
        		}
        	}
        	
        }
        catch(Exception e)
        {
        	System.out.println(e.getMessage());
        }
        
    }

	private void executeCommand(String input) throws InvalidInputException {
		// TODO Auto-generated method stub
		
		validateCommand(input);
		CommandInput ci=new CommandInput(input);
		if (commandContext == null) {
			
			if(!(ci.getCommandType().equals(CommandType.CANVAS) || ci.getCommandType().equals(CommandType.QUIT)))
			{
				throw new InvalidInputException("Not a valid Command");
			}
			else
				commandContext=new CommandContext(); 
		}
		commandContext.setCommand(ci);
		commandContext.executeCommand(ci.getParams());
		
	}
	
	private void validateCommand(String commandInput) throws InvalidInputException {
		Matcher matcher = pattern.matcher(commandInput);
		if (!matcher.matches()) {
			throw new InvalidInputException("Command string is invalid.");
		}
		String commandPart = commandInput.substring(0, 1);
		if (null == CommandType.get(commandPart)) {
			throw new InvalidInputException("Command " + commandPart
					+ " is not a valid command.");
		}
	}
}
