package page_replacement;

//Sara Tarek & Ahmed Tamer 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

 
public class Page_replacement 
{
    static void FIRSTINFIRSTOUT(int FSize,int PSize,int PagesARRAY[])
    {
        int k=0,FAULTCOUNT=0,noOfswaps=0;
         int Frm[]=new int[FSize];
       for(int count1=0;count1<FSize;count1++)
       {
           Frm[count1]=-1;
       }
       boolean Matching;
      for(int count2=0;count2<PSize;count2++)
            {
                        Matching=false;
                                for(int count1=0;count1<FSize;count1++)
                                if(Frm[count1]==PagesARRAY[count2])
                                {
                                        Matching=true;
                                        noOfswaps=noOfswaps+1;
                                        System.out.println("HIT(No page replacement)");
                                }
                                if(Matching==false)
                                {
                                        Frm[k]=PagesARRAY[count2];
                                        k++;
                                        if(k>=FSize)
                                        k=0;
                                        FAULTCOUNT=FAULTCOUNT+1;
                                        System.out.println("Page fault is found");
                                }
                       for(int count3=0;count3<FSize;count3++)
              {
                  System.out.println(Frm[count3]);
                  if(count3==FSize-1)
                      System.out.println("-----");
                  
              }
                }
      System.out.println("Number of Swaps:- "+noOfswaps+"  Number of PageFaults is :- "+FAULTCOUNT);
       }
   
   
        
public static void optimalalgorithm(int FSize,int PSize, int PagesARRAY[])
    {     
        int currentIndex=0,FAULTCOUNT=0,noOfHits=0,locationidf=0;
        boolean isFull=false;
        int Frm[]=new int[FSize];
        for(int count1=0;count1<FSize;count1++)
       {
           Frm[count1]=-1;
       }
        for(int count2 = 0; count2<PSize; count2++)
        {
         int search = -1;
         for(int count1= 0; count1 < FSize; count1++)
         {
          if(Frm[count1] == PagesARRAY[count2])
          {
           search = count1;
            System.out.println("HIT(No page replacement)");
           noOfHits=noOfHits+1;
           break;
          } 
         }
        if(search == -1)
         {
          if(isFull)
          {
           int index[] = new int[FSize];
           boolean index_flag[] = new boolean[FSize];
           for(int count1 = count2 + 1; count1 < PSize; count1++)
           {
            for(int count3 = 0; count3 < FSize; count3++)
            {
             if((PagesARRAY[count1] == Frm[count3]) && (index_flag[count3] == false))
             {
              index[count3] = count1;
              index_flag[count3] = true;
              break;
             }
            }
           }
           int farthest = index[0];
           locationidf = 0;
           if(farthest == 0)
            farthest = 200; //3shan yfdal rakam kebir lama ykhalas el loop w yheelo
           for(int count1 = 0; count1 < FSize; count1++)
           {
            if(index[count1] == 0)
             index[count1] = 200;
            if(index[count1] >  farthest)
            {
             farthest = index[count1];
             locationidf = count1;
            }
           }
          }
          Frm[locationidf] = PagesARRAY[count2];
          System.out.println("Page fault is found");
          FAULTCOUNT=FAULTCOUNT+1;
          if(!isFull)
          {
          locationidf++;
              if(locationidf == FSize)
              {
               locationidf = 0;
               isFull = true;
              }
          }
         }
        
        for(int count3=0;count3<FSize;count3++)
              {
                  System.out.println(Frm[count3]);
                  if(count3==FSize-1)
                      System.out.println("-----");
                  
              }
                }
      System.out.println("Number of Hits:- "+noOfHits+"  Number of PageFaults is :- "+FAULTCOUNT);
            }
    

public static void LeastRecentlyUsedALGO(int FSize,int PSize, int PagesARRAY[])
{
 int currentIndex=0,FAULTCOUNT=0,noOfHits=0,locationidf=0;
        boolean isFull=false;
        int Frm[]=new int[FSize];
        for(int count1=0;count1<FSize;count1++)
       {
           Frm[count1]=-1;
       }
        for(int count2 = 0; count2<PSize; count2++)
        {
         int search = -1;
         for(int count1= 0; count1 < FSize; count1++)
         {
          if(Frm[count1] == PagesARRAY[count2])
          {
           search = count1;
            System.out.println("HIT(No page replacement)");
           noOfHits=noOfHits+1;
           break;
          } 
         }
        if(search == -1)
         {
          if(isFull)
          {
           int index[] = new int[FSize];
           boolean index_flag[] = new boolean[FSize];
      /*     for(int count1 = count2 - 1; count1 >=0 ; count1--)
          {
            for(int count3 = 0; count3 < FSize; count3++)
            {
             if((PagesARRAY[count1] == Frm[count3]) && (index_flag[count3] == false))
             {
              index[count3] = count1;
              index_flag[count3] = true;
              break;
             }
            }
           }*/
      for (int i=0;i<count2-1;i++)
      {
          for(int j=0;j<FSize;j++){
          if(PagesARRAY[i] == Frm[j])
          {
              index[j]=i;
          }
      }}
           int farthest = index[0];
           locationidf = 0;
          // farthest=in[0];
         /*  if(farthest == 0)
            farthest = 200;*/  boolean found=false;   
           for(int count1 = FSize-1; count1 >= 0; count1--)
           {
           /* if(index[count1] == 0)
             index[count1] = 200;*/
              
          
            if(index[count1] <=farthest&&found==false)
            {
             farthest = Frm[count1];
             locationidf = count1;
             found =true;
            }
           }
          }
          Frm[locationidf] = PagesARRAY[count2];
          System.out.println("Page fault is found");
          FAULTCOUNT=FAULTCOUNT+1;
          if(!isFull)
          {
          locationidf++;
              if(locationidf == FSize)
              {
               locationidf = 0;
               isFull = true;
              }
          }
         }
        
        for(int count3=0;count3<FSize;count3++)
              {
                  System.out.println(Frm[count3]);
                  if(count3==FSize-1)
                      System.out.println("-----");
                  
              }
                }
      System.out.println("Number of Hits:- "+noOfHits+"  Number of PageFaults is :- "+FAULTCOUNT);   
}




public static void LRUPageReplacement()
{

Scanner in = new Scanner(System.in);
        int frames = 0;
        int pointer = 0;
        int fault = 0;
        int ref_len = 0;
        Boolean isFull = false;
        char mem[];
        ArrayList<Character> stack = new ArrayList<Character>();
        char refestring[]= new char[] {'7','0','1','2','0','3','0','4','2','3','0','3','2','1','2','0','1','7','0','1'};
        ref_len=refestring.length;

        System.out.println("Please enter a reference string:"
            + "\n7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0,1,7,0,1");

        System.out.println("Please enter the number of Frames: ");
        frames = Integer.parseInt(in.nextLine());
        System.out.print("Starting Memory is:");
        for(int w=0;w<frames;w++)
            System.out.print(" * ");

        mem = new char[frames];
        for(int j = 0; j < frames; j++)
            mem[j] = '*';

        System.out.println();
        for(int i = 0; i < ref_len; i++){
            if(stack.contains(refestring[i])){
                stack.remove(stack.indexOf(refestring[i]));
            }
            stack.add(refestring[i]);
            int search = -1;
            for(int j = 0; j < frames; j++){
                if(mem[j] == refestring[i]){

                    search = j;

                    System.out.print(refestring[i]+": Memory is:");
                    for(int w = 0; w < frames; w++){
                        System.out.printf("%3c ",mem[w]);}
                    System.out.println("Hit: (Number of Page Faults: "+fault+")");
                    break;
                }
            }
            if(search == -1){
                if(isFull){
                    int min_loc = ref_len;
                    for(int j = 0; j < frames; j++){     
                        if(stack.contains(mem[j])){ 
                            int temp = stack.indexOf(mem[j]);
                            if(temp < min_loc){

                                min_loc = temp;
                                pointer = j;
                            }
                        }
                    }
                }
                mem[pointer] = refestring[i];
                fault++;
                System.out.print(refestring[i]+": Memory is:");
                for(int w = 0; w < frames; w++){
                    System.out.printf("%3c ",mem[w]);}
                System.out.println("Page Fault: (Number of Page Faults: "+fault+")");
                pointer++;
                if(pointer == frames){
                    pointer = 0;
                    isFull = true;
                }
            }
        }
        System.out.println("Total number of Faults: " + fault);
    

}
public static void main(String[] args) throws IOException
        {
            int choice;
            int sizeofframes,sizeofpages;  
            System.out.println("-----");
            System.out.println(" Choose the algorithms: ");
            System.out.println("FIFO press 1");
            System.out.println("Optimal Press 2");
            System.out.println("LRU press 3");
       
            BufferedReader readthevalues =new BufferedReader(new InputStreamReader(System.in));
          
            
          
            choice = Integer.parseInt(readthevalues.readLine());
            while ( choice > 3 || choice < 1)
            {
                System.out.println("wrong input please enter 1 or 2 or 3");
                choice=Integer.parseInt(readthevalues.readLine());
            }
            switch(choice)
            {
                case 1:
                      System.out.println("Number of frames to be inserted is: ");
            sizeofframes=Integer.parseInt(readthevalues.readLine());     
            System.out.println("Number of pages to be inserted is :");
            sizeofpages=Integer.parseInt(readthevalues.readLine());
            int numofP[]=new int[sizeofpages];
            System.out.println("please enter your values :");
            for(int arraycounter=0;arraycounter<sizeofpages;arraycounter++)
            {
                numofP[arraycounter]=Integer.parseInt(readthevalues.readLine());
            }
                    FIRSTINFIRSTOUT(sizeofframes,sizeofpages ,numofP );
                    break;
                    
                 case 2:
                       System.out.println("Number of frames to be inserted is: ");
            sizeofframes=Integer.parseInt(readthevalues.readLine());     
            System.out.println("Number of pages to be inserted is :");
            sizeofpages=Integer.parseInt(readthevalues.readLine());
            int numofPo[]=new int[sizeofpages];
            System.out.println("please enter your values :");
            for(int arraycounter=0;arraycounter<sizeofpages;arraycounter++)
            {
                numofPo[arraycounter]=Integer.parseInt(readthevalues.readLine());
            }
                    optimalalgorithm(sizeofframes,sizeofpages,numofPo); 
                    break;
                 case 3: 
                    LRUPageReplacement();
                   break;
            }
       
            
           
           
            
        }     
       }