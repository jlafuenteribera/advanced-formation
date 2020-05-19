FROM python:3.6

COPY . .

RUN pip install -r requirements.txt

EXPOSE 8080

ENTRYPOINT ["python", "controller.py"]