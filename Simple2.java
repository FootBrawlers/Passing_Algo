import java.util.*;
import java.lang.*;
import java.io.*;
class Simple2
{
	//elipse formula  (x -x'')^2 / a*a + (y-y'')^2 / b*b <=1
	//checking whether (x'',y'') is present inside the ellipse or not
	
	//checking whether there is any obstacle is present in the elipse or not
	static boolean checkrectangle(int i_x,int i_y,int f_x,int f_y,int ob_x,int ob_y,int l,int ci)
	{
		
		double p=Math.sqrt(((i_x-f_x)*(i_x-f_x))+((i_y-f_y)*(i_y-f_y))); //getting the "b" in the ellipse 
		double l1=Double.valueOf(l);
		
		double x_dash=(i_x+f_x)/2; //getting the midpoint of our bots coordinates on having the ball and the one we are checking in the matched list
		double y_dash=(i_y+f_y)/2;
		
		double x_double_dash=(x_dash +f_x)/2; //shifting the midpoint to again the midpoint of the (the x_dash,y_dash and the one from matching list)
		double y_double_dash=(y_dash + f_y)/2;
		
		double x_ellipse = (Math.pow(ob_x-x_double_dash,2))/(l1*l1); //typical ellipse formula a=l1 and b=3*p/2
		double y_ellipse = (Math.pow(ob_y-y_double_dash,2))/((3*p)/2) * ((3*p)/2);
		
		if((x_ellipse+y_ellipse)<=1) //if point is present in ellipse we are returning false
			return false;
		else
			return true;
		
	}
	
	//get_x and get_y are out coordiantes that we got from the file and used readlist to store them back into get_x and get_y
	public static void main(String args[]) throws IOException
	{

		// --------------------------------- INPUT FROM FILE ---------------------------------------

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
			File file = new File("input.txt");
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
			// for(int x:read_list.get(i))
			// {
			// 	//System.out.print(x+" "); //]+" "+read_list.get(i)[1]+" "+read_list.get(i)[2]);
			// }
			}
			
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
		
		
		//System.out.println(read_list);
		
		
		// --------------------------------- VERIFYING THE INPUT ---------------------------------------
        
        for(int i=0;i<12;i++)
        {
			System.out.println(id_array1[i] + "," + get_x[i] + "," + get_y[i]);
		}
		
		
		 
		final int width=700,length=900; //dimensions of football
		int nearest_goal_x=0,nearest_goal_y=0; //checking for the point which is nearest to goal post so this becomes the one having ball then it can goal directly
		//int x1[]=new int[12];
		//int y1[]=new int[12];
		int x2[]=new int[6];
		int y2[]=new int[6];
		int x3[]=new int[6];
		int y3[]=new int[6];
		int count=0;
		int g1_x=0,g2_x=length-1,g1_y=(width-1)/2,g2_y=(width-1)/2,imagine_width=40; //imagine_width is nothing but l1 in the ellipse that used in checkrectangle function
		//count_iteration=0;
		
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
		double len_between_goal=900;
		//logic to find the one which is nearest to the goal post so can goal instead of passing
		for(int i=0;i<6;i++)
        {
				if((Math.sqrt(((g2_x-get_x[i])*(g2_x-get_y[i]))+((g2_y-get_y[i])*(g2_y-get_y[i])))) < len_between_goal)
				{
					nearest_goal_x=get_x[i];
					nearest_goal_y=get_y[i];
					len_between_goal=Math.sqrt(((g2_x-get_x[i])*(g2_x-get_y[i]))+((g2_y-get_y[i])*(g2_y-get_y[i])));
					//new_id=id_list2.get(i);
					//pole_dis2_count++;
					//System.out.println("Coordinates nearest to the goal are :" + nearest_goal_x + nearest_goal_y);
					System.out.println(nearest_goal_x);
					System.out.println(nearest_goal_y);
					System.out.println(len_between_goal);
				}

			//System.out.println("Coordinates nearest to the goal are :" + nearest_goal_x + nearest_goal_y);
		}
		
		//System.out.println("Coordinates nearest to the goal are :" + nearest_goal_x + nearest_goal_y);
		
		int current_x=get_x[0],current_y=get_y[0]; //setting the one having ball as our first coordinate in the file
		
