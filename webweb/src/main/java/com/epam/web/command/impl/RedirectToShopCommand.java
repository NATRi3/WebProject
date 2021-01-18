package com.epam.web.command.impl;

import com.epam.web.command.Command;
import com.epam.web.util.PagePath;

import javax.servlet.http.HttpServletRequest;

public class RedirectToShopCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {

        return PagePath.SHOP_PAGE;
    }
}
