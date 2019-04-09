## API to store and retreive the data and then fetch it back when requested from a different client.
import json
from urllib import request
from flask import Flask, request
from flask_restful import Resource, Api
import base64
app = Flask(__name__)
api = Api(app)

#Sample Data:

Candidate_information = {'Freddy Mercury': ["freddy Mercury","Party X","Dwarka","Base64String"] }

class CandidateInfo(Resource):
    def __init__(self, Candidate_information):
        def __init__(self,Resource):
            self.Candidate_information = Candidate_information
    def get(self,Candidate_Name):
        return {Candidate_Name : Candidate_information[Candidate_Name]} 
    def put(self,Candidate_Name):
        Candidate_information[Candidate_Name] = request.form['data']
        return {Candidate_Name : Candidate_information[Candidate_Name]}
    def get_images(self,Candidate_Name,Constituency):
        c = Candidate_information[Candidate_Name][1]
        with open("/PartyLogos/% s" % c, 'rb') as partylogo:
            Base_logo = base64.b64encode(partylogo)        
        with open(f"{Candidate_Name}_{Constituency}.png",'rb') as f:
            r= f.read()
            Base_Cand_Photo = base64.b64encode(r)
        return Base_logo,Base_Cand_Photo
    def store_images(self,):
        pass
    def new_Candidate(self, Cand_info):
        Candidate_information.update(Cand_info)





api.add_resource(CandidateInfo,'/')

app.run(debug=True)
