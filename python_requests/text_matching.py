import requests

try:
    response = requests.get(
        'https://api.github.com/search/repositories',
        params={'q': '"real python"'},
         headers={"Accept": "application/vnd.github.text-match+json"}                # Accept tells the server what content types your application can handle
    )
    response.raise_for_status()
except requests.HTTPError as http_err:
    print(f"HTTP Error occurred: {http_err}")
except Exception as err:
    print(f"Other error occurred: {err}")
else:
   # View the new `text-matches` list which provides information
# about your search term within the results
    json_response = response.json()
    print(json_response)
    first_repository = json_response["items"][0]
    print(first_repository["text_matches"][0]["matches"]) 