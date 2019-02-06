package com.lab.weblab.configure;

import com.lab.weblab.WebLabApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.faces.webapp.FacesServlet;
import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import java.util.EnumSet;

/**
 * Created by INNGKISAKOL on 2/8/2018.
 */
@Configuration
public class WebAppInitializer implements WebApplicationInitializer
{
    private static final Logger logger = LoggerFactory.getLogger(WebAppInitializer.class);

    public WebAppInitializer()
    {
        logger.trace("Create WebAppInitializer");
    }

    public void onStartup(ServletContext servletContext) throws ServletException
    {
        setupCharacterEncodingFilter(servletContext);
        setupSpringApplicationContext(servletContext);
        setupFaceContext(servletContext);
    }

    private void setupCharacterEncodingFilter(ServletContext servletContext)
    {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        FilterRegistration.Dynamic filterRegistration = servletContext.addFilter("charaterEncodingFilter", characterEncodingFilter);
        filterRegistration.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
    }

    private void setupSpringApplicationContext(ServletContext servletContext)
    {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(WebLabApplication.class);
        ctx.setServletContext(servletContext);
        servletContext.addListener(new ContextLoaderListener(ctx));
        servletContext.addListener(new RequestContextListener());
    }

    private void setupFaceContext(ServletContext servletContext)
    {
        /** Faces Servlet */
        Dynamic dynamic = servletContext.addServlet("faces-servlet", new FacesServlet());
        dynamic.addMapping("*.tkf");
        dynamic.setLoadOnStartup(1);

        servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
        servletContext.setInitParameter("primefaces.THEME", "blitzer");
        servletContext.setInitParameter("primefaces.CLIENT_SIDE_VALIDATION", Boolean.TRUE.toString());
        servletContext.setInitParameter("javax.faces.FACELETS_SKIP_COMMENTS", Boolean.TRUE.toString());
        servletContext.setInitParameter("primefaces.FONT_AWESOME", Boolean.TRUE.toString());
        servletContext.setInitParameter("primefaces.UPLOADER", "auto");
    }
}
