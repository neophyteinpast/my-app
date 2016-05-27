# my-app
A console java application which displays a welcome message depending on the time of the day:

 	- 06:00 - 09:00 - "Good morning, World!"
	- 09:00 - 19:00 - "Good day, World!"
	- 19:00 - 23:00 - "Good evening, World!"
	- 23:00 - 06:00 - "Good night, World!"	
	
The project built in Maven and contains Junit tests. Also the app creates the readable log file.

The app displays messages using MessageResource.properties file and depends on user's system locale.

This application is checked by Travis-CI.

[![Build Status](https://travis-ci.org/neophyteinpast/my-app.svg?branch=master)](https://travis-ci.org/neophyteinpast/my-app)
