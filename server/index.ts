import express = require('express');
import { Request, Response } from 'express';
import { UserService } from './user/user_service';
import { User } from './user/User';
import { Passwords } from './password_hash/password';

const userService :UserService = new UserService();
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
    
    let user :User = userService.checkLogin(new User('', '', username, password));
    res.send(JSON.stringify(user));
});

app.listen(PORT, () => {
  console.log('Server running on port ' + PORT);
});