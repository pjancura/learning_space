# creates the doctors table

from sqlalchemy import create_engine, Column, Integer, String, text, Date, engine, ForeignKey, MetaData, Table
from sqlalchemy.orm import declarative_base
from sqlalchemy.exc import SQLAlchemyError
from sqlalchemy.schema import CheckConstraint
from sqlalchemy.engine import Row


def get_password() -> str:
    print("please enter your password:")
    return input()

def print_results(results: list[Row]) -> None:
    for r in results:
        print(r)

user = 'pj'
password = ''
host = 'localhost'
port = '3306'
db_name = "hospital_1"

meta = MetaData()

tbl_departments = Table(
    "departments",
    meta,
    Column('department_id',Integer, primary_key=True, autoincrement=True, nullable=False),
    Column('department_name', String(100), nullable=False),
    Column('floor_number', nullable=False),
    Column('contact_number', String(12), nullable=False)
)

Base = declarative_base()

class Doctors(Base):
    __tablename__ = 'doctors'

    doctor_id = Column(Integer, primary_key=True, autoincrement=True, nullable=False)
    first_name = Column(String(100), nullable=False)
    last_name = Column(String(100), nullable=False)
    gender = Column(String(16))
    date_of_birth = Column(Date, nullable=False)
    department_id = Column(Integer, ForeignKey(tbl_departments.c.department_id), nullable=False)
    phone_number = Column(String(12), nullable=True)
    email = Column(String(256), nullable=True)
    years_of_experience = Column(Integer, nullable=False)

    __table_args__ = (
        CheckConstraint("LENGTH(phone_number) = 12 AND phone_number REGEXP '^[0-9]{3}-[0-9]{3}-[0-9]{4}$'", 
                        name='check_phone_number_format'),
        CheckConstraint("email LIKE '%@%'", name="check_email_format"),
        CheckConstraint("years_of_experience >= 0", name='check_years_of_experience')
    )

    
    def __repr__(self):
        return (
            f"<Doctor(doctor_id={self.doctor_id}, first_name='{self.first_name}', "
            f"last_name='{self.last_name}', gender='{self.gender}', date_of_birth={self.date_of_birth}, "
            f"department_id={self.department_id}, phone_number='{self.phone_number}', "
            f"email='{self.email}', years_of_experience={self.years_of_experience})>"
        )

if __name__ == "__main__":

    try:
        engine = create_engine(f"mysql+mysqlconnector://{user}:{password if len(password) > 0 else get_password()}@{host}:{port}/{db_name}")
        print(f"\n*************  CONNECTION TO {db_name} OPENING   *************\n")
    except SQLAlchemyError as e:
        print(f"Error connecting to the database: {e}")
        exit()


    try:

        # print_results(engine.connect().execute(text(f"DROP TABLE doctors")))
        Base.metadata.create_all(engine)
        print("Table 'doctors' created successfully!")

        results = engine.connect().execute(text(f"SHOW CREATE TABLE doctors"))
        for result in results:
            for k, v in result._asdict().items():
                print(k, v, sep="\n\t")

    except SQLAlchemyError as e:
        print(f"Error creating the table: {e}")

    finally:
        print(f"\n*************  CONNECTION TO {db_name} CLOSING   *************\n")
        engine.dispose()