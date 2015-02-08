/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entities.Article;
import entities.Comment;
import entities.Role;
import entities.Status;
import entities.Users;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Startup;
import sessions.ArticleFacade;
import sessions.CommentFacade;
import sessions.RoleFacade;
import sessions.UsersFacade;

/**
 *
 * @author MoMo
 */
@Singleton
@LocalBean
@Startup // Creation au déploiement
public class InitBD {

    @EJB
    UsersFacade uf;

    @EJB
    CommentFacade cf;

    @EJB
    ArticleFacade af;

    @EJB
    RoleFacade rf;

    @PostConstruct // Appel après constructeur
    public void initialize() {
        System.out.println("BD initialisee");

        Users momo = uf.creerUtilisateur("admin", "admin", "momo", "gaga", new Date(), "About");
        Users bastien = uf.creerUtilisateur("user", "user", "bastien", "maria", new Date(), "About");
        Role r1 = rf.creerRole("Admin");
        Role r2 = rf.creerRole("User");
        momo.setA_role(r1);
        bastien.setA_role(r2);

        Article a1 = af.creerArticle("Title 1", "Key", "Cyprum itidem insulam procul a continenti discretam et portuosam inter municipia crebra urbes duae faciunt claram Salamis et Paphus, altera Iovis delubris altera Veneris templo insignis.", new Date(), 45.777168, 3.082417, "Nice", momo, Status.WAITFORVALIDATION);
        Article a2 = af.creerArticle("Title 2", "Tag", "Nemo quaeso miretur, si post exsudatos labores itinerum longos congestosque adfatim commeatus fiducia vestri ductante barbaricos pagos adventans velut mutato repente consilio ad placidiora deverti.", new Date(), 45.777168, 3.082417, "Nice", momo, Status.WAITFORVALIDATION);
        Article a3 = af.creerArticle("Article 1", "Img", "Primi igitur omnium statuuntur Epigonus et Eusebius ob nominum gentilitatem oppressi. praediximus enim Montium sub ipso vivendi termino his vocabulis appellatos fabricarum culpasse tribunos ut adminicula futurae molitioni pollicitos.", new Date(), 45.777168, 3.082417, "Nice", bastien, Status.PUBLISHED);
        Article a4 = af.creerArticle("Article 2", "Vac", "Sed si ille hac tam eximia fortuna propter utilitatem rei publicae frui non properat, ut omnia illa conficiat, quid ego, senator, facere debeo, quem, etiamsi ille aliud vellet, rei publicae consulere oporteret?", new Date(), 45.777168, 3.082417, "Nice", bastien, Status.PUBLISHED);

        Comment c1 = cf.creerCommentaire("Coucou", momo);
        Comment c2 = cf.creerCommentaire("Yo", bastien);
        Comment c3 = cf.creerCommentaire("Re", momo);

        c1.setA_article(a1);
        c2.setA_article(a4);
        c3.setA_article(a4);
    }
}
