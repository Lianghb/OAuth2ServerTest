测试

1、
    curl -H "Accept: application/json" my-client-with-secret:secret@localhost:8082/oauth/token -d grant_type=client_credentials

    返回
        {"access_token":"1bd34499-dc86-4b9c-89e1-a865b092e3a7","token_type":"bearer","expires_in":43199,"scope":"read"}

    TOKEN=1bd34499-dc86-4b9c-89e1-a865b092e3a7

    curl -H "Authorization: Bearer $TOKEN" localhost:8082/

    返回
        Hello world!


2、
    curl -H "Accept: application/json" my-client-with-secret:secret@localhost:8082/oauth/token -d grant_type=password -d username=user -d password=123456

    返回
        {"access_token":"22a6ec36-9c77-45d0-8d10-c1d5701554c1","token_type":"bearer","expires_in":43199,"scope":"read"}

    curl -H "Authorization:Bearer 22a6ec36-9c77-45d0-8d10-c1d5701554c1" localhost:8082/
    返回
        Hello world!

3、
    curl -H "Accept: application/json" client1:123456@localhost:8082/oauth/token -d grant_type=password -d username=user -d password=123456
    返回
    {"access_token":"6e0e24f9-80c4-470b-a4b4-f540fcacfe34","token_type":"bearer","refresh_token":"849e27e4-d3a1-49f2-85f9-7a665abb1e3a","expires_in":59,"scope":"read write trust"}

    一分钟后输入以下命令
    curl -H "Authorization: Bearer 6e0e24f9-80c4-470b-a4b4-f540fcacfe34" localhost:8082
    返回
    {"error":"invalid_token","error_description":"Access token expired: 6e0e24f9-80c4-470b-a4b4-f540fcacfe34"}


4、
    curl -H "Accept: application/json" client1:123456@localhost:8082/oauth/token -d grant_type=password -d username=user -d password=123456
    返回
    {"access_token":"ab3acc09-9ba8-414f-828e-b554cddbc8a6","token_type":"bearer","refresh_token":"49dcfb37-5791-4c6d-92a1-88a43247d801","expires_in":59,"scope":"read write trust"}

    curl -H "Authorization: Bearer ab3acc09-9ba8-414f-828e-b554cddbc8a6" localhost:8082/me
    返回
    Hello, user! WelCome to OAuth2 World!