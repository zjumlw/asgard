function createXMLHttp() {
    let xmlHttp;
    if (window.XMLHttpRequest) {
        xmlHttp = new XMLHttpRequest();
    } else {
        xmlHttp = new ActiveXObject("Mircosoft.XMLHTTP")
    }
    return xmlHttp;
}

