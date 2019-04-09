import time 
from time import sleep
import json
from datetime import datetime
#import routeSuggest
import urllib.request
from urllib import parse
import http.cookiejar
from getpass import getpass
import sys
#import reverse_geocoder as rg #pip3 install reverse_geocoder
# git clone https://github.com/bitly/bitly-api-python.git

#Sample data
number = '8800793038'
location = 'NSUT Campus'
arrival_time = datetime.now()
when = datetime(2019,5,21,10,0)
time_of_vote = when.time()
date_of_vote = when.date()
nearest_polling_station = "https://www.google.com/maps/place/75°00\'00.0\"N+75°00\'00.0\"E"


message1 = f'Your pickup will reach {location} at {arrival_time}'
message2 = f'Voting procedure to begin on {date_of_vote} at {time_of_vote}. Your polling booth is at {nearest_polling_station}'

URL = 'http://www.way2sms.com/api/v1/sendCampaign'


api = 'VKG1SRHKHPV3M1THSION11VHNOESWX0Y'
secret = 'ZKASJD6MH8N5ZPQL'


# get request
def sendPostRequest(reqUrl, apiKey, secretKey, useType, phoneNo, senderId, textMessage):
    req_params = {
    'apikey':apiKey,
    'secret':secretKey,
    'usetype':useType,
    'phone': phoneNo,
    'message':textMessage,
    'senderid':senderId
    }
    req_params = parse.urlencode(req_params).encode()
    req = urllib.request.Request(reqUrl, req_params)
    resp = urllib.request.urlopen(req)
    return resp


# get response
response = sendPostRequest(URL, api, secret, 'stage', '8800793038', 'ELECTN', message2 )

