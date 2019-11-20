import express = require('express');
import bodyParser from 'body-parser';
import { Request, Response } from 'express';

const app: express.Application = express();
const PORT = 80;

app.use(express.json());
app.use(express.urlencoded({
    extended: true
})); 

app.get('/', (req :Request, res :Response) => {
  res.send('');
});

app.post('/login', (req :Request, res :Response) => {
    let username :string = req.body.username;
    let password :string = req.body.password;
    console.log("here")
    res.send('true');
});

app.listen(PORT, () => {
  console.log('Server running on port 3000');
});