#  populates the doctors table

import pandas as pd
from sqlalchemy import text
from datetime import datetime

from models import Doctor, Base
from hospital_session import session, db_name

table_name = "doctors"

def custom_date_parser(date_string):
    return datetime.strptime(date_string, '%Y-%d-%m')

if __name__ == "__main__":

    base_path = './starting_csv_files/'
    csv_file = base_path + f'hospital_{table_name}.csv'

    try:
        data = pd.read_csv(csv_file, parse_dates=['date_of_birth'], date_format=custom_date_parser)
        print(f"{csv_file} loaded successfully")
    except Exception as e:
        print(f"Error loading csv: {e}")
        exit()

    try:
        records = data.to_dict(orient='records')

        for record in records:
            doctor = Doctor(**record)
            session.add(doctor)
        # session.execute(text("TRUNCATE TABLE doctors"))
        session.commit()
        print(f"Data uploaded successfully into {db_name}.{table_name}")
    except Exception as e:
        session.rollback()
        print(f"Error uploading data: {e}")
        exit()
    finally:
        print(f"*************  CONNECTION TO {db_name} CLOSING   *************\n")
        session.close()
