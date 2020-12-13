var start = 0;
var showCount = 5;
var end = 5;


function isTokenExist() {
    return localStorage.getItem('token') != null;
}

function logOut() {
    localStorage.removeItem('token');
    localStorage.removeItem('login');
    window.location.replace(window.location.origin);
}

async function isAuth() {
    if (isTokenExist()) {
        let token = localStorage.getItem('token');
        console.log(token);
        await authorizedUser(token);
        return true;
    }
    return false;
}


function validateLoginPass(name, serName, login, password, repeatPassword, email) {
    if(password !== repeatPassword)
        return  "repeat the password correctly";
    if (!(login.length >= 4 && login.length <= 20)) {
        return "not correct login";
    }
    if (!(name.length >= 4 && name.length <= 20)) {
        return "not correct name";
    }
    if (!(serName.length >= 4 && serName.length <= 20)) {
        return "not correct serName";
    }
    if (!(password.length >= 4 && password.length <= 20)) {
        return "not correct password";
    }
    if (!email.length >= 10) {
        return "not correct email";
    }

    return true;
}

async function reg() {
    let username = document.getElementById("name").value;
    let serName = document.getElementById("serName").value;
    let login = document.getElementById("login").value;
    let password = document.getElementById("password").value;
    let repeatPassword = document.getElementById("repeatPassword").value;
    let mail = document.getElementById("email").value;
    let mes = document.getElementById("message");
    let result = validateLoginPass(username, serName, login, password, repeatPassword, mail);
    if (result === true) {
        let data = {username: username, serName: serName, login: login, password: password,mail:mail};
        let res = await regUser(data);
        if (res.ok) {
            window.location.replace(window.location.origin);
        } else {
            mes.innerHTML = "this user already exist";
        }

    } else {
        mes.innerHTML = result;
    }
}

async function login() {
    let login = document.getElementById("login").value;
    let password = document.getElementById("password").value;
    let mes = document.getElementById("message");
    let data = {login: login, password: password};
    let result = await logUser(data);
    if (result.ok) {
        let body = await result.text();
        let info = JSON.parse(body);
        localStorage.setItem('token', info['token']);
        localStorage.setItem('login', login);
        window.location.replace(window.location.origin);
    } else {
        mes.innerHTML = await result.text();
    }
}

function genLogReg() {

    let divLogReg = document.querySelector('.logReg');
    let aDivLog = div();
    let aDivReg = div();
    let aLogin = a('/login', 'Login');
    let aReg = a('/registration', 'Registration');
    aDivLog.appendChild(aLogin);
    aDivReg.appendChild(aReg);
    divLogReg.appendChild(aDivLog);
    divLogReg.appendChild(aDivReg);

}
function genLogout() {
    let divLogOut = document.querySelector('.logOut');
    let logoutBtn = button(logOut, 'Logout');
    divLogOut.appendChild(logoutBtn)
}

async function genNext() {
    let div = document.querySelector('.nextPrev');
    let logoutBtn = button(await next, '-->');
    div.appendChild(logoutBtn)
}

function genPrev() {
    let div = document.querySelector('.nextPrev');
    let logoutBtn = button(prev, '<--');
    div.appendChild(logoutBtn)
}

async function next() {
    let result = document.querySelector('.results');
    await fetch("/scooter/all", {
        method: "POST",
    }).then(function (res) {
        return res.json();
    }).then(function (data) {
        if (end < data.length) {
            start += showCount;
            end += showCount;
        }
        genListOfProjectsForUser();
    });
}

async function prev() {
    if (start - showCount >= 0) {
        start -= showCount;
        end -= showCount;
    }
    await genListOfProjectsForUser();
}