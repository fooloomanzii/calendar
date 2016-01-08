#!/usr/bin/env python
# coding: utf-8

import sqlite3

connection = sqlite3.connect("meetingCalendar.db")
cursor = connection.cursor()

sql_command = """
CREATE TABLE meetingTable(
owner VARCHAR(100),
title VARCHAR(100),
dateFrom VARCHAR(100),
dateTo VARCHAR(100),
timeFrom VARCHAR(100),
timeTo VARCHAR(100),
location VARCHAR(100),
description VARCHAR(1000),
repeat VARCHAR(100),
repeatTo VARCHAR(100),
visibility VARCHAR(100));"""

cursor.execute(sql_command)
connection.commit()
connection.close()