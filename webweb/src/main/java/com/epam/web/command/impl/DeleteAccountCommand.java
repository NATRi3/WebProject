package com.epam.web.command.impl;

import com.epam.web.command.Command;
import com.epam.web.manager.MessageKey;
import com.epam.web.manager.impl.MessageManager;
import com.epam.web.service.impl.UserService;
import com.epam.web.util.PageParam;
import com.epam.web.util.PagePath;
import com.epam.web.util.SessionParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class DeleteAccountCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String email = session.getAttribute(SessionParam.SESSION_PARAM_USER_EMAIL).toString();
        String password = request.getParameter(PageParam.PARAM_PASSWORD);
        UserService userService = new UserService();
        if(userService.deleteUser(email,password)){
            request.setAttribute(PageParam.PARAM_MESSAGE, MessageManager.INSTANCE.getMessage(MessageKey.ERROR_MESSAGE_SUCCESSFUL_DELETE));
            return PagePath.LOGIN_PAGE;
        }else {
            return PagePath.LOGIN_PAGE;
        }
    }
}
