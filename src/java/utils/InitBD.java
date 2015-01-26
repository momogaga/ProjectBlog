/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entities.Article;
import entities.Comment;
import entities.Users;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
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

        // Role r1 = rf.creerRole("Admin");
        // Role r2 = rf.creerCommentaire("User");
        Users momo = uf.creerUtilisateur("admin", "admin", "momo", "gaga", new Date(), "New");
        Users bastien = uf.creerUtilisateur("user", "user", "bastien", "maria", new Date(), "Disc");

        Article a1 = af.creerArticle("Title", "Key", "Nouveaute du jour", new Date(), 45.777168, 3.082417, "Nice", momo);
        Article a2 = af.creerArticle("Blog", "Pizza", "Blalalalaa", new Date(), 45.777168, 3.082417, "Nice", momo);
        Article a3 = af.creerArticle("Coupe", "Retour", "Bon bon bon", new Date(), 45.777168, 3.082417, "Nice", bastien);
        Article a4 = af.creerArticle("Fete", "Tag", "Bablablablablabla", new Date(), 45.777168, 3.082417, "Nice", bastien);

        Comment c1 = cf.creerCommentaire("Coucou", momo);
        Comment c2 = cf.creerCommentaire("Yo", bastien);
        Comment c3 = cf.creerCommentaire("Re", momo);

        c1.setA_article(a1);
        c2.setA_article(a4);
        c3.setA_article(a4);

        //List<Comment> comments;
        //comments = new ArrayList<>();
        //comments.add(c1);
        //comments.add(c2);

        //a4.setComments(comments);

    }
}
