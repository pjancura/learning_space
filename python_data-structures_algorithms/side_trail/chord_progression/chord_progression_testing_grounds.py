import random

note_names: list[str] = ["A", "Bb", "B", "C", "C#", "D", "Eb", "E", "F", "F#", "G", "G#"]

chord_symbols: list[str] = [" ", "m", "7", "m7",  "aug", "\u00B0", "\u00B07", "\u00F87",]

print(chord_symbols)

note_numbers = [i for i in range(0, 12)]

combined_names_numbers: dict = dict(zip(note_numbers, note_names))

print(combined_names_numbers.get(7))

# print(note_names, note_numbers)

# for item in combined_names_numbers:
#     print(item)


def rotate_note_numbers(num: int, arr: list[int]) -> list[int]:
    if num > 11:
        num = 1
    first_part = arr[num: len(arr)]
    second_part = arr[0: num]
    return first_part + second_part

def random_rotate_note_numbers(arr: list[int]) -> list[int]:
    rand_num: int= random.randrange(len(arr)) - 1
    if rand_num > 11:
        rand_num = 1
    print(rand_num)
    first_part: list[int] = arr[rand_num: len(arr)]
    second_part: list[int] = arr[0: rand_num]
    return first_part + second_part


print(rotate_note_numbers(2, note_numbers))

rotated_and_zipped: dict[int, str] = dict(zip(random_rotate_note_numbers(note_numbers), note_names))

print(rotated_and_zipped.get(1))

def print_major_scale(d: dict[int, str], type: enumerate) -> list[str]:
    major_scale_numbers: list[int] = [0, 2, 4, 5, 7, 9, 11, 0]
    scale_note_letters: list[str] = [""] * 8
    i: int = 0
    for degree in major_scale_numbers:
        scale_note_letters[i] = d.get(degree)
        i += 1
    print(scale_note_letters)
    return scale_note_letters

# print_major_scale(rotated_and_zipped)

