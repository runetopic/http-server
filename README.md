# http-server
[![Discord](https://img.shields.io/discord/212385463418355713?color=%237289DA&logo=Discord&logoColor=%237289DA)](https://discord.gg/3scgBkrfMG)
[![License](https://img.shields.io/github/license/runetopic/http-server)](#)

## Introduction
HTTP Configuration Server. Currently built around the [Jan 6th 2022 #202](https://oldschool.runescape.wiki/w/Update:Nex:_The_Fifth_General) update.

Runescape host a variety of configuration files for the client as well as the latest gamepack. Runescape generates the gamepack with some sort of identifier, but we ignore that as it's really only used for botting purposes from what we understand (Not 100% sure on this identifier as of now)

This can be used to mimic a similar process to serve the latest jav_config.ws and gamepack.jar for your RSPS.
This is used to closely mimic how Jagex handles the jav_config.ws and gamepack.jar files for the client launcher.
# Usage
Running the application via docker is the recommended approach, as you're most likely not going to be working with the http-server very often. So it makes sense to make this into it's own image.

If you would prefer not to use docker, you can still run the Application like you normally would. This project also uses the application plugin, that makes it really easy to run the application via gradle as well.
## Docker setup

If you don't have docker installed and setup -
Please follow [this](https://docs.docker.com/compose/install/) guide to install docker and docker compose.

Once docker and docker compose is installed on your machine you're good to start building the image and container.

#### Note: *Make sure to build using Gradle before attempting to host for the docker image to use the latest changes.*

### Creating the initial image

```shell
docker build -t http-server .
```

### Building the image with the latest changes
```shell
docker-compose build
```

### Starting the image in a new container
```shell
docker-compose up
```
