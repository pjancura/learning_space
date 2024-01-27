#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Jul  9 17:07:42 2023

@author: Paul
"""

import pandas as pd
import numpy as np

flights = pd.read_csv('data-analysis/flights.csv', index_col=False)

#print(flights)

###   converting columns to their appropriate data types
###   this only changes the datatype in realtime, it is not a permanent change

#  change a string to datetime object
# it infers the order of Year / Month / Date from how the string is written
flights['FL_DATE'] = pd.to_datetime(flights['FL_DATE'])

# change integers to Booleans
flights['CANCELLED'] = flights['CANCELLED'].astype(np.bool_)
flights['DIVERTED'] = flights['DIVERTED'].astype(np.bool_)



###  REMOVE COLUMNS FROM 2D TABLE
###   this is a permanent change to the table

# dropping YEAR, MONTH, DAY_OF_MONTH
flights.drop(columns=['YEAR','MONTH','DAY_OF_MONTH'], inplace=True)

###    RENAME COLUMNS

# this allows you to make column names more clear
#  uses a dictionary instead of a list because we are remapping the column name to a new name
flights.rename(columns={'DEST' : 'DESTINATION'}, inplace=True)

# get number of NULL values per column
#print(flights.isnull().sum())

# difference in CRS departure time and actual departure time
#print(flights['CRS_DEP_TIME'] - flights['DEP_TIME'])

# drop NaN/null/missing values
#print((flights['CRS_DEP_TIME'] - flights['DEP_TIME']).dropna())

