import math
class Circle:
  # Write your code here
  def __init__(self,radius):
    self.radius = radius
   
  def area(self):
    calc_area = math.PI * (self.radius**2)
    return calc_area
  
  def circumference(self):
    calc_circum = 2 * math.PI * self.radius
    return calc_circum

circle = Circle(5)
print("Area:")
print(circle.area())
print("and circumference:")
print(circle.circumference())