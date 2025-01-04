# creates the database hospital_1 in mysql

import sqlalchemy 

def get_password() -> str:
    print("please enter your password:")
    return input()

user = 'pj'
password = ''
host = 'localhost'
port = '3306'
db_name = "hospital_1"

engine = sqlalchemy.create_engine(f"mysql+mysqlconnector://{user}:{password if len(password) > 0 else get_password()}@{host}:{port}")

try:
    with engine.connect() as connection:
        connection.execute(sqlalchemy.text(f"CREATE DATABASE IF NOT EXISTS {db_name}"))

    print(f"Database {db_name} was created successfully")
    engine = sqlalchemy.create_engine(f"mysql+mysqlconnector://{user}:{password if len(password) > 0 else get_password()}@{host}:{port}/{db_name}")
    connection = engine.connect()
    print(f"Successfully connected to {db_name}")
except sqlalchemy.exc.OperationalError as e:
    print(f"Operational error: {e}")

except sqlalchemy.exc.SQLAlchemyError as e:
    print(f"An error occurred: {e}")

finally:
    print(f"*************  CONNECTION TO {db_name} CLOSING   *************")
    connection.close()