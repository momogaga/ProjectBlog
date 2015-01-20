/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Article;
import entities.Comment;
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
public class CommentFacade {

    @PersistenceContext(unitName = "ProjectBlogPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public Comment creerCommentaire(String commentaire, Users commentateur, Article articlePublie) {
        Comment c = new Comment();
        c.setComment(commentaire);
        c.setCommented_date(new Date());
        c.setArticle_commente(articlePublie);
        c.setA_commente(commentateur);
        
        persist(c);
        
        return c;
    }

    public List<Comment> getAllComment() {
        Query q = em.createQuery("SELECT c FROM Comment c");
        return q.getResultList();
    }
}
