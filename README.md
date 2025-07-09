Cook AI 🍳✨
by h7 (synapse AI)
Cook AI is an intelligent web application designed to transform your kitchen experience. By leveraging the power of the Spoonacular API, this application takes the ingredients you have on hand and generates creative, delicious, and easy-to-follow recipes. It's the perfect tool to combat food waste, inspire culinary creativity, and answer the age-old question: "What should I cook today?"

This project is built with a professional, production-ready mindset, focusing on a robust backend and a dynamic, modern frontend.

🚀 Features
This application is packed with features designed for a seamless and engaging user experience:

🔐 Secure Google OAuth2 Login: Easy and secure authentication using your Google account. User sessions are managed securely on the backend, with user data saved to a persistent MySQL database.

🧠 AI-Powered Recipe Generation: Enter the ingredients you have, and our AI, powered by the Spoonacular API, will find the best possible recipe for you.

✨ Surprise Me! Don't know what to cook? Let our AI pick a random combination of popular ingredients and generate a surprise recipe for you!

🎨 Advanced Filtering: Refine your recipe search with advanced filters for:

Cuisine: (e.g., Italian, Chinese, Sri Lankan)

Dietary Needs: (e.g., Vegetarian, Vegan, Gluten-Free)

Cook Time: (e.g., Under 30 minutes)

📚 Personal Recipe Library:

Save Recipes: Liked a recipe? Save it to your personal library with a single click.

View & Manage: Browse your saved recipes in a clean, organized library.

Delete Recipes: Easily remove recipes you no longer need with a confirmation step.

💡 Ingredient Auto-Suggestions: As you type your ingredients, the app provides helpful suggestions to speed up the process.

💎 Professional & Modern UI: A stunning, fully responsive user interface with a dark theme, glassmorphism effects, and smooth animations, built entirely with vanilla HTML, CSS, and JavaScript.

🛠️ Built With
This project was built using a modern, robust technology stack:

Backend:

Java 17

Spring Boot 3 - For building the robust and scalable backend server.

Spring Security - For handling authentication and security.

Spring Data JPA - For database interaction.

Maven - For dependency management.

Database:

MySQL - As the persistent relational database.

Frontend:

HTML5

CSS3 (with Custom Properties for theming)

Vanilla JavaScript (ES6+)

APIs:

Spoonacular API - For intelligent recipe and image searching.

⚙️ Getting Started
To get a local copy up and running, follow these simple steps.

Prerequisites
Make sure you have the following installed on your machine:

Java Development Kit (JDK) 17 or later.

Apache Maven.

A running MySQL server instance.

Installation & Configuration
Open the project in IntelliJ IDEA

Open IntelliJ IDEA and select "Open".

Navigate to the cloned cook-ai directory and open it.

Allow Maven to download all the required dependencies.

Create your MySQL Database

Log in to your MySQL server.

Create a new database named cook_ai_db.

CREATE DATABASE cook_ai_db;

Create and Configure application.properties

In the IntelliJ Project Explorer, navigate to src/main/resources.

Right-click on the resources folder and select New -> File.

Name the new file application.properties.

This file is ignored by Git and will not be uploaded to GitHub.

Copy the following content into your new application.properties file:

# Server Port
server.port=8080

# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/cook_ai_db
spring.datasource.username=root
spring.datasource.password=YOUR_DB_PASSWORD

# Google OAuth2 Client Properties
spring.security.oauth2.client.registration.google.client-id=YOUR_GOOGLE_CLIENT_ID
spring.security.oauth2.client.registration.google.client-secret=YOUR_GOOGLE_CLIENT_SECRET

# Gemini API Key
gemini.api.key=${GEMINI_API_KEY}

Replace the placeholder values (YOUR_...) with your actual keys and database password. You will need to get your own Google Client ID/Secret and Spoonacular API Key.

Run the application

Find the CookAiV2Application.java file in src/main/java/com/h7/synapseai/app.

Click the green play button next to the main method to run the application.

Open the application

Open your browser and go to http://localhost:8080.
