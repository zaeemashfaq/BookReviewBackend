



FROM openjdk:18-alpine

ENV AWS_DB_URL=jdbc:mysql://book-review-db.clswey8gw3c4.ap-south-1.rds.amazonaws.com:3306/book_review_database
ENV AWS_DB_USERNAME=awsAppUser
ENV AWS_DB_PASSWORD=awsAppUser

WORKDIR /app

COPY BookReviewApp-0.0.1-SNAPSHOT.jar /app/backend.jar

EXPOSE 5000

CMD ["java", "-jar", "backend.jar"]
