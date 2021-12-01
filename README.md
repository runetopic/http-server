# RuneTopic HTTP Server
[![Discord](https://img.shields.io/discord/212385463418355713?color=%237289DA&logo=Discord&logoColor=%237289DA)](https://discord.gg/3scgBkrfMG)
[![License](https://img.shields.io/github/license/runetopic/http-server)](#)

A server which delivers client configuration settings to an end-user over http.

# Setup Guide
You can host a http server with Docker or with your local machine.

## Hosting With Docker

Please follow [this](https://docs.docker.com/compose/install/) guide to setup Docker Compose.

Once Docker Compose is setup on your machine, clone the repository and run the following commands in terminal.
<h6>Note: Make sure to build using Gradle before attempting to host.</h6>

```
docker-compose build
```

```
docker-compose up
```

## Hosting With Local Machine

Launch the application with the Gradle "run" task.
