import random

class ChordProgression():

    def __init__(self, major_or_minor: str = "", chordProgression: list[str] = []) -> None:
        self.major_or_minor = major_or_minor
        self.chordProgression = chordProgression
        if self.chordProgression == []:
            self.create_chord_progression()

    def get_chordProgression(self) -> list[str]:
        return self.chordProgression
    
    def get_major_or_minor(self) -> str:
        return self.major_or_minor
    
    def set_chordProgression(self, chordProgression: list[str]) -> None:
        self.chordProgression = chordProgression

    def set_major_or_minor(self, major_or_minor: list[str]) -> None:
        self.major_or_minor = major_or_minor

    def update_chordProgression(self, chord: str) -> None:
        self.chordProgression.append(chord)

    def decide_major_or_minor(self) -> None:
        # TODO: change this back to randomly assign the type of chord progression
        self.set_major_or_minor("MAJOR")
        # rand_num: int = random.randrange(2)
        # if rand_num == 0:
        #     self.set_major_or_minor("MAJOR")
        # else:
        #     self.set_major_or_minor("MINOR")
    
    def set_first_chord(self) -> None:
        if self.get_major_or_minor() == "MAJOR":
            self.update_chordProgression("I")
        else:
            self.update_chordProgression("i")

    def get_last_chord(self) -> str:
        return self.get_chordProgression()[len(self.get_chordProgression()) - 1]
    
    def get_random_number(n: int) -> int:
        return random.randrange(n + 1)


# TODO: create set_next_chord function, create a function that generates a random number based on the options of the chord passed through
    def set_next_chord(self) -> None:
        last_chord: str = self.get_last_chord()
        print(f"last_chord: {last_chord}")
        match last_chord:
            case "I":
                self.update_chordProgression("V")
            case "V":
                self.update_chordProgression("I")
            case "i":
                self.update_chordProgression("V")
            case _:
                print(f"Error: No matching case for {last_chord}")


    def create_chord_progression(self) -> None:
        print("create_chord_progression called")
        chord_progression_length: int = len(self.get_chordProgression())
        if chord_progression_length < 1:
            print("first if statement")
            self.decide_major_or_minor()
            self.set_first_chord()
            self.create_chord_progression()
        elif chord_progression_length > 1 and self.get_chordProgression()[chord_progression_length - 1] == "V":
            print("elif statement")
            self.update_chordProgression("I") if self.get_major_or_minor() == "MAJOR" else self.update_chordProgression("i")
        else: 
            print("else statement")
            self.set_next_chord()
            self.create_chord_progression()


if __name__ == "__main__":
    chordProgression: ChordProgression = ChordProgression()

    print(chordProgression.get_chordProgression(), chordProgression.get_major_or_minor())
