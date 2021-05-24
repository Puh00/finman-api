<h1 align="center">
  <br>
  <a href="https://github.com/puh00/finman-api"><img src="https://raw.githubusercontent.com/gabrielbrattgard/finman-frontend/main/public/finman-logo.png" alt="Markdownify" width="150"></a>
  <br>
  finman-api
  <br>
</h1>

<h4 align="center"> This is the backend of the DAT257 project by team <B><i>Sony Walkman WM-FX199.</i></B></h4>
<h4 align="center">
To see the frontend, refer to the following link: 
    <a href="https://github.com/gabrielbrattgard/finman-frontend" target="_blank">finman-frontend</a>.
</h4>

<p align="center">
  <a href="https://heroku.com/deploy?template=https://github.com/Puh00/DAT257-Sony-Walkman">
    <img src="https://www.herokucdn.com/deploy/button.png">
  </a>
  <a href="https://github.com/Puh00/finman-api/actions"><img src="https://github.com/Puh00/finman-api/actions/workflows/maven.yml/badge.svg"></a>
  <a href="https://www.codefactor.io/repository/github/puh00/finman-api">
    <img src="https://www.codefactor.io/repository/github/puh00/finman-api/badge">
  </a>
</p>

<p align="center">
  <a href="#folder-structure">Folder Structure</a> •
  <a href="#getting-started">Getting Started</a> •
  <a href="#usage">Usage</a>
</p>

## Folder Structure

```
.
├── documents                                  # Documentation files
│   ├── Contract                               # Social Contract
│   ├── Database                               # ER Diagram
│   ├── Individual Reflections
│   ├── Project Scope
│   ├── Team Reflection
│   └── Template                               # Co-author commit template
└── backend                                    # Backend related files
    └── src
        ├── main
        │   ├── java/net/finman
        │   │   ├── controller                 # Exposed endpoints to our api
        │   │   ├── dao                        # Queries to the database
        │   │   ├── exception                  # Exceptions
        │   │   ├── mapper                     # Converts SQL records to POJOs
        │   │   ├── model                      # POJOs
        │   │   └── service                    # Business logic
        │   └── resources                      # Config, schema, and inserts
        └── test/java/net/finman               # Test files
```

## Getting Started

This is an example of how you may give instructions on setting up your project locally. To get a local copy up and running follow these simple example steps.

### Prerequisites

- Java 1.8 or later
- Maven 3.2+
- PostgreSQL 9.5 or later

### Installation

1. Clone the repo

```bash
# Clone this repository
$ git clone https://github.com/Puh00/finman-api

# Go into the repository
$ cd finman-api

# Go into the backend sub-directory
$ cd backend
```

2. Add `postgresql` credentials to your `application.properties`:

```diff
+ spring.datasource.url=URL_TO_YOUR_DATABASE
+ spring.datasource.username=YOUR_USERNAME
+ spring.datasource.password=YOUR_PASSWORD
spring.sql.init.enabled=false
spring.sql.init.schema-locations=classpath:/schema.sql
spring.sql.init.continue-on-error=true
```

3. Run the application from your favourite editor or from the command line:

- Requires [Maven](https://mkyong.com/maven/how-to-install-maven-in-windows/)

```bash
# Run Spring Boot app using Maven, by default, the app runs on port 8080
$ mvn spring-boot:run
```

## Usage

For instruction on how to interact with the api, please refer to the [API documentation](https://github.com/Puh00/finman-api/wiki/API-Documentation).
