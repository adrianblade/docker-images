# Building an image

There are two steps for building an image. With the first one the image is created from a Dockerfile (file that contains instructions on how to build a docker image [https://docs.docker.com/engine/reference/builder/](https://docs.docker.com/engine/reference/builder/)).

```
#> docker build -t dockerHubURL/java:7 .
```

The second step uploads the image to the [private docker registry](https://docs.docker.com/registry/) (server that contains docker images).

```
#> docker push dockerHubURL/java:7
```

# Downloading an image

It is only necesary to build the image when there are changes on it. Normally you should only download the built image.

```
#> docker pull dockerHubURL.com/java:7
```
