import requests
import json
import pandas as pd

if __name__ == "__main__":
    # this section gets the information regarding Luke Skywalker and displays in it using json.dumps()
    # try:
    #     response = requests.get(
    #         "https://www.swapi.tech/api/people/1"
    #     )

    # except requests.HTTPError as http_err:
    #     print(f"HTTP error occurred:\n\t{http_err}")
    
    # else:
    #     header = response.headers
    #     print(json.dumps(dict(header), indent=4))
    #     data = response.json()
    #     print(json.dumps(data, indent=4))

    #     for prop in data['result']['properties']:
    #         print(data['result']['properties'][prop])


    # this section will write all of the people data from swapi to a csv
    all_results = []

    try:
        end_point = "people"
        URL = "https://www.swapi.tech/api/" + end_point

        is_next_page = True
        response = requests.get(
            URL
        )
        while is_next_page:

            data = response.json()
            for res in data['results']:
                sub_response = requests.get(
                    res['url']
                ).json()
                all_results.append(sub_response['result']['properties'])

            if data['next']:
                response = requests.get(
                    data['next']
                )

            else:
                is_next_page = False

    except requests.HTTPError as http_err:
        print(f"HTTP error occurred:\n\t{http_err}")
        
    try:
        if all_results:
            df = pd.DataFrame(all_results)
            file_name = "sw_people_data.csv"
            output_file = "./csv_s/" + file_name
            df.to_csv(output_file, index=True)
            print(f"All data has been successfully written to '{output_file}'")
        else:
            print("No data to write to the CSV.")
            exit()
    except Exception as e:
        print(f"Error while creating DataFrame or writing to CSV: {e}")

    