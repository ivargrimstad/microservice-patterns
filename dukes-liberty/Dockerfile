FROM websphere-liberty:webProfile7
MAINTAINER IBM Java engineering at IBM Cloud
COPY /target/liberty/wlp/usr/servers/defaultServer /config/
# Install required features if not present
RUN installUtility install --acceptLicense defaultServer
