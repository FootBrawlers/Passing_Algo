# --------- This script will estimate the best coordinate to pass the ball, if any. ----------------


# here, we are defining some constraints based on field dimensions
maximum_pass_length = 700
ellipse_width_opp_check = 40  # 'b'-parameter and 'a' will be (distance between points)*1.5
threshold = ellipse_width_opp_check
import math as mt
from Passing_Algo.Passing import coordinates_generator as generator
gp = [1020, 310]
gp_length = 140



# FUNCTION for DISTANCE
# argument1 -> (x1,y1) or [x1,y1], argument2 -> (x2,y2) or [x2,y2]
def distance(p1, p2):
    return mt.sqrt((p2[0] - p1[0]) ** 2 + (p2[1] - p1[1]) ** 2)


# FUNCTION for finding the coordinates to whom the ball can be passed.
# argument1 -> list of coordinates of the form [[x1,y1],[x2,y2],...,[xn,yn]] , argument2 -> Id of the bot which is currently holding the ball
def passable_host_bots(list_host_coords, current_id):
    list_passable_host_bots = []
    for i in range(len(list_host_coords)):
        if i != current_id:
            if distance(list_host_coords[current_id], list_host_coords[i]) <= maximum_pass_length:
                list_passable_host_bots.append(list_host_coords[i])
    return list_passable_host_bots


def in_ellipse(c1, c2, e):
    if (((e[0] - c2[0]) ** 2) / (distance(c1, c2) ** 2)) + (((e[1] - c2[1]) ** 2) / (threshold ** 2)) <= 1:
        return True
    else:
        return False


def in_circle(c2, e):
    if (e[0] - c2[0]) ** 2 + (e[1] - c2[1]) ** 2 <= threshold ** 2:
        return True
    else:
        return False


def dist_from_gp(c1):
    gp_end1 = [gp[0], gp[1] + gp_length / 2]
    gp_end2 = [gp[0], gp[1] - gp_length / 2]
    if c1[1] < gp_end2[1]:
        return distance(c1, gp_end2)
    elif c1[1] > gp_end1[1]:
        return distance(c1, gp_end1)
    else:
        return gp[0] - c1[0]


def sort_array(arr):
    for i in range(1, len(arr)):
        key = arr[i]
        j = i - 1
        while j >= 0 and dist_from_gp(key) < dist_from_gp(arr[j]):
            arr[j + 1] = arr[j]
            j -= 1
        arr[j + 1] = key


def same_side_line(c1, c2, e):
    m = -(c1[0] - c2[0]) / (c1[1] - c2[1])
    a = (e[1] - c2[1]) - m * (e[0] - c2[0])
    b = (c1[1] - c2[1]) - m * (c1[0] - c2[0])

    if a * b < 0:
        return 0
    else:
        return 1


def in_shape(c1, c2, e):
    if (same_side_line(c1, c2, e)):
        if (in_ellipse(c1, c2, e)):
            return 1
        else:
            return 0
    else:
        if (in_circle(c2, e)):
            return 1
        else:
            return 0


def chk_pass(cur, l, ec):
    for i in range(0, len(l)):
        for j in range(0, len(ec)):
            if in_shape(cur, l[i], ec[j]):
                break
        else:
            return f"{id(l[i])}:{l[i]}"
    else:
        return "None"


if __name__ == "__main__":
    generator.generate()

    while True:
        host_cords = []  # this will contain the host coordinates with id as index, i.e., from 1 to 6
        opp_cords = []  # this will contain the opposition coordinates with id as index, i.e., from 11 to 16

        # read the coordinates from "input.txt"
        # data-format in input.txt ---------> ( index, x-cord, y-cord)

        input_file = open("input.txt", "r")
        op = input_file.readlines()
        for i in range(len(op)):
            if i < 6:
                host_cords.append(list(map(int, op[i].strip().split()[1:])))
            else:
                opp_cords.append(list(map(int, op[i].strip().split()[1:])))
        input_file.close()

        # Verifying the input
        #print()
        #print("Host Coordinates : ", host_cords)
        #print("Opponent Coordinates : ", opp_cords)
        #print()
        current_bot=0
        # Verifying the passable points
        #print("Passable points with ", host_cords[current_bot], " as current bot : ", passable_host_bots(host_cords, current_bot))
        #print()
        list_passable_host_bots = passable_host_bots(host_cords, current_bot)
        (sort_array(list_passable_host_bots))
        #print(list_passable_host_bots)
        dict = {}
        for i in range(0, len(host_cords)):
            dict[i + 1] = host_cords[i]

        def id(x):
            for i in range(0, len(host_cords)):
                if (dict[i + 1][0] == x[0] and dict[i + 1][1] == x[1]):
                    return (i + 1)

        print("PASS TO BOT:", chk_pass(host_cords[0], list_passable_host_bots, opp_cords))
        generator.show()
