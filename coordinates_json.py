import json
import random
field_length = [130,1010]
field_width = [20,600]

host_cords = []
opp_cords = []

for i in range(6):
    coord = (random.randint(field_length[0],field_length[1]),random.randint(field_width[0],field_width[1]))
    while coord in host_cords:
        coord = (random.randint(field_length[0],field_length[1]),random.randint(field_width[0],field_width[1]))
    else:
        host_cords.append(coord)

for i in range(6):
    coord = (random.randint(field_length[0],field_length[1]),random.randint(field_width[0],field_width[1]))
    while (coord in host_cords) or (coord in opp_cords):
        coord = (random.randint(field_length[0],field_length[1]),random.randint(field_width[0],field_width[1]))
    else:
        opp_cords.append(coord)

d1 = {}
d2 = {}
final_d = {}

for i in range(len(host_cords)):
    d1[i+1] = host_cords[i]

for i in range(len(opp_cords)):
    d2[i+1] = opp_cords[i]

final_d["host"] = d1
final_d["opp"] = d2


a1 = json.dumps(final_d)
# la1 = json.loads(a1)

# a2 = json.dumps(d2)
# la2 = json.loads(a2)


file1 = open("random_coords.json","w")
file1.write(a1)
file1.close()
# print(la1)
# print(type(a1))
# print(type(la1))

# print(json.dumps(opp_cords))

