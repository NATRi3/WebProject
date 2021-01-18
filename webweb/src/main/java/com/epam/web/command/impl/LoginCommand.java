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

public class LoginCommand implements Command {
    private static final Logger logger = LogManager.getLogger(LoginCommand.class);
    @Override
    public String execute(HttpServletRequest request) {
        String email = request.getParameter(PageParam.PARAM_EMAIL);
        String password = request.getParameter(PageParam.PARAM_PASSWORD);
        UserService service = new UserService();
        HttpSession session = request.getSession();
        try {
            User user = service.login(email,password);
            session.setAttribute(SessionParam.SESSION_PARAM_USER_EMAIL,user.getEmail());
            session.setAttribute(SessionParam.SESSION_PARAM_USER_NAME,user.getName());
            session.setAttribute(SessionParam.SESSION_PARAM_USER_ACCESS,user.getAccess());
            session.setAttribute(SessionParam.SESSION_PARAM_USER_ID,user.getId());
            session.setAttribute(SessionParam.SESSION_PARAM_IMAGE_NAME, user.getImageName());
            session.setAttribute(SessionParam.SESSION_PARAM_ROLE,user.getRole());
            return PagePath.MAIN_PAGE;
        } catch (ServiceException e) {
            logger.info(e.getMessage());
            request.setAttribute(PageParam.PARAM_MESSAGE, e.getMessage());
            return PagePath.LOGIN_PAGE;
        }
    }
}
