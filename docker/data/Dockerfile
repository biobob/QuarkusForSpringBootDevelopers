FROM python:3.8-slim

ARG pwd
VOLUME $pwd /usr/src/app
WORKDIR /usr/src/app

RUN pip install --no-cache-dir -r requirements.txt

CMD [ "python", "./generate_ddl.py" ]
