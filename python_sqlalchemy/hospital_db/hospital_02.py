from sqlalchemy import create_engine, Column, Integer, String, MetaData, Table
from sqlalchemy.ext.declarative import declarative_base

def get_password() -> str:
    print("please enter your password:")
    return input()

user = 'new_user'
password = 'passwordA1!'
host = 'localhost'
port = '3306'
db_name = "hospital_1"

engine = create_engine(f"mysql+mysqlconnector://{user}:{password if len(password) > 0 else get_password()}@{host}:{port}")

