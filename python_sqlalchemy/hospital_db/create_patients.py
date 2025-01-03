# this will create the table and load the data

from models import Base, Patient, Doctor, Department
from hospital_engine import engine, db_name
from hospital_session import session

import pandas as pd
from datetime import datetime
from sqlalchemy import text
from sqlalchemy.exc import SQLAlchemyError

table_name = "patients"

def custom_date_parser(date_string):
    return datetime.strptime(date_string, '%Y-%d-%m')

if __name__ == "__main__":
    # creating the table
    try:
        Patient.__table__.create(bind=engine)
        print(f"Table {table_name} created successfully")

        results = engine.connect().execute(text(f"SHOW CREATE TABLE {table_name}"))
        for result in results:
            for k, v in result._asdict().items():
                print(k, v, sep="\n\t")
        # engine.connect().execute(text("DROP TABLE patients"))
    except SQLAlchemyError as e:
        print(f"Error creating the table: {e}")
    finally:
        print(f"\n*************  CONNECTION TO {db_name} CLOSING   *************\n")
        engine.dispose()
    
    # inserting data into the table
    base_path = './starting_csv_files/'
    csv_file = base_path + f'hospital_{table_name}_3.csv'

    try:
        data = pd.read_csv(csv_file, parse_dates=['date_of_birth'], date_format=custom_date_parser)
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
            entity = Patient(**record)
            id_num = entity.patient_id
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
    