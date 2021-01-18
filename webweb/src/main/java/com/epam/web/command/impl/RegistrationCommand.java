package com.epam.web.command.impl;

import com.epam.web.command.Command;
import com.epam.web.exception.ServiceException;
import com.epam.web.manager.MessageKey;
import com.epam.web.manager.impl.ErrorMessageManager;
import com.epam.web.service.impl.UserService;
import com.epam.web.util.PageParam;
import com.epam.web.util.PagePath;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.servlet.http.HttpServletRequest;


public class RegistrationCommand implements Command {
    private static final Logger logger = LogManager.getLogger(RegistrationCommand.class);
    public static final UserService service = new UserService();
    @Override
    public String execute(HttpServletRequest request) {
        String name = request.getParameter(PageParam.PARAM_NAME);
        String email = request.getParameter(PageParam.PARAM_EMAIL);
        String password = request.getParameter(PageParam.PARAM_PASSWORD);
        String repeatPassword = request.getParameter(PageParam.PARAM_REPEAT_PASSWORD);
        String description = request.getParameter("description");
        String data = request.getParameter("data");

        try {
            service.registration(name,email,password,repeatPassword);
            request.setAttribute(PageParam.PARAM_MESSAGE, ErrorMessageManager.INSTANCE.getMessage(MessageKey.ERROR_MESSAGE_SUCCESSFUL_REGISTRATION));
            logger.info(email+" register successful!");
            return PagePath.LOGIN_PAGE;
        } catch (ServiceException e) {
            logger.info(e.getMessage());
            request.setAttribute(PageParam.PARAM_MESSAGE,e.getMessage());
            return PagePath.REGISTRATION_PAGE;
        }
    }
}
