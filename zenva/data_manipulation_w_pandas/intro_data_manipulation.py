# -*- coding: utf-8 -*-
"""
Spyder Editor

This is a temporary script file.
"""

import pandas as pd
import numpy as np

# DataFrame: a 2D table with rows and columns ( like excel)
df_data = {
    'col1': np.random.rand(5),
    'col2': np.random.rand(5),
    'col3': np.random.rand(5)
    }

df = pd.DataFrame(df_data)
#print(df)

#fetch some rows
#print(df[:2])

#fetch a column
#print(df['col1'])

#fetch multi columns, input a list of strings
print(df[['col3','col1']])