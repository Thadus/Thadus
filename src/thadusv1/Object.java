/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thadusv1;

import java.awt.Image;
import java.io.File;
import java.util.HashMap;
import javax.sound.sampled.AudioInputStream;

/**
 *
 * @author netha
 */
public class Object {
    
    
    public static HashMap<String,String> objects = new HashMap<>();
    public static String objectname;
    private Image objectimage;
    private Image objectbackground;
    private Image objecttarget;
    private int objectspeed;
    private AudioInputStream objectsound;
   
    
    public Object(String objectname, Image objectimage, Image objectbackground, int objectspeed, Image objecttarget, AudioInputStream objectsound) {
        this.objectname = objectname;
        this.objectimage = objectimage;
        this.objectbackground = objectbackground;
        this.objectspeed = objectspeed;
        this.objecttarget = objecttarget;
        this.objectsound = objectsound;
    }
    

    public static void Object(String response) {
        if (response.contains("new object")) {
            objectname = response.replace("= new object", "").trim();
            objects.put("object", objectname);
        }
    }



public String getObjectName() {
    return objectname;
}


public Image getObjectImage() {
    return objectimage;
}

public Image getObjectBackground() {
    return objectbackground;
}

public int getObjectSpeed() {
    return objectspeed;
}

public Image getObjectTarget(){
    return objecttarget;
}
 
public AudioInputStream getObjectSound() {
    return objectsound;
}


}