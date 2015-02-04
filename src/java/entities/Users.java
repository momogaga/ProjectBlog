/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.net.URL;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author MoMo
 */
@Entity
@NamedQuery(
        name = "findUserByUsernameAndPassword",
        query = "SELECT u FROM Users u WHERE u.username = :username AND u.password = :password"
)
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstname;
    private String lastname;
    private String about;
    private URL photo;
    private String username;
    private String password;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date last_connect;
    private UserStatus user_status;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a_ecrit")
    private List<Article> articles;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a_commente")
    private List<Comment> comments;
    @ManyToOne
    private Role a_role;

    public Users() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public URL getPhoto() {
        return photo;
    }

    public void setPhoto(URL photo) {
        this.photo = photo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLast_connect() {
        return last_connect;
    }

    public void setLast_connect(Date last_connect) {
        this.last_connect = last_connect;
    }

    public UserStatus getUser_status() {
        return user_status;
    }

    public void setUser_status(UserStatus user_status) {
        this.user_status = user_status;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Role getA_role() {
        return a_role;
    }

    public void setA_role(Role a_role) {
        this.a_role = a_role;
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
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.User[ id=" + id + " ]";
    }

}
