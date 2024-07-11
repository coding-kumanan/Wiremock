FROM wiremock/wiremock:latest
COPY . /home/wiremock


ENTRYPOINT ["/docker-entrypoint.sh", "--global-response-templating", "--disable-gzip", "--verbose"]


#create image from this by running docker build
#run the docker container it will be standalone container further project changes wont be updated