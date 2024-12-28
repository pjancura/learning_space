import requests

try:
    response = requests.post("https://httpbin.org/post", 
                            #  data={"key": "value"}        # as a dictionary
                            # data = [("key", "value")]    # as a list of tuples
                            json={"key": "value"}           # this is they you would send JSON data
                            )

    response.raise_for_status()

except requests.HTTPError as http_err:
    print(f"HTTP error occurred: {http_err}")

except Exception as err:
    print(f"Other error occurred: {err}")

else:
    print(response.headers, response.json(), response.request.url, response.request.body, sep="\n\n")