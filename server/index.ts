import express = require('express');
import { Request, Response } from 'express';

const app: express.Application = express();
const PORT = 80;

app.use(express.json());
app.use(express.urlencoded({
    extended: true
})); 

app.get('/test', (req :Request, res :Response) => {
  res.send('test');
});

app.post('/login', (req :Request, res :Response) => {
    let username :string = req.body.username;
    let password :string = req.body.password;
    
    res.send(JSON.stringify({
      id: 'id',
      username: 'username'
    }));
});

app.listen(PORT, () => {
  console.log('Server running on port ' + PORT);
});