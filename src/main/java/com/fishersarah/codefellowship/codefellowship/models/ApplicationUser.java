package com.fishersarah.codefellowship.codefellowship.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
public class ApplicationUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String username;
    String password;
    String nameFirst;
    String nameLast;
    String dateOfBirth;
    String bio;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "owner")
    List<Post> postList;

    @ManyToMany
    @JoinTable(
            name = "followingUsers",
            joinColumns = { @JoinColumn(name = "userClickingFollow")},
            inverseJoinColumns = {@JoinColumn(name = "userAcceptingTheFollow")}
    )
    Set<ApplicationUser> usersIFollow;

    @ManyToMany(mappedBy = "usersIFollow")
    Set<ApplicationUser> usersThatFollowMe;

    public ApplicationUser(String username, String password, String nameFirst, String nameLast, String dateOfBirth, String bio) {
        this.username = username;
        this.password = password;
        this.nameFirst = nameFirst;
        this.nameLast = nameLast;
        this.dateOfBirth = dateOfBirth;
        this.bio = bio;
    }

    public ApplicationUser() {}

    public List<Post> getPosts() {
        return postList;
    }

    // ...Why don't we care about this one? Need to find the comment in FrontRow
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public long getId() {
        return id;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPosts(List<Post> posts) {
        this.postList = posts;
    }

    public Set<ApplicationUser> getUsersIFollow() {
        return usersIFollow;
    }

    public void setUsersIFollow(Set<ApplicationUser> usersIFollow) {
        this.usersIFollow = usersIFollow;
    }

    public Set<ApplicationUser> getUsersThatFollowMe() {
        return usersThatFollowMe;
    }

    public void setUsersThatFollowMe(Set<ApplicationUser> usersThatFollowMe) {
        this.usersThatFollowMe = usersThatFollowMe;
    }

    public void followUser(ApplicationUser userToBeFollowed) { // Need to check this against what I talked about with James
    }

}
