from flask import Flask
from flask import make_response
import json
import os

app = Flask(__name__)

@app.route('/')
def hello():
    print(os.environ)
    return nice_json(dict(**os.environ))

def nice_json(arg):
    response = make_response(json.dumps(arg, sort_keys = True, indent=4))
    response.headers['Content-type'] = "application/json"
    return response

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=8080)