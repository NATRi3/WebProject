package com.epam.web.command;

import com.epam.web.exception.CommandException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommandProvider {
    public static final Logger logger = LogManager.getLogger(CommandProvider.class);
    public static Command commandDefine(String command) throws CommandException {
        try {
            Command resultCommand =
                    TypeCommand.valueOf(command.toUpperCase()).getCommand();
            return resultCommand;
        }catch (IllegalArgumentException e){
            logger.error(e);
            throw new CommandException(e.getMessage());
        }
    }
}
