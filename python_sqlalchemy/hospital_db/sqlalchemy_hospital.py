import sqlalchemy

user = 'new_user'
password = 'passwordA1!'
host = 'localhost'
port = '3306'

try:
    engine = sqlalchemy.create_engine(f"mysql+mysqlconnector://{user}:{password}@{host}/{port}")

except sqlalchemy.exc.SQLAlchemyError as e:
    print(f"An error occurred: {e}")