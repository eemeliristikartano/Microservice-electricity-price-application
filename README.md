# Microservice-electricity-price-application

This repository contains multiple projects related to a larger application. Each project is developed using Spring Boot and React. The projects include:

1. **Config Server (configserver-git)**
   - Description: A Spring Cloud Config Server for managing configuration properties.
   - Java Version: 17
   - Spring Cloud Version: 2022.0.4
   - Dependencies:
     - Spring Cloud Config Server
     - Spring Boot Starter Test

2. **Price Today and Tomorrow Service (price-today-and-tomorrow-service)**
   - Description: A Spring Boot service to retrieve price information for today and tomorrow.
   - Java Version: 17
   - Spring Cloud Version: 2022.0.4
   - Dependencies:
     - Spring Boot Starter Web
     - Spring Cloud Starter Config
     - Spring Boot Starter Test

3. **Price Search Service (price-search-service)**
   - Description: A Spring Boot service for searching price information.
   - Java Version: 17
   - Spring Cloud Version: 2022.0.4
   - Dependencies:
     - Spring Boot Starter Web
     - Spring Cloud Starter Config
     - Spring Boot Starter Test

4. **Electricity Price Web App (electricity-price-webapp)**
   - Description: A React web application for displaying electricity price data.
   - Version: 0.1.0
   - Dependencies:
     - Redux Toolkit
     - Testing Library
     - React
     - React Redux
     - React Scripts
     - React Tabs
     - Recharts
     - TypeScript
     - Web Vitals

## About the Project

This project serves as an experimental ground for trying out various technologies, approaches, and architectural patterns. It's important to note that not everything implemented in these projects follows best practices or design patterns. Instead, the primary goal was to gain practical experience in specific areas, such as Redux state management and microservices architecture.

The projects were developed with the aim of learning and exploring new concepts. As a result, you may encounter code or configurations that are not optimal for production environments. It's recommended to treat these projects as learning resources and starting points for your own experimentation and learning journey.

## Author

This README file was initially created by ChatGPT and subsequently edited by a human for clarity and relevance.
