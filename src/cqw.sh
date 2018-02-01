server {
    listen 8001;
    server_name my129socket.ru www.my129socket.ru;
    location / {
        proxy_pass http://127.0.0.1:8181;
        proxy_http_version 1.1;
        proxy_set_header Upgrade $http_upgrade;
        proxy_set_header Connection "Upgrade";
    }
}


/*
ws = new WebSocket("ws://my129socket.ru:8001/consoleappsample");
ws.onopen = e => console.warn(e);
ws.onmessage = e => console.warn(e);

*/
