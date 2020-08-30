import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Inspector here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inspector extends Alien
{
    /**
     * Act - do whatever the Inspector wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Inspector()
    {
        GreenfootImage image = getImage() ;
        //image.scale( 350, 400 ) ;
    }
    
    public void act(Coin coin) 
    {
    }  

    public void inspect(Coin coin) {
        // Add your action code here.
        GreenPicker greenPicker = null;
        RandomPicker randomPicker = null;
        List<GreenPicker> greenPick = null;
        List<RandomPicker> randomPick = null;
        
        greenPick= (List<GreenPicker>)getWorld().getObjects(GreenPicker.class);
        greenPicker = (GreenPicker)greenPick.get(0); 
        
        randomPick= (List<RandomPicker>)getWorld().getObjects(RandomPicker.class);
        randomPicker = (RandomPicker)randomPick.get(0);
        
        if(coin instanceof FakeQuarter)
        {
            putMessage("Please do not use fake coin..", this.getX(),this.getY());

        }
        else if(coin instanceof Quarter){
        
            int GreenorRandom = Greenfoot.getRandomNumber(2);       
            putMessage("Good Coin.",this.getX(),this.getY());
            if(GreenorRandom ==0)//0-Greenpicker  1-RandomPicker
            {
                if(greenPick!=null)
                {                  
                    greenPicker.pickAGumBall(0);
                    greenPicker.greenPickerMessage();
                }
            }
            else
            {
               if(randomPick!=null)
                {
                    randomPicker.pickAGumBall(Greenfoot.getRandomNumber(3));
                    randomPicker.randomPickerMessage();
                }
            }
        }
        else
        {
            putMessage("Gumball costs a quater.", this.getX(),this.getY());
        }
    }  

    public void putMessage(String message, int x, int y) {

        DisplayMessage msg = new DisplayMessage(message, Color.RED);

         if (!getWorld().getObjectsAt(x, y, DisplayMessage.class).isEmpty()) {  
            getWorld().removeObject((DisplayMessage)getWorld().getObjectsAt(x, y, DisplayMessage.class).get(0));  
        }
         
        getWorld().addObject(msg,x,y);
    }

    public void clearMessage() {
        if (!getWorld().getObjectsAt(this.getX(), this.getY(), DisplayMessage.class).isEmpty())  
        {  
            getWorld().removeObject((DisplayMessage)getWorld().getObjectsAt(this.getX(), this.getY(), DisplayMessage.class).get(0));  
        }
    
    }
    
    
}
