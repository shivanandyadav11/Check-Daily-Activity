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

# My Application

Welcome to the landing page of My Application.

## Screenshots

| Android | iOS | Desktop |
|:---:|:---:|:---:|
|<img width="398" alt="android_landing_page" src="https://github.com/shivanandyadav11/Check-Daily-Activity/assets/26367466/d10d82f7-9c03-4a30-95ff-20bd2cbb7943">|<img width="419" alt="iOS_landing_page" src="https://github.com/shivanandyadav11/Check-Daily-Activity/assets/26367466/d40f1471-22cf-4186-a9ad-7799526390e0">|<img width="627" alt="desktop_landing_page" src="https://github.com/shivanandyadav11/Check-Daily-Activity/assets/26367466/65a4b707-b4aa-4696-8343-639170f3b2d0">|


| Web |
|:---:|
|<img width="1728" alt="web_landing_page" src="https://github.com/shivanandyadav11/Check-Daily-Activity/assets/26367466/5329365d-1beb-43aa-8846-422b95dbf3bf">|


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
