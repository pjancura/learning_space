import requests
from requests.auth import HTTPBasicAuth
from requests.auth import AuthBase
from requests.exceptions import Timeout

class TokenAuth(AuthBase):
    """Implements a token authentication scheme."""
    def __init__(self, token):
        self.token = token
    
    def __call__(self, request):
        """Attach an API token to the Authorization header."""
        request.headers["Authorization"] = f"Bearer {self.token}"
        return request
    

if __name__ == "__main__":

    # remove token from here
    try:
        print("Enter your Authentication Token:")
        token = TokenAuth(input())
        response = requests.get(
            "https://api.github.com/user",
            # auth=("", AUTH_TOKEN)      # because the empty string looks weird you can create a TokenAuth class that makes it look neater
            auth=token,
            timeout=(0.05, 0.05)
        )
        response.raise_for_status()

    except Timeout as t_err:
        print(f"The request timed out: {t_err}")

    except requests.HTTPError as http_err:
        print(f"HTTP error occurred: {http_err}")

    except Exception as err:
        print(f"Other error occurred: {err}")

    else:
        print(response.json(), response.headers, response.request.headers["Authorization"], sep="\n")