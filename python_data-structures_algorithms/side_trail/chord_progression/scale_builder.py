from scale_names_enum import ScaleNames
import random

class ScalePicker():

    NOTE_NAMES: list[str] = ["A", "Bb", "B", "C", "C#", "D", "Eb", "E", "F", "F#", "G", "G#"]

    NOTE_NUMBERS = [i for i in range(0, 12)]
    
    def __init__(self, scalePattern: list[int], scaleName: ScaleNames, scale: list[str]) -> None:
        self.scaleName = scaleName
        self.scalePattern = scalePattern
        self.scale = scale
    
    def __random_rotate_note_numbers(self, arr: list[int]) -> list[int]:
        rand_num: int= random.randrange(len(arr)) - 1
        if rand_num > 11:
            rand_num = 0
        print(rand_num)
        first_part: list[int] = arr[rand_num: len(arr)]
        second_part: list[int] = arr[0: rand_num]
        return first_part + second_part
    
    def __get_random_scale_pattern(self, scale_patterns: dict[ScaleNames, list[int]]) -> list[int]:
        return 