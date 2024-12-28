import requests
from requests.exceptions import HTTPError

# response = requests.get("https://api.github.com")


# match response.status_code:
#     case 200:
#         print("200: Success")
#     case 404:
#         print("404: Not Found")
#     case _:
#         print(f"Undefined status code: {response.status_code}")

# # response can evaluate to True is < 400 and False otherwise for conditional statements
# if response:
#     print("200: Success")
# else:
#     raise Exception(f"Non-success statuscode: {response.status_code}")


URLS = ["https://api.github.com", "https://api.github.com/invalid"]

for url in URLS:
    try:
        response = requests.get(url)
        response.raise_for_status()
    except HTTPError as http_err:
        print(f"HTTP error occurred: {http_err}\n")
    except Exception as err:
        print(f"Other error occurred: {err}\n")
    else:
        print("Success!")
        print(response.content, "\n") # the class type of response.content is bytes, 
        response.encoding = "utf-8"     # this explicitly defines the encoding type for the response object, otherwise the library will try to make an assumption based on the headers
        print(response.text, "\n")    # the class type of response.text is str
        response_dict = response.json()          # the class type of response.json() is dictionary
        print(response_dict, "\n")
        print(response_dict['emojis_url'],"\n")

        print(response.headers, "\n") 
        print(response.headers['Content-Type'], "\n")      # headers is already in dictionary-like object, the keys are NOT case sensitive




    