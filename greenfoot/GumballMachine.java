import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class GumballMachine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GumballMachine extends Actor
{

    Coin coin = null;
    boolean isCranked = true;
    Inspector inspector = null;
    DisplayMessage displayMessage = null;
    
    public GumballMachine()
    {
        GreenfootImage image = getImage() ;
        image.scale( 350, 400 ) ; 
    }

    public void act() 
    {

        // 1. Check coing inserted. 
        // 2. True: isCranked is true
        // 3. Coin to be validated by Inspector
        
        if(getOneIntersectingObject(Coin.class)!=null)
        {
            List<Inspector> instruct = null;
            coin = (Coin)getOneIntersectingObject(Coin.class);
            
            //setting coin to be near to the mouth
            if(coin.getX() > this.getX()-30 && coin.getX() < this.getX()+30 && coin.getY() > this.getY()+20 && coin.getY() < this.getY()+50)
            {

               putMessage("Please crank",this.getX(),this.getY());
               instruct = (List<Inspector>)getWorld().getObjects(Inspector.class);
               inspector = instruct.get(0);
               
               getWorld().removeObject(coin);
               isCranked = false;
            }
        }
        
        //Logic of mouse click i.e. cranking
        if(Greenfoot.mousePressed(this))
        {
            Picker picker = getWorld().getObjects(GreenPicker.class).get(0);
            picker.clearMessage();
            inspector.clearMessage();
            
            if(!isCranked) 
            {          
                MouseInfo mouse = Greenfoot.getMouseInfo();  
                int mouseX=mouse.getX();  
                int mouseY=mouse.getY();  
                isCranked = false;
                if(mouseX > this.getX()-100 && mouseX < this.getX()+100 ) 
                {
                    isCranked = true;
                    if (!getWorld().getObjectsAt(this.getX(), this.getY(), DisplayMessage.class).isEmpty())  
                    {  
                       getWorld().removeObject((DisplayMessage)getWorld().getObjectsAt(this.getX(), this.getY(), DisplayMessage.class).get(0));  
                    }
                   inspector.inspect(coin);
                }       
            }
        }
    
    }   
    
    
    
    public void putMessage(String message, int x, int y)//display message
    {
        DisplayMessage msg = new DisplayMessage(message, Color.RED);
        if (!getWorld().getObjectsAt(x, y, DisplayMessage.class).isEmpty())  
        {  
            getWorld().removeObject((DisplayMessage)getWorld().getObjectsAt(x, y, DisplayMessage.class).get(0));  
        }
        getWorld().addObject(msg,x,y);
    }
}
