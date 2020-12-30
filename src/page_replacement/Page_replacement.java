package page_replacement;

//Sara Tarek & Ahmed Tamer 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

 
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
                      System.out.println("*-*-*-*-*-*");
                  
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
                      System.out.println("*-*-*-*-*-*");
                  
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
           for(int count1 = count2 - 1; count1 >=0 ; count1--)
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
           farthest=Frm[0];
         /*  if(farthest == 0)
            farthest = 200;*/
           for(int count1 = FSize-1; count1 > 0; count1--)
           {
           /* if(index[count1] == 0)
             index[count1] = 200;*/
            if(Frm[count1] < farthest)
            {
             farthest = Frm[count1];
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
                      System.out.println("*-*-*-*-*-*");
                  
              }
                }
      System.out.println("Number of Hits:- "+noOfHits+"  Number of PageFaults is :- "+FAULTCOUNT);   
}

public static void main(String[] args) throws IOException
   
   {
int sizeofframes,sizeofpages;
BufferedReader readthevalues =new BufferedReader(new InputStreamReader(System.in));
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
      System.out.println("*-*-*-*-*-*");
        //FIRSTINFIRSTOUT(sizeofframes,sizeofpages ,numofP );
        //optimalalgorithm(sizeofframes,sizeofpages,numofP);
        LeastRecentlyUsedALGO(sizeofframes,sizeofpages,numofP);
   }
    
}
