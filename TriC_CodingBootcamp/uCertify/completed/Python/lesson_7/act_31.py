# Class definition goes here
class MobilePhone:
    def __init__(self,display_size,ram,os):
        self.display_size = display_size
        self.ram = ram
        self.os = os


pearphone = MobilePhone(5.5, "3GB", "yOS 11.2")
simsun = MobilePhone(5.4, "4GB", "Cyborg 8.1")

print(f"The new Pear phone has a {pearphone.display_size}"
      f" inch display. {pearphone.ram} of RAM and runs on "
      f"the latest version of {pearphone.os}. Its biggest competitor is "
      f"the Simsun phone which sports a similar AMOLED {simsun.display_size} "

      f"inch display, {simsun.ram} of RAM and runs {simsun.os}."
      )


class Elevator:
    occupancy_limit = 8

    def __init__(self, occupants):
        if occupants > self.occupancy_limit:
            print("The maximum occupancy limit has been exceeded."
                  f" {occupants - self.occupancy_limit} occupants must exit the elevator.")
        self.occupants = occupants
elevator1 = Elevator(6)
print("Elevator 1 occupants:", elevator1.occupants)
elevator2 = Elevator(10)
print("Elevator 2 occupants:", elevator2.occupants)