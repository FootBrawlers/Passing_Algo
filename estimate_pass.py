# --------- This script will estimate the best coordinate to pass the ball, if any. ----------------


# here, we are defining some constraints based on field dimensions
maximum_pass_length = 700
ellipse_width_opp_check = 40    # 'b'-parameter and 'a' will be (distance between points)*1.5


import math as mt

# FUNCTION for DISTANCE 
# argument1 -> (x1,y1) or [x1,y1], argument2 -> (x2,y2) or [x2,y2]  
def distance(p1,p2):
    return mt.sqrt((p2[0]-p1[0])**2 + (p2[1]-p1[1])**2)


# FUNCTION for finding the coordinates to whom the ball can be passed.
# argument1 -> list of coordinates of the form [[x1,y1],[x2,y2],...,[xn,yn]] , argument2 -> Id of the bot which is currently holding the ball
def passable_host_bots(list_host_coords,current_id):
    list_passable_host_bots = []
    for i in range(len(list_host_coords)):
        if i!=current_id:
            if distance(list_host_coords[current_id],list_host_coords[i]) <= maximum_pass_length:
                list_passable_host_bots.append(list_host_coords[i])
    return list_passable_host_bots



if __name__ == "__main__":
   
    host_cords = []     # this will contain the host coordinates with id as index, i.e., from 1 to 6
    opp_cords = []      # this will contain the opposition coordinates with id as index, i.e., from 11 to 16


    # read the coordinates from "input.txt"
    # data-format in input.txt ---------> ( index, x-cord, y-cord)

    input_file = open("input.txt","r")
    op = input_file.readlines()
    for i in range(len(op)):
        if i<6:
            host_cords.append(list(map(int,op[i].strip().split()[1:])))
        else:
            opp_cords.append(list(map(int,op[i].strip().split()[1:])))
    input_file.close()


    # Verifying the input 
    print()
    print("Host Coordinates : ",host_cords)
    print("Opponent Coordinates : ",opp_cords)
    print()

    # Verifying the passable points
    print("Passable points with ",host_cords[0]," as current bot : ",passable_host_bots(host_cords,0))
    print()
    list_passable_host_bots = passable_host_bots(host_cords,0)

    