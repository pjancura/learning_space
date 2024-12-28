import requests
from authentication_2 import TokenAuth

with requests.Session() as session:
    try:
        print("Enter your Authentication Token:")
        session.auth = TokenAuth(input())
        first_response = session.get("https://api.github.com/user")
        first_response.raise_for_status()
        second_response = session.get("https://api.github.com/user")
        second_response.raise_for_status()

    except requests.HTTPError as http_err:
        print(f"HTTP error occurred: {http_err}")
    except Exception as err:
        print(f"Other error occurred: {err}")
    
    else:
        print(first_response.headers)
        print(second_response.json())