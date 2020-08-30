import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Picker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Picker extends Alien
{
    /**
     * Act - do whatever the Picker wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    } 
    
    
    public void pickAGumBall(int ballColor)
    {
        switch(ballColor)
        {
            case 0: //put green gum ball
                     GreenGumball objGreenGumball =  new GreenGumball();
                      objGreenGumball.getImage().scale(60,60);
                       getWorld().addObject(objGreenGumball, 500, 530);
                    break;
            case 1: //put red gum ball
                    RedGumball objRedGumball =  new RedGumball();
                      objRedGumball.getImage().scale(60,60);
                     getWorld().addObject(objRedGumball, 500, 530);
                    break;
            case 2: //put blue gum ball
                    BlueGumball objBlueGumball =  new BlueGumball();
                     objBlueGumball.getImage().scale(60,60);
                     getWorld().addObject(objBlueGumball, 500, 530);
                    break;
                    
        }
        
        
    }
    
        public void clearMessage()
    {
        if (!getWorld().getObjectsAt(this.getX(), this.getY(), DisplayMessage.class).isEmpty())  
        {  
            getWorld().removeObject((DisplayMessage)getWorld().getObjectsAt(this.getX(), this.getY(), DisplayMessage.class).get(0));  
        }
    
    }
}
