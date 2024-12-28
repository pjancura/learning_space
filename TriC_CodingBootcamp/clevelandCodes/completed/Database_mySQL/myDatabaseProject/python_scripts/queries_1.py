from mysql.connector import connect, Error

try:
    with connect(
        host="localhost",
        user="root",
        password=">@rkness*SQL94",
        database="griegLyricPieces_2"
    ) as connection:
        print(f"\n**********\nConnected to mySQL\nDatabase = {connection.database}\n**********\n")

        query = '''
                describe opusInfo;
            '''

        print(f"\nQuery: {query}")
        with connection.cursor(dictionary = True) as cursor:      #this allows us to execute commands  ///write commits
            cursor.execute(query)
            result = cursor.fetchall()
            if len(result) > 0:
                for row in result:
                    print(row['Field'], row['Type'], sep="\t")
            else:
                print("\nNothing matches your query")


except Error as e:
    print("ERROR: " + str(e))
else:
    connection.close()
    print(f"\n*********\nConnection to mySQL Closed\n*********\n")
