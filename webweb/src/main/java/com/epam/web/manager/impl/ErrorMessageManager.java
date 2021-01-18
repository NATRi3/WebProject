package com.epam.web.manager.impl;

import com.epam.web.manager.MessageManagerInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;
import java.util.ResourceBundle;

public class ErrorMessageManager implements MessageManagerInterface {
    private static final Logger logger = LogManager.getLogger(MessageManagerInterface.class);
    public static ErrorMessageManager INSTANCE = new ErrorMessageManager();
    private ResourceBundle resourceBundle;
    private Locale locale;

    private ErrorMessageManager(){
        resourceBundle = ResourceBundle.getBundle("error");
    }
    @Override
    public void changeLocale(Locale locale) {
        this.locale = locale;
        resourceBundle = ResourceBundle.getBundle("error", locale);
        logger.info("Language changed!"+locale);
    }

    @Override
    public String getMessage(String key) {
        return resourceBundle.getString(key);
    }
}
