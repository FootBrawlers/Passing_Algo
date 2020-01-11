import java.util.*;
import java.lang.*;
import java.io.*;
class Simple2
{
	static boolean checkrectangle(int i_x,int i_y,int f_x,int f_y,int ob_x,int ob_y,int l,int ci)
	{
		
		double p=Math.sqrt(((i_x-f_x)*(i_x-f_x))+((i_y-f_y)*(i_y-f_y)));
		double l1=Double.valueOf(l);
		double X2=f_x + l1;
		double Y2=f_y +p;
		double x2 =X2+f_x-i_x;
		double y2=Y2+f_y-i_y;
		
		double X1=f_x - l1;
		double Y1=f_y - p;
		double x1 =X1+f_x-i_x;
		double y1=Y1+f_y-i_y;
		if(ci==0)
		{
			System.out.println("-----------------------------------");
			System.out.println("l1:" + l1 + " " + "p:" + p);
			System.out.println();
			System.out.println("One side of co-ordinates are(may be negative): " );
			System.out.println("Values of third coordinate of " + X1 + "," + Y1);
			System.out.println("Values of fourth co-ordinate of " + x1 + "," + y1);
			System.out.println();
			System.out.println("Another side of co-ordinates are: " );
			System.out.println("Values of third coordinate of " + X2 + "," + Y2);
			System.out.println("Values of fourth co-ordinate of " + x2 + "," + y2);
			System.out.println("-----------------------------------");
			System.out.println();
		}
		//if(((ob_x>=i_x && ob_x>=f_x && ob_x<X1 && ob_x<x1) && (ob_y>=i_y && ob_y>=f_y && ob_y<Y2 && ob_y<Y2)) || ((ob_x>=i_x && ob_x>=f_x && ob_x<X2 && ob_x<x2) && (ob_y>=i_y && ob_y>=f_y && ob_y<Y2 && ob_y<Y2)))//check if is obstacle
		
		//if(ob_x>=X1 && ob_x>=x1 && ob_x<X2 && ob_x<x2 && ob_y>=Y1 && ob_y>=y1 && ob_y<Y2 && ob_y<y2)//checking if it is an obstacle
		if((ob_x>=X1 && ob_x<X2) || (ob_x>=x1 && ob_x<x2) && (ob_y>=Y1 && ob_y>=y1 && ob_y<Y2 && ob_y<y2))
		{
			return false;
		}
		else
			return true;
		
		/*
		double l1=Double.valueOf(l);
		long l2=Math.round(l);
		
		double d=Math.atan(l1/p);
		
		double h=(l1/Math.sin(d));
		long h1=Math.round(h);
		
		double A=Math.pow(i_x,2)-Math.pow(f_x,2)+Math.pow(i_y,2)-Math.pow(f_y,2)-Math.pow(l2,2)+Math.pow(h1,2);
		double B= (1 + (Math.pow(i_y-f_y,2)/Math.pow(i_x-f_x,2)));
		double C=(((2*i_x*(i_y-f_y))/(i_x-f_x))-(A*(i_y-f_y)/Math.pow(i_x-f_x,2)));
		double D=((Math.pow(A,2))/((4*(Math.pow(i_x-f_x,2)))-(i_x*((Math.pow(i_x,2)-Math.pow(f_x,2)-Math.pow(i_y,2)-Math.pow(f_y,2)-Math.pow(l2,2)+Math.pow(h1,2)))/(i_x-f_x))+ (Math.pow(i_y,2)-Math.pow(l2,2)+Math.pow(i_x,2)))); 
		
		long a=Math.round(A);
		long b=Math.round(B);
		long c=Math.round(C);
		long d1=Math.round(D);
		
		double Y=Math.round((-c + Math.sqrt(c*c-(4*b*d1)))/2*b);
		double X =Math.round((i_x*i_x)-(f_x*f_x)+(i_y*i_y)-(f_y*f_y)-(l2*l2)+(h1*h1)-2*Y*(i_y-f_y));*/
		
		/*double Y=(-C + Math.sqrt(C*C-(4*B*D)))/2*B;
		double X =(i_x*i_x)-(f_x*f_x)+(i_y*i_y)-(f_y*f_y)-(l1*l1)+(h*h)-2*Y*(i_y-f_y);*/ 
		
		
		//System.out.println(inc_var);
		/*System.out.println("----------------------------");
		//System.out.println("p:" + p + " " + "l1:" + l1 + "l2" + l2 + " " + "d:" + d + " " + "h:" + h + " " + "h1" + h1 + " " + "A:" + a + " " + "B:" + b + " " + "C:" + c + " " + "D:" + d1);
		System.out.println("Values of third coordinate: " + X + "," + Y);
		System.out.println("Values of fourth co-ordinate: " + x + "," + y);*/
		
	} 
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
		
		
		
		final int width=700,length=900,len_ob=width/2;
		//int x1[]=new int[12];
		//int y1[]=new int[12];
		int x2[]=new int[6];
		int y2[]=new int[6];
		int x3[]=new int[6];
		int y3[]=new int[6];
		int count=0;
		int g1_x=0,g2_x=(width-1),g1_y=(length-1)/2,g2_y=(length-1)/2,imagine_width=10,count_iteration=0;
		
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
		//System.out.println(final_list);
		for (int i = 0; i < final_list.size(); i++)
		{ 
					 
				x3[i]=final_list.get(i).get(0);
				y3[i]=final_list.get(i).get(1);
				System.out.println("Final list values are: ");	
				System.out.println(x3[i] + "," + y3[i]);
        }
       int pole_dis1_count=0,pole_dis2_count=0,new_x=0,new_y=0,new_id=0;
       
        for(int i=0;i<final_list.size();i++)
        {
			for(int j=i+1;j<final_list.size();j++)
			{
				/*if((Math.sqrt(((g1_x-x3[i])*(g1_x-x3[i]))+((g1_y-y3[i])*(g1_y-y3[i])))) < (Math.sqrt(((g1_x-x3[i])*(g1_x-x3[j]))+((g1_y-y3[j])*(g1_y-y3[j])))))
				{
					pole_dis1_count++;
				
				}*/
				if((Math.sqrt(((g2_x-x3[i])*(g2_x-x3[i]))+((g2_y-y3[i])*(g2_y-y3[i])))) < (Math.sqrt(((g2_x-x3[i])*(g2_x-x3[j]))+((g2_y-y3[j])*(g2_y-y3[j])))))
				{
					new_x=x3[i];
					new_y=y3[i];
					new_id=id_list2.get(i);
					//pole_dis2_count++;
				}
				else
				{
					new_x=x3[j];
					new_y=y3[j];
					new_id=id_list2.get(j);
				}
				
			}
		}
			
				//System.out.println("Final id is " + id_list2.get(i));
				//System.out.println("This is our required bot of co:ordinates" + "(" + x3[i] + "," + y3[i] + ")");
				try {
						FileWriter writer = new FileWriter("C:\\Users\\TejaswiKarasani\\Desktop\\Passing_Algo\\output.txt");
						BufferedWriter bwr = new BufferedWriter(writer);
						bwr.write(String.valueOf(new_id));
						bwr.write(" ");
						bwr.write(String.valueOf(new_x));
						bwr.write(" ");
						bwr.write(String.valueOf(new_y));
						bwr.close();
						System.out.println("succesfully written to a file");
            
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


