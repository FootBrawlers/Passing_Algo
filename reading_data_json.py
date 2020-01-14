import json
file1 = open("random_coords.json","r")
x = file1.readline()
file1.close()

load_x = json.loads(x)
host_coord = []
opp_coord = []

for i in range(6):
    host_coord.append(load_x['host'][str(i+1)])
for i in range(6):
    opp_coord.append(load_x['opp'][str(i+1)])
print(host_coord)
print(opp_coord)

# print(opp_coord[0][0]+1)
# file1.close()
