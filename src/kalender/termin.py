#!/usr/bin/env python
# coding: utf-8

import sqlite3

connection = sqlite3.connect("terminKalender.db")
cursor = connection.cursor()

sql_command = """
CREATE TABLE termin(
titel VARCHAR(100),
datumVon VARCHAR(100),
datumBis VARCHAR(100),
uhrzeitVon VARCHAR(100),
uhrzeitBis VARCHAR(100),
wiederholung VARCHAR(100),
ort VARCHAR(100),
beschreibung VARCHAR(1000),
sichtbarkeit VARCHAR(100));"""

cursor.execute(sql_command)
connection.commit()
connection.close()
