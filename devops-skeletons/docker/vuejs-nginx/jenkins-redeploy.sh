COMPANY=forcelate
APP=vuejs-nginx
TAG=latest

docker stop ${APP}

docker pull ${COMPANY}/${APP}:${TAG}

docker run -d -it -p 8787:80 --rm --name ${APP} ${COMPANY}/${APP}:${TAG}
