/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Users;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author MoMo
 */
@Stateless
@Path("users")
public class UsersFacadeREST extends AbstractFacade<Users> {

    @PersistenceContext(unitName = "ProjectBlogPU")
    private EntityManager em;

    public UsersFacadeREST() {
        super(Users.class);
    }

    //post sur user / mdp
    @POST
    @Path("/check")
    @Produces({"application/json"})
    public Object checkUserPassword(@FormParam("username") String username, @FormParam("mdp") String mdp) {

        System.out.println("username :  " + username);

        Query q = em.createNamedQuery("findUserByUsernameAndPassword");
        q.setParameter("username", username);
        q.setParameter("password", mdp);

        if (q.getResultList().isEmpty()) {
            return false;
        } else {
            Users u = (Users) q.getSingleResult();
            u.setLast_connect(new Date());
            return u;
        }
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Users entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Long id, Users entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Users find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Users> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Users> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
