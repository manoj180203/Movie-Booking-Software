# Movie-Booking-Software
Hii I am Manoj Kumar, B.E Computer Science Engineering 

I have designed a simple software called as Movie Booking System that has many functionalities to book a ticket online for a movie/show.
I have also added a security to protect user data using backend.
The backend is Java and Database is MySQL connected using JDBC.

#Donot forget to add Connector JAR files in library.

There is a photo named Tables.jpeg, It has all the tables requried to make this movie booking software work create all the tables with the same table name and database name as shown in the pic or else you will face CLASSNOTFOUND Exception.  

Only Welcome.java file is a executable file only this file has a main method in it.
The other .java files are just methods required to book a movie.
As soon as we run the welcome.java file it asks if you are admin or a user.

1. Admin Login
   username= 18022003
   password= 1234
   The Admin Section can Perform 6 functions they are:-
   1. Add Movies
   2. See All Movies
   3. Put a movie show time
   4. See all Show Time
   5. Add Theaters
   6. To See all Theaters.

2. User Login
   The user Login is used to book a movie using the showtime,
   For the user to book a movie the admin has to create a showtime using admin section, During booking tickets the user can see all the showtimes created by admin and can book a ticket accordingly.
   For a Ticket sucessfully booked there will be a Ticket ID generated using this id the user can view his ticket or even cancel it.
   The user can perform 3 functions they are:-
   1. To book a Ticket
   2. See Ticket Booking
   3. To cancel a booking.

For security purpose the user data is only stored for a short period of time, As soon as the user exit this application all his data i.e phone number and user id will be deleted from database.
