async function genListOfProjectsForAdmin() {
    document.getElementsByClassName('someList')[0].style = "overflow-y: scroll";
    let token = localStorage.getItem('token');
    let someList = document.querySelector('.someList');
    someList.innerHTML = '';
    let data = await getAllScooters();
    for (let i = 0; i < data.length; i++) {
        let genDiv = div('Scooter_enemy');
        let genP1 = p('Id: ' + data[i].id + 'Scooter: ' + data[i].name + ' Price:' + data[i].price);
        let genBut = buttonWithParams('delScooter', 'inlineBl');

        genBut.onclick = async () => {
            await delScooter(data[i]);
        };
        genDiv.appendChild(genP1);
        genDiv.appendChild(genBut);
        someList.appendChild(genDiv);
    }
}
async function genProject() {
    let info = document.querySelector(".create");
    let name = input('text', 'name_create', 'Name', '');
    let price = input('text', 'price_create', 'price', '');
    let createButton = button(null,'Create');
    createButton.onclick = async () => {
        await createScooter();
    };
    info.appendChild(name);
    info.appendChild(price);
    info.appendChild(createButton);

    let up = document.querySelector(".update");
    let id_up = input('text', 'id_up', 'id', '');
    let name_up = input('text', 'name_up', 'Name', '');
    let price_up = input('text', 'price_up', 'price', '');
    let createButton2 = button(null,'Update');
    createButton2.onclick = async () => {
        await updateScooter();
    };
    up.appendChild(id_up);
    up.appendChild(name_up);
    up.appendChild(price_up);
    up.appendChild(createButton2);


    let search = document.querySelector(".search");
    let id_search = input('text', 'id_search', 'id', '');
    let createButton4 = button(null,'Search');
    let inputDiv = div('unic_class_1234');
    createButton4.onclick = async () => {
        await SearchScooter();
    };
    search.appendChild(id_search);
    search.appendChild(createButton4);
    search.appendChild(inputDiv);
}

function validateDocument() {
    let nameL = document.getElementById('name').value.length;
    let descriptionL = document.getElementById('description').value.length;

    if (!(nameL >= 2 && nameL <= 16)) {
        return false;
    }
    if (!(descriptionL >= 4)) {
        return false;
    }
    return true;

}
async function isAdmin() {
    let user = await getUserByLogin();
    console.log(user.userType.userType === 'ROLE_ADMIN');
    if(user.userType.userType === 'ROLE_ADMIN')
        return true;
    else return false;
}

async function genOrdersInfo() {
    let token = localStorage.getItem('token');
    let someList = document.querySelector('.results');
    someList.innerHTML = '';
    let data = await getAllOrders();
    let showed = data.length;
    if (showed > end) {
        showed = end
    }
    for (let i = start; i < showed; i++) {
        let genDiv = div('Order_enemy');
        let genP1 = p('Id: '+ data[i].ordersId + 'count: ' + data[i].count +
            '<br/>Period:<br/>' + data[i].startRent + '<br/>' + data[i].endRent + '<br/>Scooter name:' + data[i].scooter.name);

        let genBut = buttonWithParams('delete', 'inlineBl');
        genBut.onclick = async () => {
            await deleteOrder(data[i]);
        };
        someList.appendChild(genDiv);
        genDiv.appendChild(genP1);
        genDiv.appendChild(genBut);
    }
}