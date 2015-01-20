/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Article;
import entities.Status;
import entities.Users;
import java.util.Date;
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

    public Article creerArticle(String titre, String keyword, String content, Date today, double posLat, double posLong, String position, Users redacteur) {
        Article a = new Article();
        a.setTitle(titre);
        a.setKeywords(keyword);
        a.setPublished_on(today);
        a.setContent(content);
        a.setPosition_latitude(posLat);
        a.setPosition_longitude(posLong);
        a.setPosition_name(position);
        a.setStatus(Status.PUBLISHED);
        a.setA_ecrit(redacteur);
        persist(a);
        
        return a;
    }

    public void creerArticleTest() {
       
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
