# cit-591-projects-fall-2016-goodreads_analysis
cit-591-projects-fall-2016-goodreads_analysis created by GitHub Classroom


This project was created as a final project in CIT 591 Intro to Software Engineering at the University of Pennsylvannia.

Authors: Carson Stack, David Milewicz, Anthony Georgiades


# Project Goal
The Goal of this project was to create a reccomendation aggregation tool that would allow users to determine the expected emotional response to reading a given book. The tool works as follows: 
1. A user enters a book name to search.
2. The book name is compiled into a call to the Goodreads API and the textual contents of reviews for the book are retrieved.
3. The text of the reviews are sent to the Watson Tone Analyzer API. This API takes in a string of text and returns an analysis of the emotional content of the text. 
4. The results are displayed back to the user with on a simple website UI. We report the number of reviews containing a given analyzed emotion. 

Technologies utilized: IBM Watson API, Goodreads API, Java servlets, Jsoup
