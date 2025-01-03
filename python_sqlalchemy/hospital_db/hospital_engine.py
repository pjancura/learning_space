# this will remove a lot of the boiler plate I have been writing

from sqlalchemy import create_engine
from sqlalchemy.exc import SQLAlchemyError 

def get_password() -> str:
    print("please enter your password:")
    return input()

user = 'pj'
password = 'passwordA1!'
host = 'localhost'
port = '3306'
db_name = "hospital_1"

try:
    engine = create_engine(f"mysql+mysqlconnector://{user}:{password if len(password) > 0 else get_password()}@{host}:{port}/{db_name}")
    print(f"\n*************  CONNECTION TO {db_name} OPENING   *************\n")
except SQLAlchemyError as e:
    print(f"Error connecting to the database: {e}")
    exit()
