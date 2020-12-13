function button(onclick=null , innerHtml) {
    let button = document.createElement('button');
    button.innerHTML = innerHtml;
    button.onclick = onclick;
    return button
}
function buttonWithParams(innerHtml, class_ = '') {
    let button = document.createElement('button');
    button.innerHTML = innerHtml;
    button.className = class_;
    return button
}
function input(type , id ,placeHolder='',value='' , name='') {
    let input = document.createElement('input');
    input.type = type;
    input.id = id;
    input.placeholder = placeHolder;
    input.value=value;
    input.name=name;
    return input;
}
function a(href,innerHtml) {
    let a = document.createElement('a');
    a.href=href;
    a.innerHTML=innerHtml;
    return a;
}
function div(class_='') {
    let div = document.createElement('div');
    div.className = class_;
    return div;
}

function p(innerHtml) {
    let p =  document.createElement('p');
    p.innerHTML=innerHtml;
    p.className = 'inlineBl';
    return p;

}
function label(innerHtml) {
    let label = document.createElement('label')
    label.innerHTML=innerHtml;
    return label;
}

function br() {
    return document.createElement('br');
}