async function subUser(listProjectElement) {
    let token = localStorage.getItem('token');
    let userData = await getUserByToken(token);
    let text = await userData.text();
    let textUserData = JSON.parse(text);
    let errMes = document.getElementById('errMes');
    let isNotSubed = await isSubscribed({user:textUserData , project:listProjectElement},token);
    if(isNotSubed.ok){
        await createUserProject({user:textUserData , project:listProjectElement},token);
        errMes.innerHTML = "subbed on product -" + listProjectElement['name'];
    }else{
        errMes.innerHTML = "u've already sub on this product -" + listProjectElement['name'];
    }

}
async function deleteOrder(order){
    let token = localStorage.getItem('token');
    return await fetch("/order/deleteById", {
        method: "DELETE",
        body: JSON.stringify(order.ordersId),
        headers: {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${token}`,
        }
    });
}

async function delScooter(scooter){
    let token = localStorage.getItem('token');
    return await fetch("/admin/deleteScooterById", {
        method: "DELETE",
        body: JSON.stringify(scooter.id),
        headers: {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${token}`,
        }
    });
}

async function regOrder(scooter){
    let user  = await getUserByLogin();
    console.log(scooter);
    console.log(user);
    let now = new Date();
    let afterWeek = now;
    afterWeek.setDate(afterWeek.getDay() + 7);
    let data = {
        count: scooter.price,
        startRent: now,
        endRent:  afterWeek,
        user: user,
        scooter: scooter
    };
    console.log(data);
    return  await fetch("/order", {
        method: "POST",
        headers: {
            'content-type': 'application/json'
        },
        body: JSON.stringify(data)
    });
}
function genPrevOrder() {
    let div = document.querySelector('.nextPrev');
    let logoutBtn = button(prev, '<--');
    div.appendChild(logoutBtn)
}
async function genUserOrders(){
    let someList = document.querySelector('.results');
    someList.innerHTML = '';
    let data = await getAllUserOrders();
    let showed = data.length;
    if (showed > end) {
        showed = end
    }
    for (let i = start; i < showed; i++) {
        let genDiv = div('Order_enemy');
        let genP1 = p('Id: '+ data[i].ordersId + 'count: ' + data[i].count +
            '<br/>Period:<br/>' + data[i].startRent + '<br/>' + data[i].endRent + '<br/>Scooter name:' + data[i].scooter.name + '<br/>');

        let genBut = buttonWithParams('delete', 'inlineBl');
        genBut.onclick = async () => {
            await deleteOrder(data[i]);
        };
        someList.appendChild(genDiv);
        genDiv.appendChild(genP1);
        genDiv.appendChild(genBut);

    }
}
async function genListOfProjectsForUser() {
    document.getElementsByClassName('someList')[0].style = "overflow-y: hidden ";
    let someList = document.querySelector('.someList');
    someList.innerHTML = '';
    let data = await getAllScooters();
    let showed = data.length;
    if (showed > end) {
        showed = end
    }
    for (let i = start; i < showed; i++) {
        let genDiv = div('Scooter_enemy_from_User');
        let genP1 = p('Id: '+ data[i].id + 'Scooter: ' + data[i].name + ' Price:' + data[i].price);
        let genBut = buttonWithParams('GetOrder', 'inlineBl');

        genBut.onclick = async () => {
            await regOrder(data[i]);
        };
        genDiv.appendChild(genP1);
        genDiv.appendChild(genBut);
        someList.appendChild(genDiv);
    }
}
