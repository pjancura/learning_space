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

        possible_nurses_helping_patient = (
            select(
                Patient.gender,
                func.count(Patient.gender).label('count')
            ).group_by(Patient.gender)
        )
        results_2 = session.execute(possible_nurses_helping_patient).all()

        print(f"\n{str(possible_nurses_helping_patient)}\n")

        print(tuple(results_2[0]._asdict().keys()))      # this will print the column headers
        for r in results_2:
            print(r)

            
    except SQLAlchemyError as e:
        print(f"Error reading the table: {e}")
    finally:
        print(f"\n*************  CONNECTION TO {db_name} CLOSING   *************\n")
        session.close()
