# Code 401: Codefellowship
## Lab 17: CodeFellowship Profiles with Login

## Version
2.0.0 

## Problem Domain
Adding login and allow users to create posts.

## Deployment
TBD

## Instructions to run the app on your computer
- ________ in terminal
- open PSQL, run command: CREATE DATABASE codefellowship;
- open web browser and go to localhost:8080 to view the homepage

### Contribute
No contribution guidelines at this point. 

### Project Scope
#### MVP
- Allow users to log in to CodeFellowship and create posts.
- Using the above cheat sheet, add the ability for users to log in to your app.
- Upon logging in, users should be taken to a /myprofile route that displays their information.
- Ensure that your homepage, login, and registration routes are accessible to non-logged in users. All other routes should be limited to logged-in users.
- Ensure that user registration also logs users into your app automatically.
- Add a Post entity to your app.
- A Post has a body and a createdAt timestamp.
- A logged-in user should be able to create a Post, and a post should belong to the user that created it.
- hint: this is a relationship between two pieces of data
- A user’s posts should be visible on their profile page.
- When a user is logged in, the app should display the user’s username on every page (probably in the heading).

#### Stretch
- A logged-in user should be able to edit their profile. 
- An “admin” user should be able to edit anyone’s profile.
- Double stretch: allow them to change their passwords if they enter their current password.

## Code style
Code style is strict Java, HTML, CSS, Spring

## Tests
Tests will need to be expanded in the future. 

## Credits
* Java 401 Instructional Team

## License
MIT © Code Fellows
![CF](https://i.imgur.com/7v5ASc8.png)
