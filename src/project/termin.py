#!/usr/bin/env python
# coding: utf-8

import sqlite3

connection = sqlite3.connect("terminKalender.db")
cursor = connection.cursor()

sql_command = """
CREATE TABLE termin(
email VARCHAR(100) PRIMARY KEY,
titel VARCHAR(100),
datum VARCHAR(100),
uhrzeit VARCHAR(100),
zeitspanne VARCHAR(100),
wiederholung VARCHAR(100),
ort VARCHAR(100),
besitzer VARCHAR(100),
beschreibung VARCHAR(1000),
sichtbarkeit VARCHAR(100));"""

cursor.execute(sql_command)
connection.commit()
connection.close()