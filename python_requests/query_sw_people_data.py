import pandas as pd

# Read the CSV file into a DataFrame
file_path = "./csv_s/sw_people_data.csv"
try:
    df = pd.read_csv(file_path)
    print("CSV file loaded successfully.")
except FileNotFoundError:
    print(f"Error: The file '{file_path}' was not found.")
except pd.errors.EmptyDataError:
    print(f"Error: The file '{file_path}' is empty.")
except Exception as e:
    print(f"An unexpected error occurred: {e}")

# Example Queries
try:
    # 1. Display the first few rows of the DataFrame
    print("First 5 rows of the data:")
    print(df.head())
    print()
    # 2. Filter rows where height is greater than 170
    df['height'] = df['height'].replace("unknown", 0).astype(float)
    print("\nPeople with height greater than 170:")
    tall_people = df[df['height'].astype(float) > 170]
    print(tall_people)
    print()
    # 3. Find people with a specific name
    specific_name = "Luke Skywalker"
    print(f"\nDetails for people named {specific_name}:")
    print(df[df['name'] == specific_name])
    print()
    # 4. Sort by mass in descending order
    print("\nData sorted by mass (descending):")
    sorted_df = df.sort_values(by='mass', ascending=False)
    print(sorted_df)
    print()
except KeyError as e:
    print(f"Error: Missing column in the data - {e}")
except ValueError as e:
    print(f"Error: Value conversion issue - {e}")
except Exception as e:
    print(f"An unexpected error occurred during querying: {e}")

else:
    print("ALL QUERIES MADE")