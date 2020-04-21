import math
if(__name__=="__main__"):
    pos1=[-5,-2]              #positions of the bots
    pos2=[-9,2]
    ang1=123      #initial direction of bots
    ang2=21

def cosinv(num):            #function to return cos inverse in degrees
    ang=math.acos(num)
    ang=180*ang/(math.pi)
    return(ang)

def rotate(pos1,ang1,pos2,ang2):    #actual function 
    dist=math.sqrt((pos1[0]-pos2[0])**2+(pos1[1]-pos2[1])**2)   #distance between bots
    x=abs(pos1[0]-pos2[0])          # adjacent side of triangle
    c_ang=cosinv(x/dist)            # cosx= adjacent/dist
    
    # checking quadrant of bot 2 wrt bot1
    if pos2[0]>pos1[0] and pos2[1]>=pos1[1]:                #quad1
        f_ang1=c_ang
    elif pos2[0]<=pos1[0] and pos2[1]>pos1[1]:              #quad2
        f_ang1=180-c_ang
    elif pos2[0]<pos1[0] and pos2[1]<=pos1[1]:              #quad3
        f_ang1=180+c_ang
    elif  pos2[0]>=pos1[0] and pos2[1]<pos1[1]:              #quad4  
        f_ang1=360-c_ang    

    # bot 2 final position should be facing bot1....
    if f_ang1<180:
        f_ang2=180+f_ang1
    elif f_ang1>=180:
        f_ang2=f_ang1-180
    
    print("INITIAL POSITIONS: ",pos1,ang1,pos2,ang2)
    print("THEIR FINAL DIRECTIONS: ",f_ang1,f_ang2)
    return f_ang1,f_ang2
    

#f_ang1,f_ang2=rotate(pos1,ang1,pos2,ang2)

#clockwise-> +ve , anticlockvise-> -ve
def change_in_angle(ang1,fang1,ang2,fang2): #To get the angle bot needs to rotate
    c1=abs(fang1-ang1) #one possible angle
    c2=abs(360-c1)     #other possible angle
    c=min(c1,c2)       #for min rotation.
    fin=ang1+c
    if fin>360:
        fin-=360 #to prevent angle exceeding 360

    if int(fin)==int(fang1):
        c_final=c*-1  #anticlockwise turn
    else:
        c_final=c     #clockwise turn

#same process for bot 2 as well.  
    d1=abs(fang2-ang2) 
    d2=abs(360-d1)
    d=min(d1,d2)
    fin2=ang2+d
    if fin2>360:
        fin2-=360
    

    
    if int(fin2)==int(fang2):
        d_final=d*-1
    else:
        d_final=d
        
    print("change for passer is",c_final)
    print("change for receiver is",d_final)
    return c_final,d_final
    
            
        
#change_in_angle(ang1,f_ang1,ang2,f_ang2)    
