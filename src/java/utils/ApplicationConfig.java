/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author MoMo
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();

        // following code can be used to customize Jersey 2.0 JSON provider:  
        try {
            Class jsonProvider = Class.forName("org.glassfish.jersey.jackson.JacksonFeature"); 
            resources.add(jsonProvider);
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        addRestResourceClasses(resources);

        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(services.ArticleFacadeREST.class);
        resources.add(services.CommentFacadeREST.class);
        resources.add(services.RoleFacadeREST.class);
        resources.add(services.UsersFacadeREST.class);
        resources.add(utils.CrossOriginResourceSharingFilter.class);
    }
    
}
