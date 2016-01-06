#!/usr/bin/env python
# coding: utf-8

import sqlite3

connection = sqlite3.connect("anmeldungKalender.db")
cursor = connection.cursor()

sql_command = """
CREATE TABLE anmeldung(
nachname VARCHAR(100),
vorname VARCHAR(100),
passwort VARCHAR(100),
email VARCHAR(100) PRIMARY KEY,
sicherheitsfrage VARCHAR(100),
antwort VARCHAR(100));"""

cursor.execute(sql_command)
connection.commit()
connection.close()
