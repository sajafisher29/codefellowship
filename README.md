# Code 401: Codefellowship
## Lab 17: CodeFellowship Profiles with Login
## Lab 18: Following Users on CodeFellowship
## Lab 19: Polish CodeFellowship

## Version
3.0.0 

## Problem Domain
Adding SQL/HMTL injection protection, build functionality for users to follow each other, website design, error handling, integration testing. Polish the site!

## Deployment
Heroku

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
- Ensure that users can’t perform SQL injection or HTML injection with their posts.
- Allow users to follow other users. Following a user means that their posts show up in the logged-in user’s feed, where they can see what all of their followed users have posted recently.
- Ensure there is some way (like a users index page) that a user can discover other users on the service.
- On a user profile page that does NOT belong to the currently logged-in user, display a “Follow” button. When a user clicks that follow button, the logged-in user is now following the viewed-profile-page user.
- Note: this will require a self-join on ApplicationUsers.
- A user can visit a url (like /feed) to view all of the posts from the users that they follow.
- Each post should have a link to the user profile of the user who wrote the post.
- A splash page with basic information about the site
- The ability for users to register for new accounts and log in.
- The ability for logged-in users to create posts.
- The ability to see a user’s posts, along with their profile information and a default profile picture, on their profile page.
- A pleasing design throughout the site.
- Thymeleaf templates & fragments used appropriately to keep view code DRY.
- Smooth error handling with appropriate responses to bad requests.
- Integration testing on (at minimum) the splash page, login, and sign up routes.
- Polish the site css.

#### Stretch
- A logged-in user should be able to edit their profile. 
- An “admin” user should be able to edit anyone’s profile.
- Double stretch: allow them to change their passwords if they enter their current password.
- When users create posts, allow them to specify whether or not a post is “public”. Public posts show up in everyone’s feeds.
- Add the ability for users to comment on posts.
- Add a notifications system to CodeFellowship. Display a notification to users when people comment on their posts.
- Using WebSockets, make that notifications system show updates in real time, not just when the page refreshes.
- Using WebSockets, implement a messaging feature on CodeFellowship.

## Code style
Code style is strict Java, HTML, CSS, Spring

## Tests
Tests will need to be expanded in the future. 

## Credits
* Java 401 Instructional Team

## License
MIT © Code Fellows
![CF](https://i.imgur.com/7v5ASc8.png)
