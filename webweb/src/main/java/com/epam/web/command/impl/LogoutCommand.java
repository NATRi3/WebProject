package com.epam.web.command.impl;

import com.epam.web.command.Command;
import com.epam.web.entity.TypeRole;
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
import java.util.Locale;

public class LogoutCommand implements Command {
    public static final Logger logger = LogManager.getLogger(LogoutCommand.class);
    @Override
    public String execute(HttpServletRequest request) {
        UserService service = new UserService();
        HttpSession session = request.getSession();
        String locale = session.getAttribute(SessionParam.SESSION_PARAM_LOCALE).toString();
        session.invalidate();
        return PagePath.LOGIN_PAGE;
    }
}
