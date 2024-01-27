import json

sample = {
  "name": "Bert Bertie",
  "age": 24
}

print(sample)
print(type(sample))
sample_json = json.dumps(sample)
print(sample_json)
print(type(sample_json))

original_sample = json.loads(sample_json)
print(original_sample)
print(type(original_sample))