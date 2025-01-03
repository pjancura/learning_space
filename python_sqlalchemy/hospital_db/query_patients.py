from hospital_session import session, db_name
from models import Patient, Doctor, Department

from sqlalchemy import select, func
from sqlalchemy.orm import aliased
from sqlalchemy.exc import SQLAlchemyError

if __name__ == "__main__":

    try:
        d = aliased(Department, name="d")
        stmt = (
            select(
                func.concat(Patient.first_name, " ", Patient.last_name).label('patient_name'), 
                      func.concat(Doctor.first_name, " ", Doctor.last_name).label('doctor_name'),
                      d.department_name
                      )
            .join(Doctor, Doctor.doctor_id == Patient.primary_doctor_id)
            .join(d, d.department_id == Doctor.department_id)
            .where(Patient.gender == "male")
            .limit(10)
        )
        results = session.execute(stmt).all()
        
        print(f"{str(stmt)}\n")

        print(tuple(results[0]._asdict().keys()))      # this will print the column headers
        for r in results:
            print(r)

        stmt_2 = (
            select(
                Patient.gender,
                func.count(Patient.gender).label('count')
            ).group_by(Patient.gender)
        )
        results_2 = session.execute(stmt_2).all()

        print(f"\n{str(stmt_2)}\n")

        print(tuple(results_2[0]._asdict().keys()))      # this will print the column headers
        for r in results_2:
            print(r)

            
    except SQLAlchemyError as e:
        print(f"Error reading the table: {e}")
    finally:
        print(f"\n*************  CONNECTION TO {db_name} CLOSING   *************\n")
        session.close()
