# creates the database hospital_1 in mysql

import sqlalchemy 

def get_password() -> str:
    print("please enter your password:")
    return input()

user = 'new_user'
password = ''
host = 'localhost'
port = '3306'
db_name = "hospital_1"

engine = sqlalchemy.create_engine(f"mysql+mysqlconnector://{user}:{password if len(password) > 0 else get_password()}@{host}:{port}")

try:
    connection = engine.connect()
    connection.close()

    print(f"Database '{db_name}' already exists.")

except sqlalchemy.exc.OperationalError as e:
    if "1049" in str(e):
        # 1049 is the error code for the database not existing
        try:
            connection.execute(sqlalchemy.text(f"CREATE DATABASE {db_name}"))
            print(f"Databse '{db_name}' created successfully.")
        except Exception as e:
            print(f"Error creating database: {e}")
    else:
        print(f"Error connecting to database: {e}")

except sqlalchemy.exc.SQLAlchemyError as e:
    print(f"An error occurred: {e}")

finally:
    print(f"*************  CONNECTION TO {db_name} CLOSING   *************")
    connection.close()