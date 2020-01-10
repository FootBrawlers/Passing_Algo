import java.util.*;
import java.lang.*;
import java.io.*;
class Simple2
{
	public static void main(String args[])
	{
		int[] get_x=new int[12];
		int[] get_y=new int[12];
		int x1[]=new int[12];
		int y1[]=new int[12];
		int id_array1[]=new int[12];
		//int id_array2[]=new int[12];
		ArrayList<Integer> id=new ArrayList<Integer>();
		ArrayList<Integer> id_list2=new ArrayList<Integer>();
		ArrayList<Integer> id_list3=new ArrayList<Integer>();
		BufferedReader br=null;
		try
		{
			File file = new File("C:\\Users\\TejaswiKarasani\\Desktop\\Passing_Algo\\input.txt");
			br = new BufferedReader(new FileReader(file));
			List<Integer[]> read_list = new ArrayList<Integer[]>();
			String st=new String();
			for(int i=0;i<12;i++)
			{
			while ((st = br.readLine()) != null)
			{
				Integer everything[]=new Integer[3];
				String temp[] = st.split(" ");
				everything[0]=Integer.parseInt(temp[0]);
				everything[1]=Integer.parseInt(temp[1]);
				everything[2]=Integer.parseInt(temp[2]);
				read_list.add(everything);
				
				//System.out.println(st[i]); 
			}
			/*for(int x:read_list.get(i))
			{
				//System.out.print(x+" "); //]+" "+read_list.get(i)[1]+" "+read_list.get(i)[2]);
			}*/}
			
			for(int i=0;i<12;i++)
			{
				id_array1[i]=read_list.get(i)[0];
				get_x[i]=read_list.get(i)[1];
				get_y[i]=read_list.get(i)[2];
			}
			//System.out.println();
		}
		catch (IOException e) {

			e.printStackTrace();

		} 
		finally {

			try {
					if (br != null)
						br.close();
				} 
			catch (IOException ex) {
					ex.printStackTrace();
				}
		} 
		
		/*for (int i = 0; i < read_list.size(); i++)
		{ 
					 
				get_x[i]=read_list.get(1);
				get_y[i]=read_list.get(2);	
				System.out.println(get_x[i] + "," + get_y[i]);
        } */
        //System.out.println(read_list);
        
        for(int i=0;i<12;i++)
        {
			System.out.println(id_array1[i] + "," + get_x[i] + "," + get_y[i]);
		}
		
		
		
		final int width=12,length=18;
		//int x1[]=new int[12];
		//int y1[]=new int[12];
		int x2[]=new int[6];
		int y2[]=new int[6];
		int x3[]=new int[6];
		int y3[]=new int[6];
		int count=0;
		int g1_x=0,g2_x=(width-1)/2,g1_y=(length-1)/2,g2_y=(length-1)/2;
		
		List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		List<ArrayList<Integer>> matched_list = new ArrayList<ArrayList<Integer>>();
		List<ArrayList<Integer>> final_list=new ArrayList<ArrayList<Integer>>();
		
		/*Scanner sc = new Scanner(System.in);
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
		
   
        } */
		//3 2 2 2 3 3 4 4 5 5 6 6 7 7 8 8 9 9 10 10 11 11 12 12
		//1 1 1 2 3 4 4 5 5 6 5 5 6 7 6 8 7 9 8 10 9 10 11 11
		int current_x=get_x[0],current_y=get_y[0],pass_threshold=0,is_nearby_threshold=0,area=0;
		for(int i=1;i<6;i++)
		{
			
				if(Math.sqrt(((current_x-get_x[i])*(current_x-get_x[i]))+((current_y-get_y[i])*(current_y-get_y[i])))<=1.2d)
				{
					//System.out.println("Values are *****");
					//System.out.println("(" + current_x + "," + current_y + ")" + "," + "(" + x1[i] + "," + y1[i] + ")");
					ArrayList<Integer> matched_temp = new ArrayList<Integer>();
					matched_temp.add(get_x[i]);
					matched_temp.add(get_y[i]);
					//System.out.println(x1[i]+" "+y1[i] + " "+ matched_temp);
					
					matched_list.add(matched_temp);
					id.add(id_array1[i]);
					count++;
							
				}
		}
		
		System.out.println("Matched list is:" + matched_list);
		for (int i = 0; i < matched_list.size(); i++)
		{ 
					 
				x2[i] = matched_list.get(i).get(0);
				y2[i] = matched_list.get(i).get(1);	
				//System.out.println(x2[i] + "," + y2[i]);
   
        }
        int k=0;
        while(k<matched_list.size())
        { 
			int count_of_non_obstacles=0,c=0;
			for(int i=6;i<12;i++)
			{
				if(get_x[i]>x2[k] && get_x[i]>current_x && get_y[i]>y2[k] && get_y[i]>current_y)
				{
					count_of_non_obstacles++;		
				}
				else
				{
					k++;
				}
				if(i==11 && count_of_non_obstacles==6)
				{	
					//id_array2[c]=id_array[k];
					id_list2.add(id.get(k));
					ArrayList<Integer> final_temp = new ArrayList<Integer>();
					final_temp.add(x2[k]);
					final_temp.add(y2[k]);
					final_list.add(final_temp);
					//c++;
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
				//System.out.println("Final list values are: ");	
				//System.out.println(x3[i] + "," + y3[i]);
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
				System.out.println("Final id is " + id_list2.get(i));
				System.out.println("This is our required bot of co:ordinates" + "(" + x3[i] + "," + y3[i] + ")");
				try {
						FileWriter writer = new FileWriter("C:\\Users\\TejaswiKarasani\\Desktop\\Passing_Algo\\output.txt");
						BufferedWriter bwr = new BufferedWriter(writer);
						bwr.write(String.valueOf(id_list2.get(i)));
						bwr.write(" ");
						bwr.write(String.valueOf(x3[i]));
						bwr.write(" ");
						bwr.write(String.valueOf(y3[i]));
						bwr.close();
						System.out.println("succesfully written to a file");
            
					} 
				catch (IOException ioe) 
					{
						ioe.printStackTrace();
				    }
        
        
        
			}
		}
        
		
		//System.out.println("-----------------");
		System.out.println("Count of matching coordinates within distance of 1.2m :  " + count);
		//System.out.println("-----------------");
		
		//Testing our output
		
		/*System.out.println("After first condition id's stasifying are:");
		for(int i=0;i<id.size();i++)
			System.out.println("id = " + id);
			
		System.out.println("After second condition id's stasifying are:");
		for(int i=0;i<id_list2.size();i++)
			System.out.println("id = " + id);*/
<<<<<<< HEAD
		
=======
		/*try {
            FileWriter writer = new FileWriter("output.txt");
            BufferedWriter bwr = new BufferedWriter(writer);
            bwr.write("");
            bwr.write(" ");
            bwr.write("Hobert");
            bwr.close();
            System.out.println("succesfully written to a file");
            
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }*/
>>>>>>> master
 
	}
}

