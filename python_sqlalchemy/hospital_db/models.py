from sqlalchemy import Column, Integer, String, Date, ForeignKey, Enum, Float, Boolean
from sqlalchemy.orm import declarative_base
from sqlalchemy.schema import CheckConstraint
from sqlalchemy.types import BigInteger

Base = declarative_base()

class Department(Base):
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

    def __repr__(self):
        return (
            f"<Department(department_id={self.department_id}, department_name='{self.department_name}', "
            f"floor_number={self.floor_number}, contact_number='{self.contact_number}')>"
        )

class Doctor(Base):
    __tablename__ = 'doctors'

    doctor_id = Column(Integer, primary_key=True, autoincrement=True, nullable=False)
    first_name = Column(String(100), nullable=False)
    last_name = Column(String(100), nullable=False)
    gender = Column(String(16))
    date_of_birth = Column(Date, nullable=False)
    department_id = Column(Integer, ForeignKey("departments.department_id"), nullable=False)
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
    

class Patient(Base):
    __tablename__ = "patients"

    patient_id = Column(Integer, primary_key=True, autoincrement=True, nullable=False)
    first_name = Column(String(100), nullable=False)
    last_name = Column(String(100), nullable=False)
    gender = Column(String(16))
    date_of_birth = Column(Date, nullable=False)
    phone_number = Column(String(12), nullable=True)
    email = Column(String(256), nullable=True)
    street_address = Column(String(256), nullable=True)
    state_abbv = Column(String(2), nullable=True)
    zip_code = Column(String(5), nullable=True)
    primary_doctor_id = Column(Integer, ForeignKey("doctors.doctor_id"), nullable=True)
    insurance_id = Column(String(16), nullable=True)

    __table_args__ = (
        CheckConstraint("LENGTH(phone_number) = 12 AND phone_number REGEXP '^[0-9]{3}-[0-9]{3}-[0-9]{4}$'", 
                        name='check_phone_number_format_patients'),
        CheckConstraint("email LIKE '%@%'", name="check_email_format_2"),
    )

    def __repr__(self):
        return (
            f"<Patient(patient_id={self.patient_id}, first_name='{self.first_name}', last_name='{self.last_name}', "
            f"gender='{self.gender}', date_of_birth={self.date_of_birth}, phone_number='{self.phone_number}', "
            f"email='{self.email}', address_street='{self.street_address}', state='{self.state_abbv}', "
            f"zip_code={self.zip_code}, primary_doctor_id={self.primary_doctor_id}, insurance_id={self.insurance_id})>"
        )

class Nurse(Base):
    __tablename__ = 'nurses'

    nurse_id = Column(Integer, primary_key=True, autoincrement=True, nullable=False)
    first_name = Column(String(100), nullable=False)
    last_name = Column(String(100), nullable=False)
    gender = Column(String(16))
    date_of_birth = Column(Date, nullable=False)
    department_id = Column(Integer, ForeignKey("departments.department_id"), nullable=False)
    phone_number = Column(String(12), nullable=True)
    email = Column(String(256), nullable=True)
    years_of_experience = Column(Integer, nullable=False)
    shift_details = Column(Enum("day shift", "night shift", "weekend shift"), nullable=False)

    __table_args__ = (
        CheckConstraint("LENGTH(phone_number) = 12 AND phone_number REGEXP '^[0-9]{3}-[0-9]{3}-[0-9]{4}$'", 
                        name='check_phone_number_format_nurses'),
        CheckConstraint("email LIKE '%@%'", name="check_email_format_nurses"),
        CheckConstraint("years_of_experience >= 0", name='check_years_of_experience_nurses')
    )

    def __repr__(self):
        return (
            f"<Nurse(nurse_id={self.nurse_id}, first_name='{self.first_name}', "
            f"last_name='{self.last_name}', gender='{self.gender}', date_of_birth={self.date_of_birth}, "
            f"department_id={self.department_id}, phone_number='{self.phone_number}', "
            f"email='{self.email}', years_of_experience={self.years_of_experience}, shift_details='{self.shift_details}')>"
        )



class Treatment(Base):
    __tablename__ = "treatments"

    treatment_id = Column(Integer, nullable=False, primary_key=True, autoincrement=True)
    patient_id = Column(Integer, ForeignKey("patients.patient_id"), nullable=False)
    doctor_id = Column(Integer, ForeignKey("doctors.doctor_id"), nullable=False)
    reason_for_visit = Column(String(256), nullable=False)
    floor_number = Column(Integer, nullable=False)
    room_number = Column(Integer, nullable=False)
    treatment_start_date = Column(Date, nullable=False)
    treatment_days = Column(Integer, nullable=False)


    def __repr__(self):
        return (
            f"<Treatments(treatment_id={self.treatment_id}, patient_id={self.patient_id}, "
            f"doctor_id={self.doctor_id}, reason_for_visit='{self.reason_for_visit}', "
            f"floor_number={self.floor_number}, room_number={self.room_number}, "
            f"treatment_start_date={self.treatment_start_date}, treatment_days={self.treatment_days})>"
        )

class Billing(Base):
    __tablename__ = "billings"

    billing_id = Column(BigInteger, primary_key=True, nullable=False)
    treatment_id = Column(Integer, ForeignKey("treatments.treatment_id"), nullable=False)
    charge_amount = Column(Float, nullable=False)
    paid_amount = Column(Float, nullable=False)
    paid_status = Column(Boolean, nullable=False)

    def __repr__(self):
        return (
            f"<Billing(billing_id={self.billing_id}, treatment_id={self.treatment_id}, "
            f"charge_amount={self.charge_amount}, paid_amount={self.paid_amount}, "
            f"paid_status={self.paid_status})>"
        )
    