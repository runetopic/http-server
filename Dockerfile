FROM openjdk:17-alpine
ENV directory /app/
WORKDIR ${directory}
ADD build/distributions/http-server-shadow-*.zip .
RUN unzip -q -o *.zip
RUN rm -fv *.zip
RUN mv http-server-shadow*/* .
RUN rm -rf http-server-shadow*/
WORKDIR bin
EXPOSE 8080:8080
ENTRYPOINT ./http-server