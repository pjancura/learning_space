# import sqlalchemy 

# print(sqlalchemy.__version__)

# from sqlalchemy import create_engine, text

# engine = create_engine("sqlite+pysqlite:///:memory:", echo=True)

# with engine.connect() as conn:
#     result = conn.execute(text("select 'helloworld'"))
#     print(result.all())

import sqlalchemy

# Replace with your MySQL credentials
user = 'new_user'
# print("what's your password?")
# password = input()
password = ''
host = 'localhost'  # or your server IP
port = '3306'       # MySQL default port

# Connect to the MySQL server
try:
    # Connect to the MySQL server
    engine = sqlalchemy.create_engine(f'mysql+mysqlconnector://{user}:{password}@{host}:{port}')
    with engine.connect() as connection:
        connection.execute(sqlalchemy.text("USE griegLyricPieces_2"))
        result = connection.execute(sqlalchemy.text("DESCRIBE opusInfo"))
        for res in result:
            print(res)
        print()
        result_2 = connection.execute(sqlalchemy.text("DESCRIBE pieces"))
        for res in result_2:
            print(res)

        print()
        result_3 = connection.execute(sqlalchemy.text("""SELECT time_signature, COUNT(time_sig_id) AS total_times_used
                                                    FROM pieces p
                                                    JOIN timeSignatures ts ON ts.ts_id = p.time_sig_id
                                                    GROUP BY time_sig_id
                                                    ORDER BY total_times_used DESC
        """))
        for res in result_3:
            print(res)
    
    # # Update engine to connect to the new database
    # engine = sqlalchemy.create_engine(f'mysql+mysqlconnector://{user}:{password}@{host}:{port}/my_new_database')
except sqlalchemy.exc.SQLAlchemyError as e:
    print(f"An error occurred: {e}")
