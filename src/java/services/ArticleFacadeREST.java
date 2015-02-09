/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Article;
import entities.Status;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
@Path("article")
public class ArticleFacadeREST extends AbstractFacade<Article> {

    @PersistenceContext(unitName = "ProjectBlogPU")
    private EntityManager em;

    public ArticleFacadeREST() {
        super(Article.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Article entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Long id, Article entity) {
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
    public Article find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Article> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Article> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @GET
    @Path("countTag")
    @Produces({"application/xml", "application/json"})
    public Object countTag() {

        Query q = em.createNamedQuery("countTag");
        return q.getResultList();

    }

    @GET
    @Path("countArticleByCountry")
    @Produces({"application/xml", "application/json"})
    public Object countArticleByCountry() {

        Query q = em.createNamedQuery("countArticleByCountry");
        return q.getResultList();

    }

    @GET
    @Path("status/{type}")
    @Produces({"application/json"})
    public List<Article> findArticleByStatus(@PathParam("type") long type) {
        Status etat = Status.WAITFORVALIDATION;

        if (type == 0) {
            etat = Status.PUBLISHED;
        }
        if (type == 1) {
            etat = Status.REPORTASABUSED;
        }
        if (type == 2) {
            etat = Status.WAITFORVALIDATION;
        }

        Query q = em.createNamedQuery("findArticleByStatus");
        q.setParameter("status", etat);
        return q.getResultList();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
