package com.lab.weblab.configure;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@Configuration
public class Initializer implements ServletContextInitializer
{
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException
    {
        servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
        servletContext.setInitParameter("primefaces.CLIENT_SIDE_VALIDATION", "true");
        servletContext.setInitParameter("javax.faces.PROJECT_STAGE", "Development");
        servletContext.setInitParameter("javax.faces.DEFAULT_SUFFIX", ".xhtml");
        servletContext.setInitParameter("primefaces.THEME", "blitzer");
        servletContext.setInitParameter("primefaces.CLIENT_SIDE_VALIDATION", Boolean.TRUE.toString());
        servletContext.setInitParameter("javax.faces.FACELETS_SKIP_COMMENTS", Boolean.TRUE.toString());
        servletContext.setInitParameter("primefaces.FONT_AWESOME", Boolean.TRUE.toString());
        servletContext.setInitParameter("primefaces.UPLOADER", "auto");
        servletContext.setInitParameter("org.apache.myfaces.SUPPORT_JSP_AND_FACES_EL", Boolean.TRUE.toString());
        servletContext.setInitParameter("javax.faces.FACELETS_RESOURCE_RESOLVER", "com.lab.weblab.configure.FaceletsResourceResolver");
    }

}
