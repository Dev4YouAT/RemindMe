import express = require('express');
import * as path from 'path';
import fs from 'fs';
import { Request, Response } from 'express';
import { UserService } from './user/user_service';
import { User } from './user/user';
import { Session } from './session';
import { BaseResponse } from './model/base-reponse';
import { ReminderService } from './user/reminder-service';

const userService :UserService = new UserService();
const reminderService :ReminderService = new ReminderService();
const app: express.Application = express();

const PORT = 80;
const USERS_CONFIG_PATH = path.join(__dirname, 'configs', 'user.json');
const REMINDERS_CONFIG_PATH = path.join(__dirname, 'configs', 'reminders.json');

Session.init(JSON.parse(fs.readFileSync(USERS_CONFIG_PATH).toString()),
             JSON.parse(fs.readFileSync(REMINDERS_CONFIG_PATH).toString()));

app.use(express.json());
app.use(express.urlencoded({
    extended: true
}));

app.get('/reminders', (req: Request, res :Response) => {
    let id :string = req.query.id;
    
    res.send(JSON.stringify(reminderService.get(id)));
});

app.post('/login', (req :Request, res :Response) => {
    let username :string = req.body.username;
    let password :string = req.body.password;
    
    let user :User = userService.checkLogin(new User('', '', username, password, true));

    res.send(JSON.stringify(user));
});

app.post('/register', (req :Request, res :Response) => {
    let username :string = req.body.username;
    let password :string = req.body.password;

    let user :User = userService.create(username, password, true);

    res.send(JSON.stringify(user == null ? new BaseResponse('') : new BaseResponse(user.id)));
});

app.listen(PORT, () => {
  console.log('Server running on port ' + PORT);
});