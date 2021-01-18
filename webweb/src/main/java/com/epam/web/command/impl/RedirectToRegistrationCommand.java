package com.epam.web.command.impl;

import com.epam.web.command.Command;
import com.epam.web.util.PagePath;

import javax.servlet.http.HttpServletRequest;

public class RedirectToRegistrationCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String page = PagePath.REGISTRATION_PAGE;
        return page;
    }
}
