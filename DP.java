

import java.util.Scanner;


class DP {
     
static int R=0;
static int C=0;
static int rot_count=0,fresh_count=0;
static boolean matrix_limit(int i, int j)
{
    if (i >= 0 && i < R && j >= 0 && j < C)
        return true;
    else   
        return false;
}
  
static int rottedOranges(int v[][])
{
    boolean affect = false;
    int no= 2;
     
    while (true) 
    {
        for(int i = 0; i < R; i++) 
        {
            for(int j = 0; j < C; j++)
            {
                 
       
                if (v[i][j] == no) 
                {
                    if (matrix_limit(i + 1, j) && 
                             v[i + 1][j] == 1)
                    {
                        v[i + 1][j] = v[i][j] + 1;
                        affect = true;
                    }
                    if (matrix_limit(i, j + 1) && 
                             v[i][j + 1] == 1) 
                    {
                        v[i][j + 1] = v[i][j] + 1;
                        affect = true;
                    }
                    if (matrix_limit(i - 1, j) &&
                             v[i - 1][j] == 1)
                    {
                        v[i - 1][j] = v[i][j] + 1;
                        affect = true;
                    }
                    if (matrix_limit(i, j - 1) && 
                             v[i][j - 1] == 1)
                    {
                        v[i][j - 1] = v[i][j] + 1;
                        affect = true;
                    }
                }
            }
        }
  
        if (!affect)
            break;
             
        affect = false;
        no++;
    }
  
    for(int i = 0; i < R; i++)
    {
        for(int j = 0; j < C; j++) 
        {
            if(v[i][j]==1)
                fresh_count++;
            if(v[i][j]!=0)
            rot_count++;
            if (v[i][j]== 1)
                return -1;
        }
    }
    return no-2 ;
}
    
    public static void main(String args[]) {
         
        Scanner sc= new Scanner(System.in);    //System.in is a standard input stream  
System.out.print("Enter Row nad Col- ");  
R= sc.nextInt();
C= sc.nextInt();
int v[][]=new int[R][C];
System.out.println("Enter Matrix : ");
for(int i = 0; i < R; i++)
    {
        for(int j = 0; j < C; j++) {
            v[i][j]=sc.nextInt();
        }
    }
    System.out.println("time frame: " +rottedOranges(v)+"\nfresh oranges:"+fresh_count+"\nRotten oranges:"+rot_count);
    }
}