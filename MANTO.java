/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Murtaza Kazmi
 */
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MANTO
{
  static  int[][] grid=new int[480][844];
  
  //nnn
  public static void mountain()
  {
    File file = new File("C:\\Users\\HP\\Desktop\\ITP\\Colorado_844cols_480rows.dat");
    Scanner filaa = null;
    try
    {
      filaa = new Scanner(file);
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
      System.exit(1);
    }
    
    for(int i = 0;i < grid.length; i++)
    {
      for(int j= 0;j < grid[0].length; j++)
      {
        grid[i][j]= filaa.nextInt();
      }
    }
    
  } 
  //nnn
  public static int findMin()
  {
    int i= Integer.MAX_VALUE;
    for(int k =0;k < grid.length; k++)
    {
      for(int l = 0;l < grid[0].length; l++)
      {
        if(grid[k][l] < i)
        {
          i= grid[k][l];
        }
      }
    }
    return i;
  }
  //nnn
  public static int findMax()
  {
    int i = Integer.MIN_VALUE;
    for(int k = 0;k < grid.length; k++)
    {
      for(int l = 0; l < grid[0].length; l++)
      {
        if(grid[k][l] > i)
        {
          i= grid[k][l];
        }
      }
    }
    return i;
  }
  //nnn
  public static void drawmap()
  {
    StdDraw.setCanvasSize(grid[0].length,grid.length);
    StdDraw.setXscale(0,grid[0].length);
    StdDraw.setYscale(0,grid.length);
    int green=lowestindex();
    for(int m = 0;m < grid.length; m++)
    {
      for(int n= 0;n < grid[0].length; n++)
      {
        int less = findMin();
        int time = grid[grid.length-1-m][n];
        int more = findMax();
        
        double tmpor =255.0/(more-less);
        
        int dr = time-less;
        int c = (int)(1.0*tmpor*dr);
        
        if(c < 0)
        {
          c = c*-1;
        }
        
        Color gs=new Color(c,c,c);
        StdDraw.enableDoubleBuffering();
        StdDraw.setPenColor(gs);
        StdDraw.show();
        StdDraw.enableDoubleBuffering();
        StdDraw.filledSquare(n,m,0.5);
        StdDraw.show();
        
        
      }
    }
    
    
    int time=0, fwru=0;
    int nv=0,tmpor=0;
    int r=0, age=0;
    int lowval=0, i=0;
    int l=0;
    
    for(int rows= 0;rows < grid.length-1;rows++)
    {
      r=rows;
      for(int k = 0; k < grid[0].length-2; k++)
      {
        i=k;
        lowval=r-1;
        l=r+1;
        
        if(rows==green)
        {
          StdDraw.setPenColor(StdDraw.GREEN);
          
          StdDraw.filledSquare(k,r,0.5);
          time=grid[r][i];
          i=k+1;
          nv=time-grid[r][i];
          if(nv<0)
          {
            nv=nv*-1;
          }
          if(r!=0)
          {
            fwru=time-grid[lowval][i];
            if(fwru<0)
            {
              fwru=fwru*-1;
            }
          }
          if(r!=grid.length-1)
          {
            age=time-grid[l][i];
            if(age<0){
              age=age*-1;
            }
          }   
          
          if((fwru<nv)&&(r!=0))
          {
            
            tmpor=r-1;
            
          }  if((age<nv)&&(r!=grid.length-1))
          {
            
            tmpor=r+1;
            
          } if((age<fwru)&&(r!=0)&&(r!=grid.length-1))
          {
            
            tmpor=r+1;
            
          }
          if((fwru<age)&&(r!=0)&&(r!=grid.length-1))
          {
            
            tmpor=r-1;
            
          } 
          if(nv<fwru){
            
            tmpor=r;
            
          } 
          if(nv<age)
          {
            
            tmpor=r;
            
          } 
          r=tmpor;
        }
      } 
    }
  } 
  
  
  //nnn
  public static int lowestelevation(int r){
    
    int time=0, tmpor=r;
    int fwru=0, nv=0;
    int age=0;
    int totate=0, cmplt=0;
    int l=0, lowval=0;
    
    
    for(int k = 0;k < grid[0].length-2; k++)
    {
      int i= k;
      lowval = r-1;
      l = r+1;
      
      time = grid[r][i];
      i = k+1;
      nv = time-grid[r][i];
      if(nv < 0)
      {
        nv=nv*-1;
      }
      if(r!=0)
      {
        fwru=time-grid[lowval][i];
        if(fwru<0){
          fwru=fwru*-1;
        }
      }
      if(r!=grid.length-1)
      {
        age=time-grid[l][i];
        if(age<0)
        {
          age=age*-1;
        }
      }   
      if((fwru<nv)&&(r!=0))
      {
        tmpor=r-1;
        cmplt=fwru;
      }
      if((age<nv)&&(r!=grid.length-1))
      {
        tmpor=r+1;
        cmplt=age;
      }
      if((age<fwru)&&(r!=0)&&(r!=grid.length-1))
      {
        tmpor=r+1;
        cmplt=age;
      }
      if((fwru<age)&&(r!=0)&&(r!=grid.length-1))
      {
        tmpor=r-1;
        cmplt=fwru;
      }
      if(nv<fwru)
      {
        tmpor=r;
        cmplt=nv;    
      } 
      if(nv<age)
      {
        tmpor=r;
        cmplt=nv;
      } 
      
      totate=totate+cmplt;
      r=tmpor;
    } 
    
    return totate;
    
  }
  public static void display()
  {
    for(int i = 0;i < grid.length; i++)
    {
      for(int j = 0;j < grid[0].length; j++)
      {
        System.out.println(grid[i][j]);
      }
    }
  }
  public static int lowestindex()
  {
    int pre=lowestelevation(0);
    int display=0;
    int nv=0, time=0;
    int age=0, r=0;
    int whole=0, fwru=0;
    int tmpor=0, cmplt=0;
    int l=0, lowval=0;
    int i=0;
    
    for(int rows=0; rows < grid.length-1; rows++)
    {
      r = rows;
      cmplt= 0;
      for(int k= 0;k < grid[0].length-2; k++)
      {
        i=k;
        lowval=r-1;
        l=r+1;
        
        time=grid[r][i];
        i=k+1;
        nv=time-grid[r][i];
        if(nv<0)
        {
          nv=nv*-1;
        }
        if(r!=0)
        {
          fwru=time-grid[lowval][i];
          if(fwru<0)
          {
            fwru=fwru*-1;
          }
        }
        if(r!=grid.length-1)
        {
          age=time-grid[l][i];
          if(age<0)
          {
            age=age*-1;
          }
        }   
        
        if((fwru<nv)&&(r!=0))
        {
          whole=fwru;
        }  
        if((age<nv)&&(r!=grid.length-1))
        { 
          tmpor=r+1;
          whole=age;
        }
        if((age<fwru)&&(r!=0)&&(r!=grid.length-1))
        {
          tmpor=r+1;
          whole=age;
        }
        if((fwru<age)&&(r!=0)&&(r!=grid.length-1))
        {
         tmpor=r-1;
          whole=fwru;
        }
        if(nv<fwru)
        {
          tmpor=r;
          whole=nv;    
        } 
        if(nv<age)
        {
          tmpor=r;
          whole=nv;
        } 
        cmplt=cmplt+whole;
        r=tmpor; 
      } 
      if(cmplt<pre)
      {
        pre=cmplt;
        display=rows;   
      }
      
    }
    return display;
  }
  public static void main(String[] args)
  {
    mountain();
    StdDraw.enableDoubleBuffering();
    drawmap();
    StdDraw.show();
  }
  
}
