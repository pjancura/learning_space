#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Jul  9 20:05:28 2023

@author: Paul
"""

import pandas as pd
import numpy as np


flights = pd.read_csv('data-analysis/flights.csv', index_col=False)

# plot histogram of CRS departure times
#flights['CRS_DEP_TIME'].hist()

# plot histogram of CRS arrival times
#flights['CRS_ARR_TIME'].hist()

# average DISTANCE of flights per month
flights_by_month = flights.groupby('MONTH')
#flights_by_month['DISTANCE'].aggregate(np.mean).plot()

# average distance that flights travel by day of the week
flights_by_weekday = flights.groupby('DAY_OF_WEEK')
#flights_by_weekday['DISTANCE'].aggregate(np.mean).plot()