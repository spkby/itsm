FROM ubuntu

RUN apt update \
&& apt upgrade -y \
&& apt install -y git \
&& apt install -y gradle \
&& git clone https://github.com/vlaship/msgClientSpring \
&& cd msgClient \
&& gradle build \
&& cd build/libs \
&& mv *.jar /client.jar

ENTRYPOINT ["java","-jar","client.jar"]
