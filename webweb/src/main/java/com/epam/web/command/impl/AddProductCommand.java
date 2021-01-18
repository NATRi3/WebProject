package com.epam.web.command.impl;

import com.epam.web.command.Command;
import com.epam.web.entity.Product;
import com.epam.web.exception.ServiceException;
import com.epam.web.service.impl.ProductService;
import com.epam.web.util.PageParam;
import com.epam.web.util.PagePath;
import com.epam.web.util.SessionParam;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

public class AddProductCommand implements Command {
    public static final Logger logger = LogManager.getLogger(AddProductCommand.class);
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        long id_user = (long) session.getAttribute(SessionParam.SESSION_PARAM_USER_ID);
        String name = request.getParameter(PageParam.PARAM_NAME_PRODUCT);
        String info = request.getParameter(PageParam.PARAM_INFO_PRODUCT);
        String imageName = request.getParameter(PageParam.PARAM_IMAGE_PRODUCT);
        BigDecimal price = BigDecimal.valueOf(Long.parseLong(request.getParameter(PageParam.PARAM_PRICE_PRODUCT)));
        ProductService productService = new ProductService();
        try {
            productService.saveProduct(new Product(name, info, price, id_user, imageName));
            request.setAttribute("newproduct", name);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return PagePath.MAIN_PAGE;
    }
}
