# first install the mysql connector module
# at the Windows command line:
# py -m pip install mysql-connector-python
#for Mac
#python3 (and then the rest is the same as windows)

from mysql.connector import connect, Error

try:
    with connect(
        host="localhost",
        user="root",
        password=">@rkness*SQL94",
        database="griegLyricPieces"
    ) as connection:
        print(f"\n**********\nConnected to mySQL\nDatabase = {connection.database}\n**********\n")

        query = "SELECT o.op_num, p.piece_name, p.sequence_num FROM pieces p JOIN opusInfo o ON p.opus_id = o.id_num;"

        print(f"\nQuery: {query}")
        with connection.cursor(dictionary = True) as cursor:      #this allows us to execute commands  ///write commits
            cursor.execute(query)
            result = cursor.fetchall()
            if len(result) > 0:
                for row in result:
                    print(f"{row['op_num']}\t{row['piece_name']}\t{row['sequence_num']}")
            else:
                print("\nNothing matches your query")

except Error as e:
    print("ERROR: " + str(e))
else:
    print(f"\n*********\nConnection to mySQL Closed\n*********\n")


###############   PREVIOUS QUERIES #################

        # query = "SELECT * FROM pieces"

        # print(f"\nQuery: {query}")
        # with connection.cursor(dictionary = True) as cursor:      #this allows us to execute commands  ///write commits
        #     cursor.execute(query)
        #     result = cursor.fetchall()
        #     if len(result) > 0:
        #         for row in result:
        #             print(f"{row['piece_id']}\t{row['piece_name']}\t{row['tempo']}")
        #     else:
        #         print("\nNothing matches your query")