FROM python:3.12-slim

RUN apt-get update && \
    apt-get install -y openssh-client && \
    rm -rf /var/lib/apt/lists/*

RUN pip install --no-cache-dir ansible-core

WORKDIR /ansible

CMD ["ansible", "--version"]