📝 Simple Notes Application
A simple notes web application built using Java Spring Boot for the backend and Angular 2 for the frontend. This project is developed as part of the Hiring Challenge - Product Developer from Astrapay.

🚀 Features
View a list of notes

Add new notes

Delete notes

Basic validation on both frontend and backend

RESTful API implementation

Temporary in-memory storage (no database)

⚙️ Technology Stack
Back-End: Java Spring Boot

Front-End: Angular 2

Optional: CSS libraries like Bootstrap or Angular Material

📁 Project Structure
Backend (Spring Boot)
RESTful APIs following best practices

Data stored in-memory

Validation and unit testing

Object-Oriented principles using SOLID

Frontend (Angular 2)
Angular services used to communicate with backend APIs

Simple and responsive UI

Form validation for note creation

🛠 How to Run the Project
Backend

# Navigate to the backend folder
cd astrapay-spring-boot-external

# Run the Spring Boot application
./mvnw spring-boot:run

Frontend

# Navigate to the frontend folder
cd astrapay-angular

# Install dependencies
npm install

# Run the Angular app
ng serve
Visit http://localhost:4200 in your browser to access the application.

✅ Validation & Testing
Backend ensures that note content is not empty

Frontend disables submission of empty notes

Basic unit tests implemented for core APIs

📷 Screenshots (included in repo)
✅ Passed validation case

📬 Postman screenshot showing each API call (URL, request, response)

🧾 Empty notes list UI

✏️ Notes list with 6 items

