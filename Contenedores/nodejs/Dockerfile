FROM node:10

COPY package*.json ./

RUN npm install

COPY dist/ ./dist/

EXPOSE 8080

CMD [ "node", "dist/index.js" ]