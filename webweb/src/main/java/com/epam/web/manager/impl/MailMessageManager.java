package com.epam.web.manager.impl;

import com.epam.web.manager.MessageManagerInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;
import java.util.ResourceBundle;

public class MailMessageManager implements MessageManagerInterface {
    private static final Logger logger = LogManager.getLogger(MessageManagerInterface.class);
    public static MailMessageManager INSTANCE = new MailMessageManager();
    private ResourceBundle resourceBundle;
    private Locale locale;

    private MailMessageManager(){
        resourceBundle = ResourceBundle.getBundle("mail");
    }
    @Override
    public void changeLocale(Locale locale) {
        this.locale = locale;
        resourceBundle = ResourceBundle.getBundle("mail", locale);
    }

    @Override
    public String getMessage(String key) {
        return resourceBundle.getString(key);
    }
}
