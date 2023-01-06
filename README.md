## MultiThreaded WebServer Program

### Server Program

### Structure
This project structured using intellij platform and maven as build system.

### About Project
-> This project is used for communicating multiple clients simultaneously with single server.

-> In this project, two class file are used. One for server main application program,another created using thread to communicate multiple clients.

-> In serverThread program, the class file extends thread in which run() method is used to get the input from multiple clients.

-> In serverThread classFile, to get the file to display in the browser are get through fileInputStream.

-> From which, dataInputStream get the data from clientSocket and dataOutputStream is used to output the given file to client.

-> The output are given in HTTP form to client, response will be given in server program also in HTTP form.

-> The local port are given in server program to which client are requested in the same port to display.

-> When server is running, multiple clients can use the server simultaneously.

-> The output of the given program will be :

Server Started ....
>> Client No:1 started!
java.io.FileInputStream@1c0a5652
>> Client No:2 started!
java.io.FileInputStream@3d5e2089
java.net.SocketException: Connection reset
Client -2 exit!!
java.net.SocketException: Connection reset
Client -1 exit!! 

### Reference Link
[LINK](http://net-informations.com/java/net/multithreaded.htm)

### To Run The Program
for maven, to build the project use 
```
mvn clean install
```
to run the program, in main application by clicking the run button icon where the java class file is created.

```bash
Public class Server{
```
