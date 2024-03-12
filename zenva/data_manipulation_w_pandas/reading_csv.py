#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Fri Jul  7 15:02:06 2023

@author: Paul
"""

import pandas as pd
import numpy as np

#read an excel spreadsheet
# can only read 1 sheet at a time
tracks = pd.read_excel('course_files/Tracks.xls', sheet_name=0)

# print(tracks)

#print tracks
#print(tracks.columns)
#print(tracks['Milliseconds'])

# read a CSV file
# pandas uses the first column as an index column
# index_col = False adds a column for the index
flights = pd.read_csv('course_files/flights.csv', index_col=False)
#print(flights)

#print(flights[['ORIGIN', 'DEST']])

# select a defined set of rows

#print(flights[:10])

# select columns and rows
# the i of iloc stands for integer
# below demonstrates selecting a single cell using coordinates [row, col]
#print(flights.iloc[0,0])

# selecting 3rd row and 1st column
#print(flights.iloc[2,1])

# mixing row indecies with string column names
#print (flights.iloc[2, flights.columns.get_loc('DAY_OF_MONTH')])

#print(flights.iloc[:3, flights.columns.get_loc('DAY_OF_MONTH')])

#print(flights.iloc[3000:3010, [flights.columns.get_loc('DAY_OF_MONTH'), flights.columns.get_loc('DEST')]])



###  SORTING DATA

# sort values by a column
#print(flights.sort_values(by=['DISTANCE'], ascending=False))

#print(flights.sort_values(by=['AIR_TIME'], ascending=False))

# sorting values by multi columns
#print(flights.sort_values(by=['DISTANCE', 'AIR_TIME'], ascending=False))




###    FILTERING THE DATA


# fetch all January flights
#print(flights[flights['MONTH'] == 1])

# fetch all fligths on the 1st of the month
#print(flights[flights['DAY_OF_MONTH'] == 1])

# fetch all flights that leave New York
#print(flights[flights['ORIGIN_STATE_NM'] == 'New York'])

long_flights = flights[flights['DISTANCE'] > 4000]
#print(long_flights)

#this fetches the flights with a DISTANCE > 4000 and ORIGIN_STATE_NM == Hawaii
#print(long_flights[long_flights['ORIGIN_STATE_NM'] =='Hawaii'])


# this is a bitwise OR operation
#print(long_flights[(long_flights['ORIGIN_STATE_NM'] == 'Hawaii') | (long_flights['DEST_STATE_NM'] == 'Hawaii')])

#this is a bitwise AND operation
#print(long_flights[(long_flights['MONTH'] == 1) & (long_flights['ORIGIN_CITY_NAME'] == "Washington, DC")])

# this is a bitwise AND NOT operation
#print(long_flights[(long_flights['MONTH'] == 1) & ~(long_flights['ORIGIN_CITY_NAME'] == "Washington, DC")])

###    GROUPING DATA

# group flights by Month
flights_by_month = flights.groupby('MONTH')

# get group of flights in December

#print(flights_by_month.get_group(12))

# total distance travelled each month
print(flights_by_month['DISTANCE'].aggregate(np.sum))

# average distance travelled by each flight each month
print(flights_by_month['DISTANCE'].aggregate(np.average))

# min distance travelled each month
print(flights_by_month['DISTANCE'].aggregate(np.min))


# get the max flight distance travelled (only returns one value)
print(flights_by_month['DISTANCE'].aggregate(np.sum).max())

# get the max flight distance travelled and the month it happened in (only returns one value)
print(flights_by_month['DISTANCE'].aggregate(np.sum).sort_values(ascending=False).head(1))


# get the min flight distance travelled and the month it happened in (only returns one value)
print(flights_by_month['DISTANCE'].aggregate(np.sum).sort_values(ascending=False).tail(1))

# number of cancelled flights per month
print(flights_by_month['CANCELLED'].aggregate(np.sum).sort_values(ascending=False))





























