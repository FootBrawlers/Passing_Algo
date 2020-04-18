import math
pos1=[0,10]              #positions of the bots
pos2=[0,0]
ang1=60                  #initial direction of bots
ang2=30

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

rotate(pos1,ang1,pos2,ang2)