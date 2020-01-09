import java.util.*;
import java.lang.*;
class Simple2
{
	public static void main(String args[])
	{
		final int width=12,length=18;
		int x1[]=new int[12];
		int y1[]=new int[12];
		int x2[]=new int[6];
		int y2[]=new int[6];
		int x3[]=new int[6];
		int y3[]=new int[6];
		int count=0;
		int g1_x=(width-1)/2,g2_x=(width-1)/2,g1_y=(length-1)/2,g2_y=(length-1)/2;
		
		List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		List<ArrayList<Integer>> matched_list = new ArrayList<ArrayList<Integer>>();
		List<ArrayList<Integer>> final_list=new ArrayList<ArrayList<Integer>>();
		
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<12;i++)
		{
        Integer a=sc.nextInt();
        Integer b=sc.nextInt();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(a);
        temp.add(b);
        list.add(temp);
		}
		
		for (int i = 0; i < list.size(); i++)
		{ 
					 
				x1[i]=list.get(i).get(0);
				y1[i]=list.get(i).get(1);	
				System.out.println(x1[i] + "," + y1[i]);
		
   
        } 
		//3 2 2 2 3 3 4 4 5 5 6 6 7 7 8 8 9 9 10 10 11 11 12 12
		//1 1 1 2 3 4 4 5 5 6 5 5 6 7 6 8 7 9 8 10 9 10 11 11
		int current_x=x1[0],current_y=y1[0],pass_threshold=0,is_nearby_threshold=0,area=0;
		for(int i=1;i<6;i++)
		{
			
				if(Math.sqrt(((current_x-x1[i])*(current_x-x1[i]))+((current_y-y1[i])*(current_y-y1[i])))<=1.2d)
				{
					count++;
					System.out.println("Values are *****");
					System.out.println("(" + current_x + "," + current_y + ")" + "," + "(" + x1[i] + "," + y1[i] + ")");
					ArrayList<Integer> matched_temp = new ArrayList<Integer>();
					matched_temp.add(x1[i]);
					matched_temp.add(y1[i]);
					System.out.println(x1[i]+" "+y1[i] + " "+ matched_temp);
					
					matched_list.add(matched_temp);		
				}
		}
		
		System.out.println("Matched list is:" + matched_list);
		for (int i = 0; i < matched_list.size(); i++)
		{ 
					 
				x2[i] = matched_list.get(i).get(0);
				y2[i] = matched_list.get(i).get(1);	
				System.out.println(x2[i] + "," + y2[i]);
   
        }
        int k=0;
        while(k<matched_list.size())
        { 
			int count_of_non_obstacles=0;
			for(int i=6;i<12;i++)
			{
				if(x1[i]>x2[k] && x1[i]>current_x && y1[i]>y2[k] && y1[i]>current_y)
				{
					count_of_non_obstacles++;		
				}
				else
				{
					k++;
				}
				if(i==11 && count_of_non_obstacles==6)
				{
					ArrayList<Integer> final_temp = new ArrayList<Integer>();
					final_temp.add(x2[k]);
					final_temp.add(y2[k]);
					final_list.add(final_temp);
					//System.out.println(x2[k] + "," + y2[k]);
				}
			}
			System.out.println("No. of non obstacles are " + count_of_non_obstacles);
			k++;
		}
		
		for (int i = 0; i < final_list.size(); i++)
		{ 
					 
				x3[i]=final_list.get(i).get(0);
				y3[i]=final_list.get(i).get(1);
				System.out.println("Final list values are: ");	
				System.out.println(x3[i] + "," + y3[i]);
        } 
        int pole_dis1_count=0,pole_dis2_count=0;
        for(int i=0;i<final_list.size();i++)
        {
			for(int j=1;j<final_list.size();j++)
			{
				if((Math.sqrt(((g1_x-x3[i])*(g1_x-x3[i]))+((g1_y-y3[i])*(g1_y-y3[i])))) < (Math.sqrt(((g1_x-x3[i])*(g1_x-x3[j]))+((g1_y-y3[j])*(g1_y-y3[j])))))
				{
					pole_dis1_count++;
				
				}
				/*if((Math.sqrt(((g2_x-x3[i])*(g2_x-x3[i]))+((g2_y-y3[i])*(g2_y-y3[i])))) < (Math.sqrt(((g2_x-x3[i])*(g2_x-x3[j]))+((g2_y-y3[j])*(g2_y-y3[j])))))
				{
					pole_dis2_count++;
				}*/
				
			}
			if(pole_dis1_count==final_list.size()-1)
			{
				System.out.println("This is our required bot of co:ordinates" + "(" + x3[i] + "," + y3[i] + ")");
			}
		}
        
		
		System.out.println("-----------------");
		System.out.println("Count = " + count);
 
	}
}

