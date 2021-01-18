package com.epam.web.command.impl;

import com.epam.web.command.Command;
import com.epam.web.entity.User;
import com.epam.web.exception.ServiceException;
import com.epam.web.manager.MessageKey;
import com.epam.web.manager.impl.ErrorMessageManager;
import com.epam.web.service.impl.UserService;
import com.epam.web.util.PageParam;
import com.epam.web.util.PagePath;
import com.epam.web.util.SessionParam;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class RedirectToAccountCommand implements Command {
    public static final Logger logger = LogManager.getLogger(RedirectToLoginCommand.class);
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session.getAttribute(SessionParam.SESSION_PARAM_USER_EMAIL)==null||
        session.getAttribute(SessionParam.SESSION_PARAM_USER_NAME)==null||
        session.getAttribute(SessionParam.SESSION_PARAM_USER_ID)==null){
            request.setAttribute(PageParam.PARAM_MESSAGE, ErrorMessageManager.INSTANCE.getMessage(MessageKey.ERROR_MESSAGE_LOGIN_PLEASE));
            return PagePath.LOGIN_PAGE;
        }
        String email = session.getAttribute(SessionParam.SESSION_PARAM_USER_EMAIL).toString();
        String name = session.getAttribute(SessionParam.SESSION_PARAM_USER_NAME).toString();
        User user = null;
        UserService service = new UserService();
        try {
            user = service.getUserById(Long.parseLong(session.getAttribute(SessionParam.SESSION_PARAM_USER_ID).toString()));
            request.setAttribute(PageParam.PARAM_MESSAGE,"YOUR ACCOUNT");
            return PagePath.ACCOUNT_PAGE;
        } catch (ServiceException|NumberFormatException e) {
            logger.error(e);
        }
        return PagePath.ACCOUNT_PAGE;
    }
}
