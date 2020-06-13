FROM mysql/mysql-server
COPY DumpofCustomerDatabase.sql /docker-entrypoint-initdb.d/
ENV MYSQL_ROOT_PASSWORD=password
ENV MYSQL_DATABASE=web_customer_tracker
ENV MYSQL_USER=springstudent
ENV MYSQL_PASSWORD=springstudent