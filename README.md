# XMLCourseProject

To install the necessery tools go to the home directory of your ubuntu or debian distributon and run the following commands

```shell
mkdir tools
cd tools
curl -O https://dl.dropboxusercontent.com/s/v6c8st274vn77d1/marklogic_8.0-6.2_amd64.deb
sudo dpkg -i marklogic_8.0-6.2_amd64.deb
curl -O https://d1opms6zj7jotq.cloudfront.net/idea/ideaIU-2016.1.2.tar.gz
tar -xzf ideaIU-2016.1.2.tar.gz
sudo apt-get install openjdk-8-jdk
curl -O http://download.jboss.org/wildfly/10.0.0.Final/wildfly-10.0.0.Final.zip
unzip wildfly-10.0.0.Final.zip
```

To run the marklogic server run the following command

```shell
sudo service MarkLogic start
```

To run intellij idea go to the extracted directory /bin AND run ./idea.sh

To run the server start intellij idea open the github project and configure the JBoos run configuration
