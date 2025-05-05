import hashlib

a = input()
md5hash = hashlib.md5(a.encode())
print(md5hash.hexdigest())
sha = hashlib.sha512(a.encode())
print(sha.hexdigest())