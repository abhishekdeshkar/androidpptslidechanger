# Power point slide changer

This simple program allows you to change your Power point slide using your adnroid device's Volume up and down keys.

## Application overview.

It contains VB.NET Code, Android App code & PHP code.

## Requirements.

* Working Internet connection on Phone as well as on Laptop. You can use device's internet in the laptop using HotSpot.
* Windows OS.

## Working.

When user hits the volume up button, android app sends "0" signal into the database. Desktop app(.exe) which is created in VB.NET will check for changes in the database table. If it finds 0 in the database then it will send "PREVIOUS" side command to power point. If it finds "1" then it will send "NEXT" slide command to Powerpoint.
