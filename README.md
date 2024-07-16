This is a Kotlin Multiplatform project targeting Android, iOS, Web, Desktop, Server.

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.

* `/iosApp` contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform, 
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.

* `/server` is for the Ktor server application.

* `/shared` is for the code that will be shared between all targets in the project.
  The most important subfolder is `commonMain`. If preferred, you can add code to the platform-specific folders here too.


Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html),
[Compose Multiplatform](https://github.com/JetBrains/compose-multiplatform/#compose-multiplatform),
[Kotlin/Wasm](https://kotl.in/wasm/)…

**Note:** Compose/Web is Experimental and may be changed at any time. Use it only for evaluation purposes.
We would appreciate your feedback on Compose/Web and Kotlin/Wasm in the public Slack channel [#compose-web](https://slack-chats.kotlinlang.org/c/compose-web).
If you face any issues, please report them on [GitHub](https://github.com/JetBrains/compose-multiplatform/issues).

You can open the web application by running the `:composeApp:wasmJsBrowserDevelopmentRun` Gradle task.

# Design

[Check the design on Figma](https://www.figma.com/design/wSyg60Tkg5DQzyPPDNHTV7/dailoz-app-vektora-studio?node-id=0-1&t=lF2cXQVCj9bOOfmy-0)


# Check Daily Activity App (Android, iOS, and Desktop)

## Features

- **UI**: Common Jetpack Compose
- **Navigation**: Compose Navigation
- **Dependency Injection**: Koin
- **Database**: Room Database
- **Date Handling**: Platform-specific library
- **Shared ViewModel**: SharedViewModel across all platforms
- **Background Work**: Coroutines
- ** Work in Progress

---

## Flow Recording
|Check Daily Update|
|:---:|
|<img width="350" alt="flow" src="https://github.com/user-attachments/assets/42fbf05e-172b-496c-930c-d25054a0da46">|

# Android Screenshots

| Landing | Sign In | Sign Up | Error on Sign In|
|:---:|:---:|:---:|:---:|
|<img width="350" alt="android_landing_page" src="https://github.com/user-attachments/assets/9596102e-d2bc-49db-8404-ab61eeb79f61">|<img width="350" alt="signIN" src="https://github.com/user-attachments/assets/51106a0d-93f6-405e-8a37-fb3b15dc39ad">|<img width="350" alt="signUP" src="https://github.com/user-attachments/assets/39275ab5-24fc-4386-9cc8-4ce9257b0855">|<img width="350" alt="error" src="https://github.com/user-attachments/assets/287aff26-ac4e-4b9a-9e69-623144c8f789">|

| Loading | Home | Add Task |
|:---:|:---:|:---:|
|<img width="350" alt="loading" src="https://github.com/user-attachments/assets/489209aa-2bdf-49b4-963d-1cc950ff469b">|<img width="350" alt="home" src="https://github.com/user-attachments/assets/7cbfb5c1-e05e-4af8-8248-1f47caa295ac">|<img width="350" alt="add_task" src="https://github.com/user-attachments/assets/9d50c48d-062c-4053-991d-eb98b7f7d8e6">|


# iOS

| Landing | Sign In | Sign Up | Error on Sign In|
|:---:|:---:|:---:|:---:|
|<img width="350" alt="ios_landing_page" src="https://github.com/user-attachments/assets/557b92bc-77d0-4b44-8cb6-ae3fa13b2178">|<img width="350" alt="signIN" src="https://github.com/user-attachments/assets/dbbda03f-de9e-4197-84b0-3f7b8a94595e">|<img width="350" alt="signUP" src="https://github.com/user-attachments/assets/6d697cc6-7c2f-48f2-89b1-73a19c4533f8">|<img width="350" alt="error" src="https://github.com/user-attachments/assets/f20c46ce-001f-4bec-926a-7f523a69dec1">|

| Loading | Home | Add Task |
|:---:|:---:|:---:|
|<img width="350" alt="loading" src="https://github.com/user-attachments/assets/026e224d-96cc-4f77-87b7-c95fa13108a9">|<img width="350" alt="home" src="https://github.com/user-attachments/assets/0caaaa12-9135-43be-9d74-1b13256374c4">|<img width="350" alt="add_task" src="https://github.com/user-attachments/assets/83a5d51d-2b1b-4ec5-9ad8-9c7c26293ee9">|


# Desktop

| Landing | Sign In | Sign Up | Error on Sign In|
|:---:|:---:|:---:|:---:|
|<img width="350" alt="ios_landing_page" src="https://github.com/user-attachments/assets/b66d2c7c-5607-4014-9e95-693704ca42ff">|<img width="350" alt="signIN" src="https://github.com/user-attachments/assets/f0689e79-24e7-465e-b7df-2d7958a1a0d0">|<img width="350" alt="signUP" src="https://github.com/user-attachments/assets/3360d129-ab24-403f-a8c7-33a5070e0eb6">|<img width="350" alt="error" src="https://github.com/user-attachments/assets/476b5baa-e8c8-4132-9f49-fa3a417664aa">|

| Loading | Home | Add Task |
|:---:|:---:|:---:|
|<img width="350" alt="loading" src="https://github.com/user-attachments/assets/1757ce80-1aeb-43c9-8ee3-845b441c6bd4">|<img width="350" alt="home" src="https://github.com/user-attachments/assets/8db5e6c1-80a0-47e5-909d-1efc44cf35df">|<img width="350" alt="add_task" src="https://github.com/user-attachments/assets/7eabce5a-ae9e-4250-92e3-4bde063a80f3">|

---

# Ktor Application

This project is a Ktor-based web application that provides user authentication and protected routes. The application allows users to sign up, sign in, and access a protected endpoint.

## Table of Contents

- [Getting Started](#getting-started)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Sign Up](#1-sign-up)
- [Sign In](#2-sign-in)
- [Protected Route](#3-protected-route)
- [Configuration](#configuration)
- [Built With](#built-with)
- [License](#license)

## Getting Started

These instructions will help you set up and run the application on your local machine for development and testing purposes.

### Prerequisites

- [JDK 8+](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Gradle](https://gradle.org/install/)
- [MongoDB Atlas](https://www.mongodb.com/cloud/atlas) account (for storing user data)

### Installing

1. Clone the repository:

  ```bash
  git clone https://github.com/your-username/ktor-application.git
  cd ktor-application
  ```

2. Configure your environment variables:

  Create a `.env` file in the root directory and add the following environment variables:

  ```plaintext
  JWT_ISSUER=https://your-domain.com/
  JWT_AUDIENCE=your-audience
  JWT_REALM=your-realm
  JWT_SECRET=your-secret
  MONGO_PW=your-mongodb-password
  ```

3. Build the project:

  ```bash
  ./gradlew build
  ```

## Running the Application

To run the application, use the following command:

```bash
./gradlew run
```

The server will start on `http://localhost:5500`.

## API Endpoints

### 1. Sign Up

**URL**: `http://localhost:5500/signup`
**Method**: `POST`
**Body**:

```json
{
"name": "shiv",
"email": "shiv@test.com",
"password": "test1234"
}
```

**Response**:

- `200 OK`: User successfully registered and returns a JWT token.
- `400 Bad Request`: Invalid request data.

### 2. Sign In

**URL**: `http://localhost:5500/signin`
**Method**: `POST`
**Body**:

```json
{
"name": "",
"email": "shiv@test.com",
"password": "test1234"
}
```

**Response**:

- `200 OK`: Returns a JWT token for authentication.
- `401 Unauthorized`: Invalid credentials.

### 3. Protected Route

**URL**: `http://localhost:5500/secret`
**Method**: `GET`
**Headers**:

```plaintext
Authorization: Bearer <JWT Token>
```

**Response**:

- `200 OK`: Access to the protected resource.
- `401 Unauthorized`: Invalid or missing JWT token.

## Configuration

The application is configured using the `application.conf` file located in the `resources` directory. Ensure that the following properties are correctly set:

```hocon
ktor {
  deployment {
    port = 5500
  }
  application {
    modules = [ online.nsandroid.ApplicationKt.module ]
  }
  security {
    jwt {
        issuer = ${?JWT_ISSUER}
        audience = ${?JWT_AUDIENCE}
        realm = ${?JWT_REALM}
        secret = ${?JWT_SECRET}
    }
  }
}
```

### TODO Items from the Code

The `Application.kt` file includes TODO items to enhance the functionality and security of the application. Ensure to address the following:

- **TODO**: Add proper error handling for all routes.
- **TODO**: Implement user password hashing before storing in the database.
- **TODO**: Add logging to monitor application behavior and errors.
- **TODO**: Secure the `/secret` route to ensure only authenticated users can access it.
- **TODO**: Validate user input to prevent SQL injection and other attacks.
- **TODO**: Configure CORS to allow requests from trusted origins.
- **TODO**: Pass database name `val dbName = ""`
- **TODO**: Configure before testing it: `connectionString = "mongodb+srv://<username>:<password>@<cluster-url>/<dbname>?retryWrites=true&w=majority"`
- **TODO**: Before running pass JWT secret here: `const val JWT_SECRET = ""`
- **TODO**: Add MongoDB password here: `const val MONGO_PW = ""`

## Built With

- [Ktor](https://ktor.io/) - Framework for building asynchronous servers and clients in connected systems.
- [KMongo](https://litote.org/kmongo/) - Kotlin toolkit for MongoDB.
- [Gradle](https://gradle.org/) - Build tool.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---
