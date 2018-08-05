# build stage
FROM node:9.11.1-alpine as build-stage
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build

# production stage
FROM alpine:latest as production-stage
RUN apk update && \
    apk add --no-cache \
    lighttpd \
    rm -rf /var/cache/apk/*
COPY --from=build-stage /app/dist /var/www/localhost/htdocs
EXPOSE 80
CMD ["/usr/sbin/lighttpd", "-D", "-f", "/etc/lighttpd/lighttpd.conf"]
