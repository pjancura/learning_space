import requests

# search github's repositories for popular python projects

try:
    response = requests.get(
        "https://api.github.com/search/repositories",
        # params={"q": "language:python", "sort": "starts", "order": "desc"},       # as a dictionary
        params=b"q=language:python&sort=stars&order=desc",                          # as bytes
        # [("q", "language:python"), ("sort", "stars"), ("order", "desc")],         # as list[tuple[str]]
       
    )

    response.raise_for_status()
except requests.HTTPError as http_err:
    print(f"HTTP error occurred: {http_err}")
except Exception as err:
    print(f"Other error occurred: {err}")
else:
    # Inspect some attributes of the first three repositories
    res_json = response.json()
    # print(res_json)
    popular_repos = res_json['items']
    for repo in popular_repos[:3]:
        print(f"Name: {repo['name']}")
        print(f"Description: {repo['description']}")
        print(f"Stars: {repo['stargazers_count']}")
        print()
