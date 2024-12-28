import requests
from requests.auth import HTTPBasicAuth

try:
    response = requests.get(
        "https://httpbin.org/basic-auth/user/passwd",
        auth=HTTPBasicAuth("user", "passwd")
    )
    response.raise_for_status()

except requests.HTTPError as http_err:
    print(f"HTTP error occurred: {http_err}")
except Exception as err:
    print(f"Other error occurred: {err}")

else:
    print(response.request.headers["Authorization"], sep="\n\n")