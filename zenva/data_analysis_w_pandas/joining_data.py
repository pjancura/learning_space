#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Jul  9 20:34:30 2023

@author: Paul
"""

import pandas as pd
import numpy as np


flights = pd.read_csv('data-analysis/flights.csv', index_col=False)

# load the mapping CSV file
days_of_week = pd.read_csv('data-analysis/L_WEEKDAYS.csv', index_col=False)
#print(days_of_week)

merged = pd.merge(flights, days_of_week, left_on='DAY_OF_WEEK', right_on='Code')

# remove the DAY_OF_WEEK  and Code columns (inplace=True)  <-- that tells the python interpreter to save the state of the file (IIRC)
merged.drop(columns=['DAY_OF_WEEK', 'Code'], inplace=True)
# rename Description -> DAY_OF_WEEK
merged.rename(columns={'Description': 'DAY_OF_WEEK'}, inplace=True)

print(merged)


