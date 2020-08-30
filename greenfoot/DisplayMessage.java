import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class DisplayMessage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DisplayMessage extends Actor
{
    public DisplayMessage(String text, Color background){
        updateImage(text, background); 
    }
    public void setText(String text, Color background)  
    {  
        updateImage(text, background);  
    }  
      
    private void updateImage(String text, Color background)  
    {  
        setImage(new GreenfootImage(text, 30, Color.BLACK, background)); 
        
    }
}
