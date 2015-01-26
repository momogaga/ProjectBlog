/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;

/**
 *
 * @author MoMo
 */
@Entity
@NamedQuery(
    name="findCommentByArticle",
    query="SELECT c FROM Comment c WHERE c.a_article.id = :article"
)
public class Comment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String comment;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date commented_date;
    
    @ManyToOne
    private Users a_commente;
    
    @ManyToOne 
    private Article a_article;

    public Comment() {
    }   
       
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCommented_date() {
        return commented_date;
    }

    public void setCommented_date(Date commented_date) {
        this.commented_date = commented_date;
    }

    public Users getA_commente() {
        return a_commente;
    }

    public void setA_commente(Users a_commente) {
        this.a_commente = a_commente;
    }

    public Article getA_article() {
        return a_article;
    }

    public void setA_article(Article a_article) {
        this.a_article = a_article;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comment)) {
            return false;
        }
        Comment other = (Comment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Comment[ id=" + id + " ]";
    }
    
}