		//checking the all coordinates one by one if they are on the threshold of 650 distance between the one having ball and it
		//adding all those to the matched list of those satisfying
		for(int i=1;i<6;i++)
		{
			
				if(Math.sqrt(((current_x-get_x[i])*(current_x-get_x[i]))+((current_y-get_y[i])*(current_y-get_y[i])))<=650)
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
		
		//printing matched list
		System.out.println("Matched list is:" + matched_list);
		for (int i = 0; i < matched_list.size(); i++)
		{ 
					 
				x2[i] = matched_list.get(i).get(0);
				y2[i] = matched_list.get(i).get(1);	
				//System.out.println(x2[i] + "," + y2[i]);
   
        }
        
        
        //iterating through matched list and keeping a check of non obstacles by using non_obstacles variable
        
        //checking can be done by checkrectangle function
        
        //if this is also satisfying then adding all these to our final list
        int k=0;
        while(k<matched_list.size())
        { 
			int count_of_non_obstacles=0,c=0;
			for(int i=6;i<12;i++)
			{
				//checkrectangle(current_x,current_y,x2[k],y2[k],get_x[i],get_y[i],len_ob);
				if(checkrectangle(current_x,current_y,x2[k],y2[k],get_x[i],get_y[i],imagine_width,c))
				//if(get_x[i]>x2[k] && get_x[i]>current_x && get_y[i]>y2[k] && get_y[i]>current_y)
				{
					count_of_non_obstacles++;		
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
				c++;
			}
			System.out.println("No. of non obstacles are " + count_of_non_obstacles);
			k++;
		}
		//printing our final list
		for (int i = 0; i < final_list.size(); i++)
		{ 
					 
				x3[i]=final_list.get(i).get(0);
				y3[i]=final_list.get(i).get(1);
				System.out.println("Final list values are: ");	
				System.out.println(x3[i] + "," + y3[i]);
        }
       int new_x=0,new_y=0,new_id=0; //new_x,new_y,new_id for storing the id and coordinates of our final condition satisfying one
       
       
       //this is our last condition 
       
       //Here we are iterating through final list that has no obstacles and checking the one which is nearest to our goal post(g2)
        for(int i=0;i<final_list.size();i++)
        {
			for(int j=i+1;j<final_list.size();j++)
			{
				
				if((Math.sqrt(((g2_x-x3[i])*(g2_x-x3[i]))+((g2_y-y3[i])*(g2_y-y3[i])))) < (Math.sqrt(((g2_x-x3[j])*(g2_x-x3[j]))+((g2_y-y3[j])*(g2_y-y3[j])))))
				{
					new_x=x3[i];
					new_y=y3[i];
					new_id=id_list2.get(i);
					
				}
				else
				{
					new_x=x3[j];
					new_y=y3[j];
					new_id=id_list2.get(j);
				}
				
			}
		}
		
			
				//if our nearest goal itself have the ball then it's goaled else it's passed to the bot satisfying all the above condtions
				
				//condition 1 : 650 threshold
				//condition 2 : no obstacles
				//condition 3 : nearest to goal post among the no obstacles coordinates
				//condition 4 : checking if the one containing the ball is very much and first nearest to goal post
				try {
						FileWriter writer = new FileWriter("output.txt");
						BufferedWriter bwr = new BufferedWriter(writer);
						if(current_x == nearest_goal_x && current_y==nearest_goal_x)
						{
							bwr.write("Ball is goaled");
							bwr.write("co:ordinates are:\n");
							bwr.write(String.valueOf(new_x));
							bwr.write(" ");
							bwr.write(String.valueOf(new_y));
							bwr.write(" ");
						}
						else
						{
							bwr.write(String.valueOf(new_x));
							bwr.write(" ");
							bwr.write(String.valueOf(new_y));
							bwr.write(" ");
						}
						bwr.write(String.valueOf(new_id));
						System.out.println("succesfully written to a file");
						bwr.close();
            
					} 
				catch (IOException ioe) 
					{
						ioe.printStackTrace();
				    }
        
        
        
		}
        
		
		//System.out.println("-----------------");
		//System.out.println("Count of matching coordinates within 650 cm distance  :  " + count);
		//System.out.println("-----------------");
		
		//Testing our output
		
		/*System.out.println("After first condition id's stasifying are:");
		for(int i=0;i<id.size();i++)
			System.out.println("id = " + id);
			
		System.out.println("After second condition id's stasifying are:");
		for(int i=0;i<id_list2.size();i++)
			System.out.println("id = " + id);*/

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
 
	}


