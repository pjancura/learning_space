from hospital_session import session, db_name
from models import Department

from sqlalchemy import select
from sqlalchemy.exc import SQLAlchemyError

if __name__ == "__main__":

    try:
        stmt = select(Department)
        results = session.scalars(stmt).all()
        
        print(f"{str(stmt)}\n")
        for r in results:
            print(r)
            
    except SQLAlchemyError as e:
        print(f"Error reading the table: {e}")
    finally:
        print(f"\n*************  CONNECTION TO {db_name} CLOSING   *************\n")
        session.close()
