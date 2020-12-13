async function getAllScooters() {
    return await fetch("/scooter/all", {
        method: "POST",
    }).then(function (res) {
            return res.json();
    }).then(function (data) {
        return data;
    });
}

async function logUser(data) {
    return await fetch("/login", {
        method: "POST",
        body: JSON.stringify(data),
        headers: {
            'Content-Type': 'application/json'
        }
    });
}

async function regUser(data) {
    return  await fetch("/register", {
        method: "POST",
        headers: {
            'content-type': 'application/json'
        },
        body: JSON.stringify(data)
    });
}

async function getUserByLogin() {
    let token = localStorage.getItem('token');
    return await fetch(`/getUser/${localStorage.getItem('login')}`, {
        method: "GET",
        headers: {
            'Authorization': `Bearer ${token}`
        }
    }).then(function (res) {
        return res.json();
    }).then(function (data) {
        return data;
    });
}

async function authorizedUser(token) {
    return await fetch("/authorized", {
        method: "POST",
        headers: {
            'Authorization': `Bearer ${token}`
        }
    });
}