from turtle import *

diameter = 40
pop_diameter = 100

# draws the balloon on screen
def draw_balloon ():
  color("red")
  dot(diameter)

# called when we press the Up arrow key
def inflate_balloon ():
  global diameter
  diameter = diameter + 10
  draw_balloon()

  # are we ready to pop?
  if diameter >= pop_diameter:
    clear()
    diameter = 40
    write("POP!")
    
draw_balloon()

# call inflate_balloon when we press the Up arrow key
onkey(inflate_balloon, "Up")

listen()