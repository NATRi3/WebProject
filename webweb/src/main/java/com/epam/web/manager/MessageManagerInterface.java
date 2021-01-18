package com.epam.web.manager;

import java.util.Locale;

public interface MessageManagerInterface {
    void changeLocale(Locale locale);
    String getMessage(String key);
}
