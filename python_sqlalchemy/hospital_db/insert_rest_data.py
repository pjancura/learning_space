# this will create the table and load the data
# change the table_name variable to correct table_name
# change the class type for record
# change id_num to correspond to class

from models import Base, Patient, Doctor, Department, Nurse, Treatment, Billing
from hospital_engine import db_name
from hospital_session import session

import pandas as pd
from datetime import datetime
from sqlalchemy import text
from sqlalchemy.exc import SQLAlchemyError

table_name = "billings"

def custom_date_parser(date_string):
    return datetime.strptime(date_string, '%Y-%d-%m')

if __name__ == "__main__":

    base_path = './starting_csv_files/'
    csv_file = base_path + f'hospital_{table_name}.csv'

    try:
        data = pd.read_csv(csv_file)
        print(f"{csv_file} loaded successfully")
        print(f"column names:\n\t{data.columns}")
    except Exception as e:
        print(f"Error loading csv: {e}")
        exit()

    try:
        records = data.to_dict(orient='records')

        # for i in range(10):
        #     print(records[i])
        id_num = 0
        for record in records:
            entity = Billing(**record)
            id_num = entity.billing_id
            session.add(entity)
        session.commit()
        print(f"Data uploaded successfully into {db_name}.{table_name}")
    except Exception as e:
        session.rollback()
        print(f"FAILED AT: \t\t{id_num}")
        print(f"Error uploading data: {e}")
        exit()
    finally:
        print(f"*************  CONNECTION TO {db_name} CLOSING   *************\n")
        session.close()
    