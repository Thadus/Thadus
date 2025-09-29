/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thadusv1;

import java.awt.Image;
import java.io.Serializable;

/**
 *
 * @author netha
 */
public class User implements Serializable{
    private String username;
    private String password;
    private int points;
    private Image avatar;
    private int votes;
    
    public User(String username, String password, int points, Image avatar, int votes) {
        this.username = username;
        this.password = password;
        this.points = points;
        this.avatar = avatar;
        this.votes = votes;
    }
    
    public void setUserName(String username) {
        this.username = username;
    }
    public String getUserName() {
        return username;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPoints(int points) {
        this.points = points;
    }
    
    public int getPoints() {
        return points;
    }
    
    public void setAvatar(Image avatar) {
        this.avatar = avatar;
    }
    
    public Image getAvatar() {
        return avatar;
    }
    
    public void setVotes(int votes) {
        this.votes = votes;
    }
    
    public int getVotes() {
        return votes;
    }
    
    
    
    
    
    
}
