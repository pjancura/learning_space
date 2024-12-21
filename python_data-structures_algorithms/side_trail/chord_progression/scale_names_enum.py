from enum  import Enum

class ScaleNames(Enum):
    MAJOR = [0, 2, 4, 5, 7, 9, 11, 0]
    NATURAL_MINOR = [0, 2, 3, 5, 7, 8, 10, 0]
    HARMONIC_MINOR = [0, 2, 3, 5, 7, 8, 11, 0]
    MELODIC_MINOR = [0, 2, 3, 5, 7, 9, 11, 0, 10, 8, 7, 5, 3, 2, 0]
    CHROMATIC = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 0]
    PENTATONIC = [0, 2, 4, 7, 9, 0]
    BLUES = [0, 3, 5, 6, 7, 10, 0]

    @classmethod
    def print_all_scale_names_and_values(self) -> None:
        keys: list[str] = list(self.__members__.keys())
        items: list[int] = list(map(lambda item: item[1].value, list(self.__members__.items())))
        print(dict(zip(keys, items)))

if __name__ == "__main__":
    print(ScaleNames.MAJOR.value)

    scales: ScaleNames = ScaleNames.__members__
    print(scales)

    scale_number: dict[str, ScaleNames] = ScaleNames.__members__.values()
    for number in scale_number:
        print(number.value, number)
    
    scale_number_2: dict[str, ScaleNames] = ScaleNames.__members__.values()
    for value in scale_number_2:
        print(value.value)

    scale_name: ScaleNames = ScaleNames.__members__.keys()
    print(scale_name)

    for scale in ScaleNames.__members__.items():
        print(scale[0], scale[1].value)
    
    for scale_name, member in ScaleNames.__members__.items():
        print(scale_name, member)
    
    print("\n\n")
    ScaleNames.print_all_scale_names_and_values()