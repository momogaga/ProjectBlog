/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Article;
import entities.Status;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author MoMo
 */
@Stateless
@LocalBean
public class ArticleFacade {

    @PersistenceContext(unitName = "ProjectBlogPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public void creerArticle(String titre) {
        Article a = new Article(titre);
        a.setStatus(Status.PUBLISHED);

        persist(a);
    }

    public void creerArticleTest() {
        creerArticle("MoMo");
        creerArticle("GaGa");
    }

    public List<Article> getAllArticle() {
        Query q = em.createQuery("SELECT a FROM Article a");
        return q.getResultList();
    }

    public List<Article> rechercherParTitre(String titre) {
        Query q = em.createQuery("SELECT a FROM Article a WHERE a.title = :title");
        q.setParameter("title", titre);
        return q.getResultList();
    }
}
