import json
import random
field_length = [130,1010]
field_width = [20,600]

host_cords = []
opp_cords = []

for i in range(6):
    coord = (random.randint(tuple(field_length)),random.randint(tuple(field_width)))
    if coord not in host_cords:
        host_cords.append(coord)
    

