import json
import sys
import yaml 

sys.stdout.write(yaml.dump(json.load(sys.stdin)))
