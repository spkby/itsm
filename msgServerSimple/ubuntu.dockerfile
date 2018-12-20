FROM ubuntu

RUN apt update \
&& apt upgrade -y \
&& apt install -y git \
&& apt install -y gradle \
&& git clone https://github.com/vlaship/msgServerSimple \
&& cd msgServer \
&& gradle build \
&& cd build/libs \
&& mv *.jar /server.jar

ENTRYPOINT ["java","-jar","server.jar"]