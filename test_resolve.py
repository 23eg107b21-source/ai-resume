import socket
chars = 'abcdefghijklmnopqrstuvwxyz0123456789'
for c in chars:
    h = f'mysql-7b75c3b-anurag-08cd.{c}.aivencloud.com'
    try:
        socket.gethostbyname(h)
        print(f"Found valid hostname: {h}")
    except socket.error:
        pass
