FROM node:9.11.1-alpine
ARG VUEJS_PROFILE
WORKDIR /app
RUN npm install -g http-server
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build:$VUEJS_PROFILE
EXPOSE 8080
CMD [ "http-server", "dist" ]
