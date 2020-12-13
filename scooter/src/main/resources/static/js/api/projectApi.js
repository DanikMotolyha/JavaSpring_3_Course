async function updateScooter() {
    let id = document.getElementById("id_up").value;
    let name = document.getElementById("name_up").value;
    let price = document.getElementById("price_up").value;
    console.log(name, price);
    let token = localStorage.getItem('token');
    return await fetch("/admin/updateScooter", {
        method: "POST",
        body: JSON.stringify({id: id, name:name, price:price}),
        headers: {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${token}`
        }
    });
}

async function SearchScooter() {
    let id = document.getElementById("id_search").value;
    let uniq = document.querySelector('.unic_class_1234');
    let data = await Search(id);
    let genSearch = p('Id: '+ data.id + 'Scooter: ' + data.name + ' Price:' + data.price);

    let genBut = buttonWithParams('delete', 'inlineBl');
    genBut.onclick = async () => {
        await delScooter(data);
    };
    uniq.appendChild(genSearch);
    uniq.appendChild(genBut);
}
async function Search(id){
    let token = localStorage.getItem('token');
    return await fetch(`/admin/SearchScooterById/${id}`, {
        method: "GET",
        headers: {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${token}`
        }
    }).then(function (res) {
        console.log(res);
        return res.json();
    }).then(function (data) {
        return data;
    });
}

async function createScooter() {
    let name = document.getElementById("name_create").value;
    let price = document.getElementById("price_create").value;
    console.log(name, price);
    let token = localStorage.getItem('token');
    return await fetch("/admin/createScooter", {
        method: "POST",
        body: JSON.stringify({name: name, price:price}),
        headers: {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${token}`
        }
    });
}
async function updateProject(data , token) {
    return await fetch("/admin/updateProduct", {
        method: "PUT",
        body: JSON.stringify(data),
        headers: {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${token}`,
        }
    });
}

