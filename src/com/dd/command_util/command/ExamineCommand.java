package com.dd.command_util.command;

import com.dd.Console;
import com.dd.command_util.CommandHandler;
import com.dd.command_util.CommandOutputLog;
import com.dd.entities.Monster;
import com.dd.items.Item;

public class ExamineCommand extends CommandHandler {
    public ExamineCommand() {}

    @Override
    public void handleCommand(String[] args, CommandOutputLog outputLog) {
    	
    	StringBuilder examineStrBuilder=new StringBuilder();
    	
    	switch(args[0]) {
		
    	case "room":
			examineStrBuilder.append(currRoom().examineString());
			break;
		
    	case "monsters":
		case "monster":
			if(currRoom().hasMonster()) {
				for(String monsterName : currRoom().getMonsterList()) {
					Monster monster = currRoom().getMonster(monsterName);
					examineStrBuilder.append("~" + monsterName
							+ "\nHealth: " + monster.getStats().getHealth()
							+ "\nAttack/Defense: " + monster.getStats().getAttack() + "/" + monster.getStats().getDefense()
							+ "\n\n" + monster.getDescription() + "\n");
				}
			}
			else {
				examineStrBuilder.append("There are no mosters in this room.");
			}
			break;
		
		case "item":
		case "items":
			if(currRoom().hasItems()) {
				for(String itemName : currRoom().getItemList()) {
					Item item = currRoom().getItem(itemName);
					examineStrBuilder.append("~" + itemName + " " 
							+ item.examineToString() + "\n");
				}
			}
			else {
				examineStrBuilder.append("There are no items in this room"); 
			}
			break;
		
		default:
			if(currRoom().getMonster(args[0]) != null) {
				Monster monster = currRoom().getMonster(args[0]);
				String monsterName = monster.getName();
				examineStrBuilder.append("~" + monsterName
						+ "\nHealth: " + monster.getStats().getHealth()
						+ "\nAttack/Defense: " + monster.getStats().getAttack() + "/" + monster.getStats().getDefense()
						+ "\n\n" + monster.getDescription() + "\n");
				break;
			}
			if(currRoom().getItem(args[0]) != null) {
				Item item = currRoom().getItem(args[0]);
				String itemName = item.getName();
				examineStrBuilder.append("~" + itemName + " " 
						+ item.examineToString() + "\n");
				break;
			}
			else{
				examineStrBuilder.append("The argument \"" + args[0] + "\" is invalid.\n"
        			+ "Type \"help\" for help using the examine command.");
			}
			break;
    	}
    	Console.updateScreen(examineStrBuilder.toString());
    }
}