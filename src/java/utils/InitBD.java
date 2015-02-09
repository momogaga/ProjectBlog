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

        Article a1 = af.creerArticle("Prix du gazoil", "#Auto", "Cyprum itidem insulam procul a continenti discretam et portuosam inter municipia crebra urbes duae faciunt claram Salamis et Paphus, altera Iovis delubris altera Veneris templo insignis.", new Date(1418079600), 11.07519, 3.68081, "United States", momo, Status.WAITFORVALIDATION);
        Article a2 = af.creerArticle("Indice secteur bancaire", "#Monde", "Nemo quaeso miretur, si post exsudatos labores itinerum longos congestosque adfatim commeatus fiducia vestri ductante barbaricos pagos adventans velut mutato repente consilio ad placidiora deverti.", new Date(1419030000), 45.777168, 3.082417, "Brazil", momo, Status.WAITFORVALIDATION);
        Article a3 = af.creerArticle("Google car", "#Auto", "Primi igitur omnium statuuntur Epigonus et Eusebius ob nominum gentilitatem oppressi. praediximus enim Montium sub ipso vivendi termino his vocabulis appellatos fabricarum culpasse tribunos ut adminicula futurae molitioni pollicitos.", new Date(1419721200), 59.12199, 100.36050, "Canada", bastien, Status.PUBLISHED);
        Article a4 = af.creerArticle("Partir à l'étranger", "#Vacance", "Sed si ille hac tam eximia fortuna propter utilitatem rei publicae frui non properat, ut omnia illa conficiat, quid ego, senator, facere debeo, quem, etiamsi ille aliud vellet, rei publicae consulere oporteret?", new Date(1420412400), 30.96278, 102.46987, "France", bastien, Status.PUBLISHED);
        
        Article a5 = af.creerArticle("Foot mondial 2014", "#Sport", "Cyprum itidem insulam procul a continenti discretam et portuosam inter municipia crebra urbes duae faciunt claram Salamis et Paphus, altera Iovis delubris altera Veneris templo insignis.", new Date(1421190000), 18.76392, -3.03278, "United States", momo, Status.PUBLISHED);
        Article a6 = af.creerArticle("Tennis Nadal vs Federer", "#Sport", "Nemo quaeso miretur, si post exsudatos labores itinerum longos congestosque adfatim commeatus fiducia vestri ductante barbaricos pagos adventans velut mutato repente consilio ad placidiora deverti.", new Date(1422572400), -14.82472, -64.20465, "Brazil", momo, Status.REPORTASABUSED);
        Article a7 = af.creerArticle("Negociation sur le climat", "#Monde", "Primi igitur omnium statuuntur Epigonus et Eusebius ob nominum gentilitatem oppressi. praediximus enim Montium sub ipso vivendi termino his vocabulis appellatos fabricarum culpasse tribunos ut adminicula futurae molitioni pollicitos.", new Date(1422831600), 40.00496, -98.30622, "RU", bastien, Status.WAITFORVALIDATION);
        Article a8 = af.creerArticle("Rugby Victoire du RC Toulon", "#Sport", "Sed si ille hac tam eximia fortuna propter utilitatem rei publicae frui non properat, ut omnia illa conficiat, quid ego, senator, facere debeo, quem, etiamsi ille aliud vellet, rei publicae consulere oporteret?", new Date(1423350000), -25.37075, 135.13128, "France", bastien, Status.WAITFORVALIDATION);
        
        Comment c1 = cf.creerCommentaire("Coucou", momo);
        Comment c2 = cf.creerCommentaire("Yo", bastien);
        Comment c3 = cf.creerCommentaire("Re", momo);

        c1.setA_article(a1);
        c2.setA_article(a4);
        c3.setA_article(a4);
    }
}
