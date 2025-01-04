#  populates the departments table

import pandas as pd
from sqlalchemy import create_engine
from sqlalchemy.orm import sessionmaker
from sqlalchemy.exc import SQLAlchemyError

from hospital_02 import Base, Departments
from hospital_03 import Doctors

def get_password() -> str:
    print("please enter your password:")
    return input()

user = 'pj'
password = 'passwordA1!'
host = 'localhost'
port = '3306'
db_name = "hospital_1"

if __name__ == "__main__":

    try:
        engine = create_engine(f"mysql+mysqlconnector://{user}:{password if len(password) > 0 else get_password()}@{host}:{port}/{db_name}")
        Base.metadata.create_all(engine)
        Session = sessionmaker(bind=engine)
        session = Session()
        print(f"\n*************  CONNECTION TO {db_name} OPENING   *************\n")
    except SQLAlchemyError as e:
        print(f"Error connecting to the database: {e}")
        exit()

    base_path = './starting_csv_files/'
    csv_file = base_path + 'hospital_departments.csv'

    try:
        data = pd.read_csv(csv_file)
        print(f"{csv_file} loaded successfully")
    except Exception as e:
        print(f"Error loading csv: {e}")
        exit()

    try:
        records = data.to_dict(orient='records')

        for record in records:
            doctor = Departments(**record)
            session.add(doctor)
        
        session.commit()
        print("Data uploaded successfully into hospital_1.departments")
    except Exception as e:
        session.rollback()
        print(f"Error uploading data: {e}")
        exit()
    finally:
        print(f"*************  CONNECTION TO {db_name} CLOSING   *************\n")
        session.close()
