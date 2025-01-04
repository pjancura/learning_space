from hospital_session import session, db_name
from models import Patient, Doctor, Department, Billing, Treatment, Nurse

from sqlalchemy import select, func
from sqlalchemy.orm import aliased
from sqlalchemy.exc import SQLAlchemyError

if __name__ == "__main__":

    try:
        total_bills = func.count(Treatment.patient_id).label("total_bills")
        patient_name = func.concat(Patient.first_name, " ", Patient.last_name).label('patient_name')
        total_amount_owed = (
            select(
                patient_name, 
                func.round(func.sum(Billing.charge_amount).label("total_charged"), 2),
                func.round(func.sum(Billing.paid_amount).label("total_paid"), 2),
                total_bills
            )
            .join(Treatment, Treatment.patient_id == Patient.patient_id)
            .join(Billing, Billing.treatment_id == Treatment.treatment_id)
            .group_by(Patient.patient_id)
            .order_by(total_bills.asc())
            .limit(10)
        )
        results = session.execute(total_amount_owed).all()
        
        print(f"{str(total_amount_owed)}\n")

        print(tuple(results[0]._asdict().keys()))      # this will print the column headers
        for r in results:
            print(r)


        doctor_name = func.concat(Doctor.first_name, " ", Doctor.last_name).label('doctor_name')
        nurse_name = func.concat(Nurse.first_name, " ", Nurse.last_name).label('nurse_name')

        people_involved_in_treatment = (
            select(
                Treatment.treatment_id,
                Patient.patient_id,
                Treatment.reason_for_visit,
                patient_name,
                doctor_name,
                nurse_name,
                Department.department_name
            )
            .join(Patient, Patient.patient_id == Treatment.patient_id)
            .join(Doctor, Doctor.doctor_id == Patient.primary_doctor_id)
            .join(Department, Department.department_id == Doctor.department_id)
            .join(Nurse, Nurse.department_id == Doctor.department_id)
            .where(Treatment.treatment_id == 1, Nurse.shift_details == "day shift")
        )
        results_2 = session.execute(people_involved_in_treatment).all()

        print(f"\n{str(people_involved_in_treatment)}\n")

        print(tuple(results_2[0]._asdict().keys()))      # this will print the column headers
        for r in results_2:
            print(r)

            
    except SQLAlchemyError as e:
        print(f"Error reading the table: {e}")
    finally:
        print(f"\n*************  CONNECTION TO {db_name} CLOSING   *************\n")
        session.close()
