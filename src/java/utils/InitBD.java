/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Startup;
import sessions.ArticleFacade;
import sessions.CommentFacade;
import sessions.FonctionFacade;
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
    ArticleFacade af;
    @EJB
    CommentFacade cf;
    @EJB
    FonctionFacade rf;
    @EJB
    UsersFacade uf;

    @PostConstruct // Appel après constructeur
    public void initialize() {
        System.out.println("BD initialisee");
        af.creerArticleTest();
        cf.creerCommentaireTest();
        uf.creerUtilisateurTest();
    }
}
