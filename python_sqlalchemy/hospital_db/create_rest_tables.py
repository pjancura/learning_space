# this will create the table and load the data

from models import Base, Patient, Doctor, Department, Nurse, Treatment, Billing
from hospital_engine import engine, db_name

from sqlalchemy import text
from sqlalchemy.exc import SQLAlchemyError

table_names: list[str] = ["nurses", "treatments", "billings"]


if __name__ == "__main__":
    # creating the table
    try:
        Nurse.__table__.create(bind=engine)
        print(f"Table nurses created successfully")
        Treatment.__table__.create(bind=engine)
        print(f"Table treatments created successfully")
        Billing.__table__.create(bind=engine)
        print(f"Table billings created successfully")

        for table in table_names:
            results = engine.connect().execute(text(f"SHOW CREATE TABLE {table}"))
            for result in results:
                for k, v in result._asdict().items():
                    print(k, v, sep="\n\t")
            # engine.connect().execute(text("DROP TABLE patients"))
    except SQLAlchemyError as e:
        print(f"Error creating the table: {e}")
    finally:
        print(f"\n*************  CONNECTION TO {db_name} CLOSING   *************\n")
        engine.dispose()
    
 