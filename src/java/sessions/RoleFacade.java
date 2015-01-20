/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Role;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author MoMo
 */
@Stateless
public class RoleFacade {
    @PersistenceContext(unitName = "ProjectBlogPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
    public Role creerRole(String name) {
        Role r = new Role();
        r.setName(name);
        persist(r);
        
        return r;
    }

    public List<Role> getAllComment() {
        Query q = em.createQuery("SELECT r FROM Role r");
        return q.getResultList();
    }
    
}
