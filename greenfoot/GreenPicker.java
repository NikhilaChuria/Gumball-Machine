import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GreenPicker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GreenPicker extends Picker
{
   
    /**
     * Act - do whatever the GreenPicker wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }   
    
    public void greenPickerMessage()
    {
        int x = this.getX();
        int y = this.getY();
        DisplayMessage msg = new DisplayMessage("Yummy gumball for you.", Color.GREEN);

         if (!getWorld().getObjectsAt(x, y, DisplayMessage.class).isEmpty())  
        {  
            getWorld().removeObjects(getWorld().getObjects(DisplayMessage.class));
        }
         
        getWorld().addObject(msg,x,y);
    }
}
