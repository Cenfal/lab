package com.lab.weblab.configure;

import javax.faces.view.facelets.ResourceResolver;
import java.net.URL;

public class FaceletsResourceResolver extends ResourceResolver
{
    private ResourceResolver parent;
    private String basePath;

    public FaceletsResourceResolver(ResourceResolver parent)
    {
        this.parent = parent;
        this.basePath = "/META-INF/resources"; // TODO: Make configureable?
    }

    @Override
    public URL resolveUrl(String path)
    {
        URL url = parent.resolveUrl(path); // Resolves from WAR.

        if (url == null) {
            url = getClass().getResource(basePath + path); // Resolves from JAR.
        }

        return url;
    }
}

