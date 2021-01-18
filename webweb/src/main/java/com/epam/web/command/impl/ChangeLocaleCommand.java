package com.epam.web.command.impl;

import com.epam.web.command.Command;
import com.epam.web.manager.impl.ErrorMessageManager;
import com.epam.web.manager.impl.MailMessageManager;
import com.epam.web.manager.impl.MessageManager;
import com.epam.web.util.PageParam;
import com.epam.web.util.PagePath;
import com.epam.web.util.SessionParam;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;


public class ChangeLocaleCommand implements Command {
    public static final Logger logger = LogManager.getLogger(ChangeLocaleCommand.class);
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String newLocale = request.getParameter(PageParam.PARAM_NEW_LOCALE);
        session.setAttribute(SessionParam.SESSION_PARAM_LOCALE,newLocale);
        MessageManager.INSTANCE.changeLocale(Locale.forLanguageTag(newLocale));
        MailMessageManager.INSTANCE.changeLocale(Locale.forLanguageTag(newLocale));
        ErrorMessageManager.INSTANCE.changeLocale(Locale.forLanguageTag(newLocale));
        logger.info("Locale change");
        return PagePath.LOGIN_PAGE;
    }
}
