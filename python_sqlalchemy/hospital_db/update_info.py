#  this will change patient 538's doctor_id to one that is the cardiology discipline

from hospital_session import session, db_name
from models import Patient, Doctor, Department, Billing, Treatment, Nurse

from sqlalchemy import select, func
from sqlalchemy.orm import aliased
from sqlalchemy.exc import SQLAlchemyError

if __name__ == "__main__":

    try:
        patient_name = func.concat(Patient.first_name, " ", Patient.last_name).label('patient_name')
        doctor_name = func.concat(Doctor.first_name, " ", Doctor.last_name).label('doctor_name')
        doctor_f_name = "Mohandas"
        doctor_l_name = "Karim"
        doctor_and_department = (
            select(
                Doctor.doctor_id,
                doctor_name,
                Department.department_name
            )
            .join(Department, Department.department_id == Doctor.department_id)
            .where(Department.department_name == "Cardiology", Doctor.first_name == doctor_f_name, Doctor.last_name == doctor_l_name)
        )
        results = session.execute(doctor_and_department).all()
        
        print(f"{str(doctor_and_department)}\n")

        print(tuple(results[0]._asdict().keys()))      # this will print the column headers
        for r in results:
            print(r)
    except SQLAlchemyError as e:
        print(f"Error reading the table: {e}")

    try:
        p_id = 538
        new_doctor = results[0]._asdict()['doctor_id']

        patient_to_update = session.query(Patient).filter(Patient.patient_id == p_id).first()
        print("\n", patient_to_update)

        if patient_to_update:
            patient_to_update.primary_doctor_id = new_doctor
            session.commit()
            print(f"Updated patient {p_id}'s doctor to {results[0]._asdict()['doctor_name']}")
        else:
            print(f"No patient record found for patient {p_id}")

        patient_to_update = session.query(Patient).filter(Patient.patient_id == p_id).first()
        print(f"Updated record:\n{patient_to_update}")

    except SQLAlchemyError as e:
        print(f"Error updating the patient {p_id}: {e}")


    finally:
        print(f"\n*************  CONNECTION TO {db_name} CLOSING   *************\n")
        session.close()