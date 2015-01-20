/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.UserStatus;
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
public class UsersFacade {

    @PersistenceContext(unitName = "ProjectBlogPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public Users creerUtilisateur(String login, String pass, String prenom, String nom, Date today, String description) {
        Users u = new Users();
        u.setUsername(login);
        u.setPassword(pass);
        u.setFirstname(prenom);
        u.setLastname(nom);
        u.setLast_connect(today);
        u.setAbout(description);
        u.setUser_status(UserStatus.ENABLED);
        
        persist(u);
        
        return u;
    }

    /*public void creerUtilisateurTest() {
        creerUtilisateur("admin", "admin", "momo", "gaga", new Date(), "A changer");
        creerUtilisateur("user", "user", "bastien", "maria", new Date(), "A decouvrir");
    }*/

    public List<Users> getAllUsers() {
        Query q = em.createQuery("SELECT u FROM User u");
        return q.getResultList();
    }
}
