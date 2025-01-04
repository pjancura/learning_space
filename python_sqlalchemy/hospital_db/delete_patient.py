#  this simulates a CASCADE ON DELETE constraint 

from hospital_session import session, db_name
from models import Base, Patient, Doctor, Department, Nurse, Billing, Treatment

if __name__ == "__main__":

    try:
        # patient_id_to_delete = 1000  # adjust the patient_id to delete records of different patients

        treatment_to_delete = session.query(Treatment).filter(Treatment.patient_id == patient_id_to_delete).all()
        if treatment_to_delete:
            for treatment in treatment_to_delete:
                session.query(Billing).filter(Billing.treatment_id == treatment.treatment_id).delete()
                print(f"Deleting from billings records for treatment {treatment.treatment_id}")

        session.query(Treatment).filter(Treatment.patient_id == patient_id_to_delete).delete()
        print(f"Deleted from treatments all records related to patient {patient_id_to_delete}")

        session.query(Patient).filter(Patient.patient_id == patient_id_to_delete).delete()
        print(f"Deleted from patients, patient_id {patient_id_to_delete}")
        # session.query(Patient).filter(Patient.patient_id == patient_id_to_delete).delete()
        session.commit()
        print(f"Records of Patient {patient_id_to_delete} deleted from database {db_name}")

    except Exception as e:
        session.rollback()
        print(f"Error: {e}")

    finally:
        print(f"\n*************  CONNECTION TO {db_name} CLOSING   *************\n")
        session.close()