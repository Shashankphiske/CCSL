# importing AES
from Cryptodome.Cipher import DES
# encryption key
key = b'C&F)H@Mc'
# create new instance of cipher
cipher = DES.new(key, DES.MODE_EAX)
# data to be encrypted
data = "Welcome to copyassignment.com!".encode()
# nonce is a random value generated each time we instantiate the cipher using new()
nonce = cipher.nonce
# encrypt the data
ciphertext = cipher.encrypt(data)
# print the encrypted data
print("Cipher text:", ciphertext)
# generate new instance with the key and nonce same as encryption cipher
cipher = DES.new(key, DES.MODE_EAX, nonce=nonce)
# decrypt the data
plaintext = cipher.decrypt(ciphertext).decode()

print("Plaint text :", plaintext)