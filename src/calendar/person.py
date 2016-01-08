#!/usr/bin/env python
# coding: utf-8

import sqlite3

connection = sqlite3.connect("personCalendar.db")
cursor = connection.cursor()

sql_command = """
CREATE TABLE personTable(
firstName VARCHAR(100),
surname VARCHAR(100),
password VARCHAR(100),
email VARCHAR(100) PRIMARY KEY,
securityQuestion VARCHAR(100),
answer VARCHAR(100));"""

cursor.execute(sql_command)
connection.commit()
connection.close()