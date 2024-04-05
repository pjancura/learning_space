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
        database="ap"
    ) as connection:
        print(f"\n**********\nConnected to mySQL\nDatabase = {connection.database}\n**********\n")
        startdate = input("Enter start date (YYYY-MM-DD): []\n")
        enddate = input("Enter enddate (YYYY-MM-DD): []\n")
        vendor_id = input("Enter vendor id (1 - 50): []\n")
        inv_type = input("Open or Closed Invoices? [O/C/Press ENTER to skip]\n")                        #the [] means that just pressing enter will submit no specific start date

        query = "SELECT vendor_name, invoice_number, invoice_date FROM invoices JOIN vendors USING (vendor_id) "
        order_by = " ORDER BY vendor_name, invoice_date DESC "
        where = ""
        add_where = False
        if len(inv_type) > 0:
            if add_where:
                where += " AND "
            else:
                where += " WHERE "
                add_where = True
            if inv_type.upper() == "O":
                where += " invoices.invoice_total - invoices.payment_total - invoices.credit_total > 0 "
            elif inv_type.upper() == "C":
                where += " invoices.invoice_total - invoices.payment_total - invoices.credit_total = 0 "
        if len(startdate) > 0:
            if add_where:
                where += f" AND invoice_date >= '{startdate}' "
            else:
                where += f"  WHERE invoice_date >= '{startdate}' "
                add_where = True
        if len(enddate) > 0:
            if add_where:
                where += f" AND invoice_date <= '{enddate}' "
            else:
                where += f"  WHERE invoice_date <= '{enddate}' "
                add_where = True
        if len(vendor_id) > 0:
            if add_where:
                where += f" AND '{vendor_id}' = invoices.vendor_id "
            else:
                where += f"  WHERE '{vendor_id}' = invoices.vendor_id "
                add_where = True
        
        query = query + where + order_by

        print(f"\nQuery: {query}")
        with connection.cursor(dictionary = True) as cursor:      #this allows us to execute commands  ///write commits
            cursor.execute(query)
            result = cursor.fetchall()
            if len(result) > 0:
                for row in result:
                    print(f"{row['vendor_name']}\t{row['invoice_number']}\t{row['invoice_date']}")
            else:
                print("\nNothing matches your query")

except Error as e:
    print("ERROR: " + str(e))
else:
    print(f"\n*********\nConnection to mySQL Closed\n*********\n")


###############   PREVIOUS QUERIES #################

# query = """UPDATE invoices 
#         SET invoice_number = '999' 
#         WHERE invoice_id = 1"""
#   with connection.cursor() as cursor:      #this allows us to execute commands  ///write commits
#             cursor.execute(query)
#             connection.commit()

        # query = "SELECT vendor_name, invoice_number, invoice_date FROM invoices JOIN vendors USING (vendor_id) LIMIT 15;"
        # print(f"Query: {query}")
        # with connection.cursor() as cursor:      #this allows us to execute commands  ///write commits
        #     cursor.execute(query)
        #     result = cursor.fetchall()
        #     for row in result:
        #         print(f"{row[0]}\t{row[1]}\t{row[2]}")


        # query = "SELECT vendor_name, invoice_number, invoice_date FROM invoices JOIN vendors USING (vendor_id) LIMIT 15;"
        # print(f"Query: {query}")
        # with connection.cursor(dictionary = True) as cursor:      #this allows us to execute commands  ///write commits
        #     cursor.execute(query)
        #     result = cursor.fetchall()
        #     vendor_name = row['vendor_name']
        #     invoice_number = row['invoice_number']
        #     invoice_date = row['invoice_date']
        #     for row in result:
        #         print(f"{vendor_name}\t{row['invoice_number']}\t{invoice_date}")

        # startdate = input("Enter start date (YYYY-MM-DD): []\n")
        # enddate = input("Enter enddate (YYYY-MM-DD): []\n")
        # vendor_id = input("Enter vendor id (1 - 50): []\n")                        #the [] means that just pressing enter will submit no specific start date

        # query = "SELECT vendor_name, invoice_number, invoice_date FROM invoices JOIN vendors USING (vendor_id) "
        # order_by = " ORDER BY vendor_name, invoice_date DESC "
        # where = ""
        # add_where = False
        # if len(startdate) > 0:
        #     if add_where:
        #         where += f" AND invoice_date >= '{startdate}' "
        #     else:
        #         where += f"  WHERE invoice_date >= '{startdate}' "
        #         add_where = True
        # if len(enddate) > 0:
        #     if add_where:
        #         where += f" AND invoice_date <= '{enddate}' "
        #     else:
        #         where += f"  WHERE invoice_date <= '{enddate}' "
        #         add_where = True
        # if len(vendor_id) > 0:
        #     if add_where:
        #         where += f" AND '{vendor_id}' = invoices.vendor_id "
        #     else:
        #         where += f"  WHERE '{vendor_id}' = invoices.vendor_id "
        #         add_where = True
        
        # query = query + where + order_by

        # print(f"\nQuery: {query}")
        # with connection.cursor(dictionary = True) as cursor:      #this allows us to execute commands  ///write commits
        #     cursor.execute(query)
        #     result = cursor.fetchall()
        #     if len(result) > 0:
        #         for row in result:
        #             print(f"{row['vendor_name']}\t{row['invoice_number']}\t{row['invoice_date']}")
        #     else:
        #         print("\nNothing matches your query")
