import requests

try:
    # response = requests.get("https://httpbin.org/get")
    # response.raise_for_status()

    # response = requests.post("https://httpbin.org/post", data={"key": "value"})
    # response.raise_for_status()

    # response = requests.put("https://httpbin.org/put", data={"key": "value"})
    # response.raise_for_status()

    response = requests.delete("https://httpbin.org/delete")
    response.raise_for_status()

    # response = requests.head("https://httpbin.org/get")
    # response.raise_for_status()

    # response = requests.patch("https://httpbin.org/patch", data={"key": "value"})
    # response.raise_for_status()

    # response = requests.options("https://httpbin.org/get")
    # response.raise_for_status()

except requests.HTTPError as http_err:
    print(f"HTTP error occurred: {http_err}")
except Exception as err:
    print(f"Other error occurred: {err}")

else:
    print()
    print(response.headers, response.json(), sep='\n')
    print()