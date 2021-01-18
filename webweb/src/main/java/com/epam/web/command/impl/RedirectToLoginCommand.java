package com.epam.web.command.impl;

import com.epam.web.command.Command;
import com.epam.web.util.PagePath;

import javax.servlet.http.HttpServletRequest;

public class RedirectToLoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String page = PagePath.LOGIN_PAGE;
        return page;
    }
}
