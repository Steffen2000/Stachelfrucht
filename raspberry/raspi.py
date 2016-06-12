import requests
import time
from RPi import GPIO
GPIO.setmode(GPIO.BOARD)
GPIO.setup(11, GPIO.IN)
GPIO.setup(32, GPIO.OUT)
GPIO.setwarnings(False)
bewegung = GPIO.input(11)

url="http://172.16.108.114"

user_id = "1"

a = 1
b = 1

while a == 1:
	status = requests.get("http://172.16.108.114/status.php?id=1")
	#print status.text
	bewegung = GPIO.input(11)
	if bewegung == 1 and status.text == 'true': 
		payload = {'laenge': '1234', 'breite': '1234', 'id': '1'}
		r = requests.post(url, data=payload)
		#print r.text
		#print 'test'
		while b < 100:
			GPIO.output(32, GPIO.HIGH)
			time.sleep(0.005)
			GPIO.output(32, GPIO.LOW)
			time.sleep(0.005)
			b = b + 1
	a = 2


