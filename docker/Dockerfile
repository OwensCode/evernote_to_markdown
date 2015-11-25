FROM maven:3.3.1-jdk-7

RUN mkdir /root/.m2
COPY settings.xml /root/.m2/settings.xml

RUN mkdir /var/m2repo

RUN mkdir /evernote_to_markdown
WORKDIR /evernote_to_markdown

CMD ["bash"]
