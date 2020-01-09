# Baisc Idea

### Defined (Static):

1. Size of the play field (10400x13400/5) and the goal post, center circle.
2. Diameter of the ball as (180/5)
3. Buffer **length** for finding if there is an opponent's bot nearby as 400/5, say, 'is_nearby_threshold'.
4. Threshold length for passing the ball 2000/5 (have to verify, *depends on speed of ball*), say, 'pass_threshold'
5. 



### Input(s): 

1. X and Y coordinate of 12 bots (6 on each bots).
2. Id of each of our bot and the opponent bots.
3. Id of the bot which has the ball currently, say, 'current'.
4. 



### Output(s):

1. Return which bot's id will have the ball in next turn.
2. 



### Algorithm

1. First we find the euclidean distance between 'current' and all our bots.
2. List out which bot has length less than 'pass_threshold'.
3. For the remaining bots, create a hypothetical rectangle of length, equal to distance between the 'current' and other bot, and width equal to 'is_nearby_threshold'.
4. In that check if there is any opponent bot present in that rectangle.
5. 
6. 
