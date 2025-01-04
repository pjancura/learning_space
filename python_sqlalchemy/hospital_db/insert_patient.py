#  this will insert a new record in patients

from hospital_session import session, db_name
from models import Patient, Doctor, Department, Billing, Treatment, Nurse

from sqlalchemy import select, func
from sqlalchemy.orm import aliased
from sqlalchemy.exc import SQLAlchemyError

if __name__ == "__main__":

    try:
        new_patient = Patient(
            first_name = "Jane",
            last_name = "Doe",
            gender = "Female",
            date_of_birth = "1990-05-15",
            phone_number = "216-123-4567",
            street_address = "123 Elm Rd",
            state_abbv = "OH",
            zip_code = 44101,
            primary_doctor_id = 3,
            insurance_id = "1ZZ2VV345G8"
        )

        session.add(new_patient)
        session.commit()
        print(f"Patient {new_patient.first_name} {new_patient.last_name} added successfully.")

    except Exception as e:
        session.rollback()
        print(f"Error: {e}")

    finally:
        print(f"\n*************  CONNECTION TO {db_name} CLOSING   *************\n")
        session.close()