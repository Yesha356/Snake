
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 *
 *
 * @author umesha
 */
public class gameplay extends JPanel implements KeyListener, ActionListener { 
    private int[] snakeXlength=new int[750];
    private int[] snakeYlength=new int[750];
    
    private boolean left=false;
    private boolean right=false;
    private boolean up=false;
    private boolean down=false;
    
    private ImageIcon rightmouth;
    private ImageIcon upmouth;
    private ImageIcon leftmouth;
    private ImageIcon downmouth;
    
    //length of snake=los
    private int los=3;
    
    private int score=0;
    
    private Timer timer ;
    private int delay =100;
    private ImageIcon snakeimage;
    private int moves=0;
    
    private int [] enemyxpos={25,50,75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600,625,650,675,700,725,750,775,800,825,850};
    private int [] enemyypos={75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600,625};
  
    
    private ImageIcon enemyimage;
    private Random random = new Random();
    
    private int xpos= random.nextInt(34);
    private int ypos=random.nextInt(23);
    
    
    
    private ImageIcon titleImage;
    public gameplay()
    { addKeyListener(this);
     setFocusable(true);
     setFocusTraversalKeysEnabled(false);
     timer= new Timer(delay,this);
     timer.start();
     
   
    }
    
    public void paint (Graphics g)
    {
        if(moves==0)
        { snakeXlength[2]=50;
          snakeXlength[1]=75;
          snakeXlength[0]=100;
          
          snakeYlength[2]=100;
          snakeYlength[1]=100;
          snakeYlength[0]=100;
          
          
          
        
        }
        
        //draw titleimg border
        g.setColor(Color.white);
        g.drawRect(24,10,851,55);
        
        //draw title img
        titleImage=new ImageIcon("snaketitle.jpg");
        titleImage.paintIcon(this,g,25,11);
        
        //draw border for gameplay
        g.setColor(Color.white);
        g.drawRect(24, 74, 851, 577);
        
        //draw bgrnd for gameplay
        g.setColor(Color.black);
        g.fillRect(25, 75, 850, 575);
        
        // draw score 
        g.setColor(Color.white);
        g.setFont(new Font("arial",Font.PLAIN,14));
        g.drawString("scores:"+score,780,30);
        
        
        // draw length of snake
        g.setColor(Color.white);
        g.setFont(new Font ("arial",Font.PLAIN,14));
        g.drawString("Length:" +los,780,50);
        
        
        
        rightmouth= new ImageIcon("rightmouth.png");
        rightmouth.paintIcon(this, g, snakeXlength[0], snakeYlength[0]);
        for(int i=0; i< los ;i++)
        {
            if(i==0 && right)
            { rightmouth= new ImageIcon("rightmouth.png");
              rightmouth.paintIcon(this, g, snakeXlength[i], snakeYlength[i]);
            }
            if(i==0 && left)
            { leftmouth= new ImageIcon("leftmouth.png");
              leftmouth.paintIcon(this, g, snakeXlength[i], snakeYlength[i]);
            }
            if(i==0 && up)
            { upmouth= new ImageIcon("upmouth.png");
              upmouth.paintIcon(this, g, snakeXlength[i], snakeYlength[i]);
            }
            if(i==0 && down)
            { downmouth= new ImageIcon("downmouth.png");
              downmouth.paintIcon(this, g, snakeXlength[i], snakeYlength[i]);
            }            
            if(i!=0)
            {            
             snakeimage= new ImageIcon("snakeimage.png");
             snakeimage.paintIcon(this, g, snakeXlength[i], snakeYlength[i]);
            
            }
        }
        
        enemyimage= new ImageIcon("enemy.png");
        
        if((enemyxpos[xpos]== snakeXlength[0] && enemyypos[ypos]==snakeYlength[0]))
        {score++;
         los++;
         xpos= random.nextInt(34);
         ypos= random.nextInt(23);
        }
        enemyimage.paintIcon(this, g, enemyxpos[xpos], enemyypos[ypos]);
        
        for(int b=1;b<los;b++)
        {
            if( snakeXlength[b]==snakeXlength[0]&& snakeYlength[b]==snakeYlength[0])
            {
                right=false;
                left=false;
                up=false;
                down=false;
                
                g.setColor(Color.white);
                g.setFont(new Font ("arial",Font.BOLD,50));
                g.drawString("GAME OVER",300,300);
                
                g.setFont(new Font ("arial",Font.BOLD,20));
                g.drawString("space to RESET",350,340);
                
                
                
                
                
            }
        }
        
        g.dispose();
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode()==KeyEvent.VK_SPACE)
        {   moves=0;
            score=0;
            los=3;
            repaint();
        }
        if(ke.getKeyCode()==KeyEvent.VK_RIGHT)
        { moves++;
          right=true ;
          if(!left)
          {right=true;
          }
          else
          {right=false;
           left=true;
          }
          
          up=false;
          down=false;
        }
        if(ke.getKeyCode()==KeyEvent.VK_LEFT)
        { moves++;
          left=true ;
          if(!right)
          {left=true;
          }
          else
          {left=false;
           right=true;
          }
          
          up=false;
          down=false;
        }
        if(ke.getKeyCode()==KeyEvent.VK_UP)
        { moves++;
          up=true ;
          if(!down)
          {up=true;
          }
          else
          {up=false;
           down=true;
          }
          left=false;
          
          right=false;
        }
        if(ke.getKeyCode()==KeyEvent.VK_DOWN)
        { moves++;
          down=true ;
          if(!up)
          {down=true;
          }
          else
          {down=false;
           up=true;
          }
          left=false;
         
          right=false;
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        timer.start();
        if(right)
        { for(int r=los-1; r>=0; r--)
            { 
               snakeYlength [r+1]= snakeYlength[r];
            }
          for( int r =los;r>=0;r--)
            {
                if(r==0)
                { snakeXlength[r]=snakeXlength[r]+25;
                }
                else
                { snakeXlength[r]=snakeXlength[r-1];
                }
                if(snakeXlength[r]>850)
                {
                    snakeXlength[r]=25;
                }
                
            }
          repaint();
        }
        
        
        if(left)
        {
            for(int r=los-1; r>=0; r--)
            { 
               snakeYlength [r+1]= snakeYlength[r];
            }
            for( int r =los;r>=0;r--)
            {
                if(r==0)
                { snakeXlength[r]=snakeXlength[r]-25;
                }
                else
                { snakeXlength[r]=snakeXlength[r-1];
                }
                if(snakeXlength[r]<25)
                {
                    snakeXlength[r]=850;
                }
                
            }
          repaint();
        }
        
        
        if(up)
        {
            for(int r=los-1; r>=0; r--)
            { 
               snakeXlength [r+1]= snakeXlength[r];
            }
            for( int r =los;r>=0;r--)
            {
                if(r==0)
                { snakeYlength[r]=snakeYlength[r]-25;
                }
                else
                { snakeYlength[r]=snakeYlength[r-1];
                }
                if(snakeYlength[r]<75)
                {
                    snakeYlength[r]=625;
                }
                
            }
          repaint();
        }
        
        
        if(down)
        {
            for(int r=los-1; r>=0; r--)
            { 
               snakeXlength [r+1]= snakeXlength[r];
            }
          for( int r =los;r>=0;r--)
            {
                if(r==0)
                { snakeYlength[r]=snakeYlength[r]+25;
                }
                else
                { snakeYlength[r]=snakeYlength[r-1];
                }
                if(snakeYlength[r]>625)
                {
                    snakeYlength[r]=75;
                }
                
            }
          repaint();
        }
        
    }
}
