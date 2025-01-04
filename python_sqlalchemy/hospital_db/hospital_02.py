# this will create the departments table 

from sqlalchemy import create_engine, Column, Integer, String, text
from sqlalchemy.orm import declarative_base
from sqlalchemy.exc import SQLAlchemyError
from sqlalchemy.schema import CheckConstraint


def get_password() -> str:
    print("please enter your password:")
    return input()

user = 'pj'
password = ''
host = 'localhost'
port = '3306'
db_name = "hospital_1"



Base = declarative_base()

class Departments(Base):
    __tablename__ = 'departments'

    department_id = Column(Integer, primary_key=True, autoincrement=True, nullable=False)
    department_name = Column(String(100), nullable=False)
    floor_number = Column(Integer, nullable=False)
    contact_number = Column(String(12), nullable=False)

    # this will constrain the format for the contact_number
    __table_args__ = (
        CheckConstraint("LENGTH(contact_number) = 12 AND contact_number REGEXP '^[0-9]{3}-[0-9]{3}-[0-9]{4}$'",
                        name='check_contact_number_format'),
    )

if __name__ == "__main__":

    try:
        engine = create_engine(f"mysql+mysqlconnector://{user}:{password if len(password) > 0 else get_password()}@{host}:{port}/{db_name}")
    except SQLAlchemyError as e:
        print(f"Error connecting to the database: {e}")
        exit()

    try:
        Base.metadata.create_all(engine)
        print("Table 'departments' created successfully!")
        results = engine.connect().execute(text(f"SHOW CREATE TABLE departments"))
        for result in results:
            print(result)

    except SQLAlchemyError as e:
        print(f"Error creating the table: {e}")

    finally:
        print(f"*************  CONNECTION TO {db_name} CLOSING   *************")
        engine.dispose()