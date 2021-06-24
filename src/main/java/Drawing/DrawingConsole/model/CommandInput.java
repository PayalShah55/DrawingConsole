package Drawing.DrawingConsole.model;

import java.util.ArrayList;
import java.util.List;

public class CommandInput {
	
	CommandType commandType;
	List<String> params;
	
	public CommandInput(String input) {
		String parts[]=input.split(" ");
		this.commandType=CommandType.get(parts[0].toUpperCase());
		
		this.params=new ArrayList<String>();
		for(int i=1;i<parts.length;i++)
		{
			this.params.add(parts[i]);
		}
	}

	public CommandType getCommandType() {
		return commandType;
	}

	public void setCommandType(CommandType commandType) {
		this.commandType = commandType;
	}

	public List<String> getParams() {
		return params;
	}

	public void setParams(List<String> params) {
		this.params = params;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commandType == null) ? 0 : commandType.hashCode());
		result = prime * result + ((params == null) ? 0 : params.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommandInput other = (CommandInput) obj;
		if (commandType != other.commandType)
			return false;
		if (params == null) {
			if (other.params != null)
				return false;
		} else if (!params.equals(other.params))
			return false;
		return true;
	}
	

}
