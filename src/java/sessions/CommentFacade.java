/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Comment;
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

    public void creerCommentaire(String commentaire) {
        Comment c = new Comment();

        persist(c);
    }

    public void creerCommentaireTest() {
        creerCommentaire("Test");
    }

    public List<Comment> getAllComment() {
        Query q = em.createQuery("SELECT c FROM Comment c");
        return q.getResultList();
    }
}
