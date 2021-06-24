package Drawing.DrawingConsole.model;

import java.util.HashMap;
import java.util.Map;

public enum CommandType {
	
	CANVAS("C"),LINE("L"),RECTANGLE("R"),FILL("F"),QUIT("Q");
	
	private final String commandChar;
	private static final Map<String,CommandType> lookup=new HashMap<String, CommandType>();
	
	static {
		for(CommandType t:CommandType.values())
		{
			lookup.put(t.commandChar,t);
			
		}
	}

	private CommandType(String commandChar) {
		this.commandChar = commandChar;
	}
	
	public static CommandType get(String commandChar) {
		return lookup.get(commandChar);
	}
	
	
	
	
	
	
	
	

}
