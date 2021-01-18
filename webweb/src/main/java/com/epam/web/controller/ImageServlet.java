package com.epam.web.controller;

import com.epam.web.dao.impl.UserDao;
import com.epam.web.exception.ServiceException;
import com.epam.web.service.impl.UserService;
import com.epam.web.util.PageParam;
import com.epam.web.util.PagePath;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;


public class ImageServlet extends HttpServlet {
    public static final Logger logger = LogManager.getLogger(ImageServlet.class);
    public static final UserService userService = new UserService();
    public static final UserDao dao = new UserDao();
    private static final int MAX_MEMORY_BUFFER_SIZE = 1024 * 1024;
    private static final int MAX_SIZE_REQUEST = 1024 * 1024 * 10;
    private static final String FILE_TYPE_REGEX = "/";
    private static final String SAVING_PATH = "/WEB-INF/upload/account/";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ServletContext servletContext = getServletConfig().getServletContext();
        File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
        DiskFileItemFactory factory = new DiskFileItemFactory(MAX_MEMORY_BUFFER_SIZE, repository);
        ServletFileUpload upload = new ServletFileUpload(factory);upload.setSizeMax(MAX_SIZE_REQUEST);
        try {
            List<FileItem> items = upload.parseRequest(request);
            FileItem fileItem = null;
            String name = null;
            for (FileItem item : items) {
                if (item.isFormField()) {
                    name = item.getName();
                } else {
                    if(item.getContentType().equals("image/jpeg")||
                            item.getContentType().equals("image/png")||
                            item.getContentType().equals("image/gif")||
                            item.getContentType().equals("image/x-icon")) {
                        fileItem = item;
                    }
                }
            }
            String newImage = null;
            if (fileItem!=null) {
                newImage = processUploadedFile(fileItem, name, request);
            }
            logger.info("Save new image " + newImage);
            request.setAttribute(PageParam.PARAM_IMAGE_NAME, newImage);
        } catch (FileUploadException e) {
            logger.info("Image not found");
            request.setAttribute(PageParam.PARAM_MESSAGE,"Image not found");
        } catch (Exception e) {
            logger.info("Saving problem");
            request.setAttribute(PageParam.PARAM_MESSAGE,"Saving problem");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(PagePath.LOGIN_PAGE);//TODO
        dispatcher.forward(request, response);
    }
    private String processUploadedFile(FileItem item, String name, HttpServletRequest request) throws Exception {
        File uploadedFile = null;
        String newFileName;
        do {
            Random random = new Random();
            String fileName = item.getContentType();
            String fileType = fileName.substring(fileName.indexOf(FILE_TYPE_REGEX)+1);
            ServletContext context = request.getServletContext();
            newFileName = Math.abs(new Random().nextInt()) + "." + fileType;
            String pathToFile = SAVING_PATH + newFileName;
            String path = context.getRealPath(pathToFile);
            uploadedFile = new File(path);
        } while (uploadedFile.exists());
        uploadedFile.createNewFile();
        item.write(uploadedFile);
        return newFileName;
    }
}
