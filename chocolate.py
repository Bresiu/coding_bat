def make_chocolate(small, big, goal):
  while big * 5 > goal:
    big=big-1
  goal=goal-big * 5
  if small>=goal:
    return goal
  else:
    return -1
if __name__ == '__main__':
   print make_chocolate(5, 1, 10)
