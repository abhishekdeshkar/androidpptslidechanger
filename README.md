# Power point slide changer

This simple program allows you to change your Power point slide using your adnroid device's Volume up and down keys.

## Application overview.

It contains VB.NET Code, Android App code & PHP code.

## Requirements.

* Working Internet connection on Phone as well as on Laptop. You can use device's internet in the laptop using HotSpot.
* Windows OS.
* A PHP/MYSQL web server/ PHP MySQL Hosting.

## Working.

When user hits the volume up button, android app sends "0" signal into the database. Desktop app(.exe) which is created in VB.NET will check for changes in the database table. If it finds 0 in the database then it will send "PREVIOUS" side command to power point. If it finds "1" then it will send "NEXT" slide command to Powerpoint.

## How to use ?
This application is not yet ready to use in the production environment because I have provided static HTTP URLs to read CODE. Moreover I haven't uploaded the database schema yet. If you are intersted then mail me at: deshkarabhishek@gmail.com
