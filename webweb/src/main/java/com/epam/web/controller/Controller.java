package com.epam.web.controller;

import com.epam.web.command.Command;
import com.epam.web.command.CommandProvider;
import com.epam.web.exception.CommandException;
import com.epam.web.util.PageParam;
import com.epam.web.util.SessionParam;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {
    public static final Logger logger = LogManager.getLogger(Controller.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            Command command = CommandProvider.commandDefine(request.getParameter(PageParam.PARAM_COMMAND));
            String page = command.execute(request);
            if(request.getSession(false)!=null) {
                request.getSession().setAttribute(SessionParam.SESSION_PARAM_CURRENT_PAGE, page);
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher(page);
            dispatcher.forward(request, response);
        }catch (IOException|CommandException e){

            //response.sendError(404);//TODO
        }
    }
}
