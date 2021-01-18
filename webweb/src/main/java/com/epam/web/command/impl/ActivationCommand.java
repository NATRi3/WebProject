package com.epam.web.command.impl;

import com.epam.web.command.Command;
import com.epam.web.exception.ServiceException;
import com.epam.web.service.impl.UserService;
import com.epam.web.util.PageParam;
import com.epam.web.util.PagePath;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class ActivationCommand implements Command {
    private static final Logger logger = LogManager.getLogger(ActivationCommand.class);
    @Override
    public String execute(HttpServletRequest request) {
        String code = request.getParameter(PageParam.PARAM_ACTIVATION_CODE);
        UserService userService = new UserService();
        try {
            userService.activation(code);
        } catch (ServiceException e) {
            logger.info(e.getMessage());
        }
        return PagePath.ACTIVATION_PAGE;
    }
}
