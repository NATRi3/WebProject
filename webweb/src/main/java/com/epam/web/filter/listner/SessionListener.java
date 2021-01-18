package com.epam.web.filter.listner;

import com.epam.web.entity.TypeRole;
import com.epam.web.util.SessionParam;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Locale;

@WebListener
public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        session.setAttribute(SessionParam.SESSION_PARAM_PRODUCT_VALUE, 0);
        session.setAttribute(SessionParam.SESSION_PARAM_PRODUCT_PRICE, 0);
        session.setAttribute(SessionParam.SESSION_PARAM_PRODUCT_ID, new long[10]);
        session.setAttribute(SessionParam.SESSION_PARAM_ROLE, TypeRole.GUEST);
        session.setAttribute(SessionParam.SESSION_PARAM_LOCALE, Locale.getDefault());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println(se.getSession());
    }
}
