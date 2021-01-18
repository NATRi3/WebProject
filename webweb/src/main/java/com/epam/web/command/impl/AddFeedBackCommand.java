package com.epam.web.command.impl;

import com.epam.web.command.Command;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class AddFeedBackCommand implements Command {
    public static final Logger logger = LogManager.getLogger(AddFeedBackCommand.class);

    @Override
    public String execute(HttpServletRequest request) {

        return null;
    }
}
