#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Jul  9 21:16:56 2023

@author: Paul
"""

import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from scipy.stats import linregress

# load the flights dataset
flights = pd.read_csv('data-analysis/flights.csv', index_col=False)

# get basic statistics for the dataframe
#print(flights.describe())

# compute the mean and standard deviation for DISTANCE column
#print(flights['DISTANCE'].mean())
#print(flights['DISTANCE'].std())

# mean of the difference of CRS departure and actual departure time
#print((flights['CRS_DEP_TIME'] - flights['DEP_TIME']).mean())

flights_subsample = flights.sample(1000)

#print(flights_subsample)


# perform linear regression
slope, intercept, r_value, _, _ = linregress(flights_subsample['DISTANCE'], flights_subsample['CRS_ELAPSED_TIME'])
print('y= {}x + {}; r={}'.format(slope, intercept, r_value))

# plot the data
plt.scatter(flights_subsample['DISTANCE'], flights_subsample['CRS_ELAPSED_TIME'])

# generate some X values to feed into the equation
x = np.linspace(flights_subsample['DISTANCE'].min(), flights_subsample['DISTANCE'].max(), 1000)
# calculate the y values using the learned slope and intercept
y = slope * x + intercept

plt.plot(x, y, 'r--')

#plt.show()

# use learned slope and intercept for prediction:
distance = 5000
flight_time = slope * distance + intercept
print(flight_time)